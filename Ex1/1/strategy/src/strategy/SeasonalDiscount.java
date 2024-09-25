package strategy;

import utils.Logger;

public class SeasonalDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        Logger.info("Seasonal discount applied: 10%");
        return price * 0.9;
    }
}
