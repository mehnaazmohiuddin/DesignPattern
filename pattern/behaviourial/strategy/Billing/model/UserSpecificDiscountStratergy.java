package Billing.model;

public class UserSpecificDiscountStratergy implements  DiscountStratergy{
    @Override
    public int calculateDiscount(Item i , User user) {
        if(user.getStatus().equals("Platinum"))
            return (int)Math.floor(i.getPrice()*0.5);
        else
            return  (int)Math.floor(i.getPrice()*0.02);
    }
}
