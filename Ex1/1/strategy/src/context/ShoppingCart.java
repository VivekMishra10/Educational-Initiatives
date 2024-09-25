package context;

import strategy.DiscountStrategy;
import utils.Logger;

public class ShoppingCart {
    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateFinalPrice(double price) {
        if (discountStrategy == null) {
            Logger.error("No discount strategy set!");
            throw new IllegalStateException("Discount strategy is not set");
        }
        return discountStrategy.applyDiscount(price);
    }
}
