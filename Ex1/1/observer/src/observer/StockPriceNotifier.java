package observer;

import utils.Logger;

public class StockPriceNotifier implements StockObserver {
    private String observerName;

    public StockPriceNotifier(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update(double price) {
        Logger.info(observerName + " notified of new stock price: $" + price);
    }
}
