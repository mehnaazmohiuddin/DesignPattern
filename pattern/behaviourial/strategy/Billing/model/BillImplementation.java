package Billing.model;

import java.util.List;

public class BillImplementation implements Bill{
    DiscountStratergy discountStratergy;

    public BillImplementation(DiscountStratergy discountStratergy){
        this.discountStratergy = discountStratergy;
    }

    @Override
    public int generateBill(List<Item> items, User user) {
       return items.stream().reduce(0, (partialPrice, item)->
        {
            return  item.getPrice() - discountStratergy.calculateDiscount(item,user ) + partialPrice;
        }, Integer::sum);
    }


}
