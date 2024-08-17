package processor;

import database.CurrencyNotesDB;

public class SimpleMoneyHandler implements MoneyHandler {
    CurrencyNotesDB mainMemoryCurrencyNotesDB;
    public SimpleMoneyHandler(CurrencyNotesDB mainMemoryCurrencyNotesDB) {
        this.mainMemoryCurrencyNotesDB = mainMemoryCurrencyNotesDB;
    }
    @Override
    public void handle(int amount) {

    }
}
