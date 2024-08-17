package stratergies.utils;

import model.Denomination;

public class AmountValidator {
    public  static  boolean checkRequestValidity(int requestedMoney){
        if (requestedMoney % Denomination.TEN.getValue() != 0)
            return  false;
        else
            return true;
    }
}
