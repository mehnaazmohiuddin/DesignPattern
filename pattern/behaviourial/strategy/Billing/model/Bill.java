package Billing.model;

import java.util.List;

public interface Bill {
    int generateBill(List<Item> items, User user);
}
