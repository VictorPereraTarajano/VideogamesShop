
package discount.productdiscount;

import discount.Discount;
import java.util.Random;
import entities.Product;

public class RandomDiscount extends Discount {
    
    @Override
    public double apply(Product product, int amount) {
        if (new Random().nextInt((10 - 0) + 1) + 0 < 5) {
           double rateValue = (double) 20 / 100;
           return product.getPricePerUnit() - (product.getPricePerUnit()*rateValue);
        }
        return 0;
    } 
}
