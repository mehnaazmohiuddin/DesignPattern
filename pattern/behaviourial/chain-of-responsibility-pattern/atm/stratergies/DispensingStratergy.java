package stratergies;

import model.CurrencyNote;

public interface DispensingStratergy {
    CurrencyNote[] dispenseNotes(int amount) throws Exception;
    void setNextStratergy(DispensingStratergy next); // if i cant handle it ill set it to the next one
    DispensingStratergy getNextStratergy();

}
