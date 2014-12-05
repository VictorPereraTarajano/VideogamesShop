package discount.type;

import discount.Discount;
import entities.Product;

public class TwoForOne extends Discount {
    
    @Override
    public double apply (Product product, int amount) {
        if (amount == 1) 
            return 0;
        else { 
            if (amount % 2 == 0) 
                 return product.getPricePerUnit()*(amount/2);
            else 
                return (product.getPricePerUnit()*((amount-1)/2));
        }
    }

    @Override
    public double apply(double subtotal) {
        return 0;
    }
  
}
