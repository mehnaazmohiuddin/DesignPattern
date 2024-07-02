package model;

import java.util.List;

public class RelianceStockPrice extends StockPrice {

    volatile int price;
    @Override
    public void notifyListeners() {
        if(allListeners!=null){
            for (Listener listener : allListeners) {
                listener.update(this);

            }
        }


    }

    @Override
    public void setPrice(int newPrice) {
        price = newPrice;
        notifyListeners();
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
