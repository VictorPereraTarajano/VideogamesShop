package discount.type;

import discount.Discount;
import java.util.Date;
import entities.Product;

public class TemporaryDiscount extends Discount {
 
    @Override
    public double apply(Product product, int amount) {
        int days1 = (int) (product.getDate().getTime() /(1000*60*60*24));
        int days2 = (int) (new Date().getTime()/(1000*60*60*24));
        double rateValue = (double) 20/100;
        if (days1 - days2 > 120 ) {
             return (product.getPricePerUnit()*rateValue)*amount;
        }
        return 0;
    }

    @Override
    public double apply(double subtotal) {
        return 0;
    }
    
}
