package discount.productdiscount;

import java.util.Date;
import entities.Product;

public class TemporaryDiscount extends ProductDiscount {
    
    private static final String name="TemporaryDiscount";
    private int rate;
    
    public TemporaryDiscount(int rate) {
        super(name);
        this.rate=rate;
    }
    
    @Override
    public void apply(Product product) {
        int days1 = (int) (product.getDate().getTime() /(1000*60*60*24));
        int days2 = (int) (new Date().getTime()/(1000*60*60*24));
        double rateValue = (double) rate/100;
        if (days1 - days2 > 120 ) {
             product.setPrice(product.getPricePerUnit() - (product.getPricePerUnit()*rateValue));
        }
    }
    
    public int getRate() {
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
