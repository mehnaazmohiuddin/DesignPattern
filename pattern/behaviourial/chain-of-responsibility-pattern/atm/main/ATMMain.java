package main;

import database.MainMemoryCurrencyNotesDB;
import database.CurrencyNotesDB;
import model.Currency;
import model.CurrencyNote;
import model.Denomination;
import stratergies.DispensingStratergy;
import stratergies.MaxToMinDispensingStratergy;
import stratergies.MultiNoteStratergy;

import java.util.Arrays;

public class ATMMain {
    static CurrencyNotesDB currencyNotesDB;

    private static void initializeDB() {
        currencyNotesDB = MainMemoryCurrencyNotesDB.getInstance();
        CurrencyNote[] notes = new CurrencyNote[5];
        notes[0] = new CurrencyNote(Currency.INR, "abcd", true, Denomination.HUNDRED);
        notes[1] = new CurrencyNote(Currency.INR, "abcd22", true, Denomination.TWO_THOUSAND);
        notes[2] = new CurrencyNote(Currency.INR, "ab22cd22", true, Denomination.TWO_THOUSAND);
        notes[3] = new CurrencyNote(Currency.INR, "ab22cd22", true, Denomination.FIVE_HUNDRED);
        notes[4] = new CurrencyNote(Currency.INR, "ab22cd22", true, Denomination.HUNDRED);
        currencyNotesDB.addNotes(notes);
    }

    public static void main(String [] args) {
        initializeDB();
        DispensingStratergy dispensingStratergy = new MultiNoteStratergy(currencyNotesDB, new MaxToMinDispensingStratergy(currencyNotesDB, null));
        try {
            CurrencyNote[] notesDispensed = dispensingStratergy.dispenseNotes(2600);
            System.out.println("---------- Dispensing --------------");
            Arrays.stream(notesDispensed).forEach(no -> System.out.println(no.toString()));
            CurrencyNote[] notesDispensed2 = dispensingStratergy.dispenseNotes(500);
            System.out.println("---------- Dispensing --------------");
            Arrays.stream(notesDispensed2).forEach(no -> System.out.println(no.toString()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
