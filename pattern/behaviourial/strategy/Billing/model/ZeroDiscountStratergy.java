package Billing.model;

public class ZeroDiscountStratergy implements DiscountStratergy {
    @Override
    public int calculateDiscount(Item i, User user) {
        return 0;
    }
}
