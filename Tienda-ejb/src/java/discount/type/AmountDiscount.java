package discount.type;

import discount.Discount;
import entities.Product;

public class AmountDiscount extends Discount {

    @Override
    public double apply(Product product, int amount) {
        return 0;
    }

    @Override
    public double apply(double subtotal) {
        if (subtotal > 100 ) 
            return subtotal*((double) 20/100);
        return 0;
    }
    
}
