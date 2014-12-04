
package discount.productdiscount;

import discount.Discount;
import entities.Product;

public class AmountDiscount extends Discount {

    @Override
    public double apply(Product product, int amount) {
        return 0;
    }
    
}
