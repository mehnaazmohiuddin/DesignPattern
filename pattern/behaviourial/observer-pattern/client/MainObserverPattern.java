package client;

import listeners.AverageRender;
import listeners.BarChartRender;
import model.RelianceStockPrice;

public class MainObserverPattern {
    public static  void main(String[] args) {
        RelianceStockPrice stockPrice = new RelianceStockPrice();
        BarChartRender render = new BarChartRender();
        AverageRender render1 = new AverageRender();
        stockPrice.addListener(render);
        stockPrice.addListener(render1);
        for(int i=0;i<10;i++){
            stockPrice.setPrice((int) Math.floor(Math.random()*100));
        }
        stockPrice.removeListener(render);

        for(int i=0;i<10;i++){
            stockPrice.setPrice((int) Math.floor(Math.random()*100));
        }
    }
}
