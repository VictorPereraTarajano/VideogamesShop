package discount.productdiscount;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import entities.Product;

public class Tax extends ProductDiscount {
    
    private static final String name="Tax"; 
    
    public Tax() {
        super(name);
    }    
            
    @Override
    public void apply (Product product) {
        try {
            if (Integer.parseInt(InetAddress.getLocalHost().getHostAddress().split("\\.")[0]) >= 100 ) {
                product.setPrice(product.getPricePerUnit() + product.getPricePerUnit()*0.07);
            } else {
                product.setPrice(product.getPricePerUnit() + product.getPricePerUnit()*0.21);
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(Tax.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean isRated() {
        return false;
    }
    
}
