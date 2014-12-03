package discount.cartdiscount;

import java.util.HashMap;
import interfaces.IShoppingCart;
import entities.Product;

public class TwoForOne extends CartDiscount {
    
    private static final String name="2x1"; 
    
    public TwoForOne() {
        super(name);
    }
    
    @Override
    public void apply (IShoppingCart cart, Product product) {
        HashMap<Product, Integer> list = cart.getCart();
        if (list.get(product) == 1) 
            product.setPrice(product.getPricePerUnit());
        else { 
            if (list.get(product) % 2 == 0) 
                 product.setPrice((product.getPricePerUnit())*(list.get(product)/2));
            else 
                product.setPrice((product.getPricePerUnit())*(list.get(product)/2) + product.getPricePerUnit());
        }
    }

    @Override
    public boolean isRated() {
        return false;
    }
  
}
