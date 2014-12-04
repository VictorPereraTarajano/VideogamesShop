package discount.productdiscount;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import entities.Product;

public class Tax extends ProductDiscount {
    
    private static final String name="Tax";
    private int rate;
    
    public Tax() {
        super(name);
        rate=getRateByIp();
    }    
            
    @Override
    public void apply (Product product) {
        double rateValue = (double) rate/100;
        product.setPrice(product.getPricePerUnit() + (product.getPricePerUnit()*rateValue));
    }

    @Override
    public int getRated() {
        return rate;
    }
     
    @Override
    public boolean isRated() {
        return true;
    }

    private int getRateByIp() {
        try {
            if (Integer.parseInt(InetAddress.getLocalHost().getHostAddress().split("\\.")[0]) >= 100) return 7;
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        return 21;
    }
    
}
