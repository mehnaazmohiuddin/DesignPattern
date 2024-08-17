package model;

public enum Denomination {

    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100),
    FIVE_HUNDRED(500),
    TWO_THOUSAND(2000);

    private int value;

    private Denomination(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
