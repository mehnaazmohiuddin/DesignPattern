package stratergies;

import database.CurrencyNotesDB;
import model.Denomination;
import model.CurrencyNote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static stratergies.utils.AmountValidator.checkRequestValidity;

// even if we have the highest denomination dont use it . use lesser denomination if possible
public class MultiNoteStratergy implements DispensingStratergy {
    CurrencyNotesDB currencyNotesDB;
    DispensingStratergy nextDispensingStratergy;
    private CurrencyNote[]  filterNotes(CurrencyNote[] notes){
        return Arrays.stream(notes).filter(CurrencyNote::isValid).toArray(CurrencyNote[]::new);
    }
    public MultiNoteStratergy(CurrencyNotesDB currencyNotesDB, DispensingStratergy next) {
        this.currencyNotesDB = currencyNotesDB;
        this.nextDispensingStratergy = next;
    }
    @Override
    public CurrencyNote[] dispenseNotes(int requestedMoney) throws Exception {
        if(!checkRequestValidity(requestedMoney)){
            throw  new Exception("amount entered is not a valid amount "+requestedMoney);
        }
        HashMap<Integer, ArrayList<CurrencyNote>> atmNotes = getValidMoneyHashMap();
        int total = 0;
        int copyOfRequestedMoney = requestedMoney;
        ArrayList<CurrencyNote> notesToDispense = new ArrayList<CurrencyNote>();
        while (copyOfRequestedMoney >0 && atmNotes.size() >0) {
            int currentAmount = copyOfRequestedMoney;
            for (int denominations : atmNotes.keySet()) {
              ArrayList<CurrencyNote> currentNotes = atmNotes.get(denominations);
                if(copyOfRequestedMoney - denominations >= 0 && currentNotes.size() > 0){
                    total += denominations;
                    copyOfRequestedMoney-= denominations;
                    notesToDispense.add(currentNotes.get(0));
                    currentNotes.remove(0);
                    atmNotes.put(denominations,currentNotes);
                }
            }
            if(currentAmount == copyOfRequestedMoney ){
                break;
            }
        }
        if(total != requestedMoney){
            return failedToDispenseHandler(requestedMoney);
        }else{
            currencyNotesDB.removeNotes(notesToDispense.toArray(new CurrencyNote[0]));
            return notesToDispense.toArray(new CurrencyNote[notesToDispense.size()]);
        }
    }

    @Override
    public void setNextStratergy(DispensingStratergy next) {
        this.nextDispensingStratergy = next;
    }

    @Override
    public DispensingStratergy getNextStratergy() {
        return this.nextDispensingStratergy;
    }

    private CurrencyNote[] failedToDispenseHandler(int requestedMoney) throws Exception {
        if(nextDispensingStratergy != null)
            return nextDispensingStratergy.dispenseNotes(requestedMoney);
        else
            throw new Exception("Not enough notes to dispense");
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
//    public static void main (String args []) throws Exception {
//        NotesDB myDb = MainMemoryNotesDB.getInstance();
//        Note []  notes = new Note[5];
//        notes[0] = new Indian100Note("abcd",true);
//        notes[1] = new Indian2000Note("213123",true);
//        notes[2] = new Indian500Note("12312",true);
//        notes[3] = new Indian100Note("4355",false);
//        notes[4] = new Indian100Note("4565",true);
//
//        myDb.addNotes(notes);
//        DispensingStratergy  dispensingStratergy = new MultiNoteStratergy(myDb,new MaxToMinDispensingStratergy(myDb,null));
//        Note [] notesDispensed =  dispensingStratergy.dispenseNotes(5600);
//        Arrays.stream(notesDispensed).forEach( no -> System.out.println(no.toString()));
//
//    }

}
