package stratergies;

import database.CurrencyNotesDB;
import model.Denomination;
import model.CurrencyNote;
import util.ImmutablePair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

import static stratergies.utils.AmountValidator.checkRequestValidity;

//4200 , 2000
public class MaxToMinDispensingStratergy implements DispensingStratergy {
    CurrencyNotesDB currencyNotesDB;
    DispensingStratergy nextDispensingStratergy;

    private CurrencyNote[] filterNotes(CurrencyNote[] notes) {
        return Arrays.stream(notes).filter(CurrencyNote::isValid).toArray(CurrencyNote[]::new);
    }

    public MaxToMinDispensingStratergy(CurrencyNotesDB currencyNotesDB, DispensingStratergy next) {
        this.currencyNotesDB = currencyNotesDB;
        this.nextDispensingStratergy = next;
    }
    private  HashMap<Integer, ArrayList<CurrencyNote>> getValidMoneyHashMap() {
        CurrencyNote[] validNotes = filterNotes(this.currencyNotesDB.getNotes());
        HashMap<Integer, ArrayList<CurrencyNote>> notes = new HashMap<>();
        Arrays.stream(validNotes).forEach(note -> {
            if (notes.containsKey(note.getDenomination().getValue()))
                notes.get(note.getDenomination().getValue()).add(note);
            else {
                ArrayList<CurrencyNote> list = new ArrayList<>();
                list.add(note);
                notes.put(note.getDenomination().getValue(), list);
            }
        });
        return notes;
    }

    @Override
    public CurrencyNote[] dispenseNotes(int moneyRequested) throws Exception {
        if(!checkRequestValidity(moneyRequested)){
            throw  new Exception("amount entered is not a valid amount "+moneyRequested);
        }
        HashMap<Integer, ArrayList<CurrencyNote>> atmNotes = getValidMoneyHashMap();
        PriorityQueue<ImmutablePair<Integer, ArrayList<CurrencyNote>>> queue = new PriorityQueue<>((o1, o2) -> o2.getLeft().compareTo(o1.getLeft()));
        queue.addAll(atmNotes.entrySet().stream().map(entry -> new ImmutablePair<>(entry.getKey(), entry.getValue())).collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
        int total = 0;
        int copyOfRequestedMoney = moneyRequested;
        ArrayList<CurrencyNote> dispensableNotes = new ArrayList<CurrencyNote>();
        while (copyOfRequestedMoney > 0 && queue.size() > 0) {
            ImmutablePair<Integer, ArrayList<CurrencyNote>> moneyPair = queue.poll();
            int denomination = moneyPair.getLeft();
            if (copyOfRequestedMoney / denomination > 0) {
                int notesRequired = (int) (double) (copyOfRequestedMoney / denomination);
                int notesThatCanBeGiven = Math.min(notesRequired, moneyPair.getRight().size());
                dispensableNotes.addAll(moneyPair.getRight().subList(0, notesThatCanBeGiven));
                total += notesThatCanBeGiven * denomination;
                copyOfRequestedMoney -= notesRequired * denomination;
            }

        }
        if (total != moneyRequested) {
            return failedToDispenseHandler(moneyRequested);
        }
        currencyNotesDB.removeNotes(dispensableNotes.toArray(new CurrencyNote[dispensableNotes.size()]));
        return dispensableNotes.toArray(new CurrencyNote[dispensableNotes.size()]);
    }

    private CurrencyNote[] failedToDispenseHandler(int copyOfAmount) throws Exception {
        if (nextDispensingStratergy != null)
            return nextDispensingStratergy.dispenseNotes(copyOfAmount);
        else
            throw new Exception("Not enough notes to dispense");
    }

    @Override
    public void setNextStratergy(DispensingStratergy next) {
        this.nextDispensingStratergy = next;
    }

    @Override
    public DispensingStratergy getNextStratergy() {
        return this.nextDispensingStratergy;
    }


}
