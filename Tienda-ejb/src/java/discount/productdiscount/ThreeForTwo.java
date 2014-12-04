package discount.productdiscount;

import discount.Discount;
import entities.Product;

public class ThreeForTwo extends Discount {

    @Override
    public double apply(Product product, int amount) {
        if (amount < 3) 
            return 0;
        else { 
            if (amount % 3 == 0) 
                 return product.getPricePerUnit()*(amount/2);
            else 
                return (product.getPricePerUnit()*(amount/2)) + product.getPricePerUnit();
        }
    }
    
}
