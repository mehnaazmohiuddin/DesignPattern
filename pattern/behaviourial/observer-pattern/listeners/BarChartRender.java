package listeners;

import model.Listener;
import model.RelianceStockPrice;
import model.StockPrice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BarChartRender implements Listener {
    StockPrice stockPrice ;
    int currentData;
    PriorityQueue<Integer> dataPoints;
    public  BarChartRender (){
        stockPrice = new RelianceStockPrice();
        stockPrice.addListener(this);
        dataPoints = new PriorityQueue<>(10);

    }

    @Override
    public void update(Object o) {
        ((StockPrice)o).getPrice();
         currentData = ((StockPrice)o).getPrice();
         updateData();
    }

    private void updateData() {
        dataPoints.add(currentData);
        if(dataPoints.size() == 11)
            dataPoints.poll();
        reRender();
    }

    public void reRender(){
            System.out.println("I am re freshing myself");
            System.out.println(dataPoints.toString());
    }
}
