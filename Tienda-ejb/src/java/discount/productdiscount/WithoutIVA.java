package discount.productdiscount;

import discount.Discount;
import entities.Product;


public class WithoutIVA extends Discount {

    @Override
    public double apply(Product product, int amount) {
        return 0;
    }
    
}
