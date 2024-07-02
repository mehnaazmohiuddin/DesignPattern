package model;

import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.List;

public abstract class Producer {
    List<Listener> allListeners;
    public void addListener( Listener  listener){
        if(allListeners  == null){
            allListeners = new ArrayList<>();
        }
        allListeners.add(listener);
   }
    public void  removeListener(Listener listener ){
        if(allListeners != null){
            allListeners.remove(listener);
        }
    }
    public abstract void notifyListeners();

}
