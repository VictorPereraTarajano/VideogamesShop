package discount.cartdiscount;

import discount.Discount;
import interfaces.IShoppingCart;
import entities.Product;

public abstract class CartDiscount extends Discount {

    public CartDiscount(String name) {
        super(name);
    }
    
    public abstract void apply (IShoppingCart cart, Product product);
 
}
