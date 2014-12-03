
package discount.productdiscount;

import java.util.Random;
import entities.Product;

public class RandomDiscount extends ProductDiscount {
    
    private static final String name="RandomDiscount"; 
    private int rate;
        
    public RandomDiscount(int rate) {
        super(name);
        this.rate=rate;
    }
    
    @Override
    public void apply(Product product) {
    if (new Random().nextInt((10 - 0) + 1) + 0 < 10) {
           double rateValue = (double) rate / 100;
           product.setPrice(product.getPricePerUnit() - (product.getPricePerUnit()*rateValue));
        }
    } 
    
    public int getRate () {
        return this.rate;
    }

    @Override
    public boolean isRated() {
        return true;
    }
    
    @Override
    public int getRated () {
        return rate;
    }

}
