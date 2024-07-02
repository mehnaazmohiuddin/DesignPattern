package listeners;

import model.Listener;
import model.RelianceStockPrice;
import model.StockPrice;
import java.util.PriorityQueue;

public class AverageRender implements Listener {
    StockPrice stockPrice ;
    int currentData;
    int sizeSeenSoFar =0;
    int currentAvg = 0;
    int prevAvg = 0 ;
    public  AverageRender (){
        stockPrice = new RelianceStockPrice();
        stockPrice.addListener(this);

    }

    @Override
    public void update(Object o) {
        ((StockPrice)o).getPrice();
        currentData = ((StockPrice)o).getPrice();
        currentAvg = (prevAvg*sizeSeenSoFar + currentData)/(sizeSeenSoFar+1);
        prevAvg = currentAvg;
        sizeSeenSoFar++;
        updateData();
    }

    private void updateData() {
        reRender();
    }

    public void reRender(){
        System.out.println("Current avg is ");
        System.out.println(currentAvg);
    }
}
