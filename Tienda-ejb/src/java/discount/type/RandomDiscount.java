package discount.type;

import discount.Discount;
import java.util.Random;
import entities.Product;

public class RandomDiscount extends Discount {
    
    private final int rate = 10;
    
    @Override
    public double apply(Product product, int amount) {
        if (new Random().nextInt((10 - 0) + 1) + 0 <= 2) {
           double rateValue = (double) rate / 100;
           return (product.getPricePerUnit()*rateValue)*amount;
        }
        return 0;
    } 

    @Override
    public double apply(double subtotal) {
        return 0;
    }

}
