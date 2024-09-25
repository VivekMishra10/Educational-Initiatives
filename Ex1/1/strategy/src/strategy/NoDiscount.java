package strategy;

import utils.Logger;

public class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        Logger.info("No discount applied.");
        return price;
    }
}
