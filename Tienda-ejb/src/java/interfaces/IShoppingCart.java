package interfaces;

import entities.Client;
import java.util.Date;
import java.util.HashMap;
import javax.ejb.Local;
import entities.Product;

@Local
public interface IShoppingCart {
    
    public int getTotalProducts ();
    
    public void addProduct (ICatalog catalog, int productID);
    
    public void removeProduct (ICatalog catalog, int productID);
    
    public HashMap<Product, Integer> getCart();

    public double getTotal();

    public void setTotal(double total);
    
    public void setDate (Date date);
    
    public double getSubTotal ();
    
    public Date getDate ();
    
    public Client getClient ();
    
    public void setClient (Client client);
    
    public void clear ();
    
    public double getDiscount(HashMap<Product, Integer> map);
    
    public boolean isEmpty ();

}
