package database;

import model.Denomination;
import model.CurrencyNote;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Things to think about, how much memory will be used to store notes.
 * How big the hashmap might get.
 * Should we throw warning if the size is getting too big, should it be part of
 * We should use Thread Safe hash maps
 * */
public class MainMemoryCurrencyNotesDB implements CurrencyNotesDB {
    ConcurrentHashMap <Denomination , ArrayList<CurrencyNote>>  notesDB = new ConcurrentHashMap<>();
    public  static MainMemoryCurrencyNotesDB instance ;
    private MainMemoryCurrencyNotesDB() {
        instance = this;
    }


    public static MainMemoryCurrencyNotesDB getInstance(){
        if(instance == null){
            instance =  new MainMemoryCurrencyNotesDB();

        }
       return instance;

    }

    @Override
    public boolean addNotes(CurrencyNote[] notes) {
        for(CurrencyNote note : notes){
            if(notesDB.containsKey(note.getDenomination())){
                ArrayList<CurrencyNote> temp = notesDB.get(note.getDenomination());
                temp.add(note);
                notesDB.put(note.getDenomination(),temp);
            }else{
                ArrayList<CurrencyNote> noteList = new ArrayList<>();
                noteList.add(note);
                notesDB.put(note.getDenomination(),noteList);
            }
        }
         return true;
    }


    @Override
    public boolean removeNotes(CurrencyNote[] notes) {
         for(CurrencyNote note : notes){
             if(notesDB.containsKey(note.getDenomination())){
                 ArrayList<CurrencyNote> temp = notesDB.get(note.getDenomination());
                 temp.remove(note);
                 notesDB.put(note.getDenomination(),temp);
             }
         }
        return true;
    }

    /*we can change the validity of the note here*/
    @Override
    public boolean modifyNote(CurrencyNote note, CurrencyNote newNote) throws Exception {
         if(notesDB.containsKey(note.getDenomination())){
             ArrayList<CurrencyNote> temp = notesDB.get(note.getDenomination());
             temp.remove(note);
             temp.add(newNote);
             notesDB.put(note.getDenomination(),temp);
             return true;
         }
        return false;
    }

    @Override
    public CurrencyNote[] getNotes() {
         ArrayList<CurrencyNote> notes = new ArrayList<>();
         notesDB.forEach((k,v)->{
             notes.addAll(v);
         });
         return notes.toArray(new CurrencyNote[notes.size()]);
    }
}
