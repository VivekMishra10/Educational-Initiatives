package subject;

import observer.StockObserver;
import utils.Logger;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<StockObserver> observers = new ArrayList<>();
    private double price;

    public void addObserver(StockObserver observer) {
        observers.add(observer);
        Logger.info(observer + " subscribed.");
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
        Logger.info(observer + " unsubscribed.");
    }

    public void setPrice(double price) {
        this.price = price;
        Logger.info("Stock price updated to: $" + price);
        notifyObservers();
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(price);
        }
    }
}
