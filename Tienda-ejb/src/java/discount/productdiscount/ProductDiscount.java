package discount.productdiscount;

import discount.Discount;
import entities.Product;

public abstract class ProductDiscount extends Discount {

    public ProductDiscount(String name) {
        super(name);
    }
  
    public abstract void apply (Product product);
 
}
