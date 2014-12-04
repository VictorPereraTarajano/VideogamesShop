package discount;

import entities.Product;
import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract class Discount {
    
    public abstract double apply(Product product, int amount);
    
    public static double applyIVA (double subtotal) {
        double rate=1;
        try {
            if (Integer.parseInt(InetAddress.getLocalHost().getHostAddress().split("\\.")[0]) >= 100) {
                rate= (double) 7/100;
            } else {
                rate= (double) 21/100;
            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        return subtotal + (subtotal*rate);
    }
    
}
