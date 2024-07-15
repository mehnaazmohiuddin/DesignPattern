package main;

import Billing.model.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    public static void main(String[] args) {

        User user = new User("Platinum");
        Item item = new Item("falcon",1000);
        Item item2 = new Item("beast",200);
        Item item3 = new Item("turbo",400);

        BillImplementation billImplementation = new BillImplementation(new ZeroDiscountStratergy());
        int totalPrice = billImplementation.generateBill( new ArrayList<>(Arrays.asList(item,item2,item3)),user);
        System.out.println(totalPrice);

        BillImplementation billImplementation2 = new BillImplementation(new UserSpecificDiscountStratergy());

        int totalPrice2 = billImplementation2.generateBill( new ArrayList<>(Arrays.asList(item,item2,item3)),user);
        System.out.println(totalPrice2);

        User user2 = new User("Diamond");
        int totalPrice3 = billImplementation2.generateBill( new ArrayList<>(Arrays.asList(item,item2,item3)),user2);
        System.out.println(totalPrice3);


    }
}
