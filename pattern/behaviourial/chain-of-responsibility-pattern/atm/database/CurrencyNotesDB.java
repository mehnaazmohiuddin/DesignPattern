package database;

import model.CurrencyNote;

public interface CurrencyNotesDB {
    boolean addNotes(CurrencyNote[] notes);
    boolean removeNotes(CurrencyNote[] notes);
    boolean modifyNote(CurrencyNote note, CurrencyNote newNote) throws Exception;

    CurrencyNote[] getNotes();
}
