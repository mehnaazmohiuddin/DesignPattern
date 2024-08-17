package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyNote {
    Currency currency;
    String id;
    boolean isValid;
    Denomination denomination;
}
