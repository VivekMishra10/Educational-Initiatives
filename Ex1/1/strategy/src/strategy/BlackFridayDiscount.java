package strategy;

import utils.Logger;

public class BlackFridayDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        Logger.info("Black Friday discount applied: 50%");
        return price * 0.5;
    }
}
