package interfaces;

import java.util.ArrayList;
import java.util.Date;
import model.Product;

public interface IShoppingCart {

    public ArrayList<Product> cart = new ArrayList<>();
    public double total = 0;
    //public Date date;

    public ArrayList<Product> getCart();

    public double getTotal();

    public void setTotal(double total);
    
    public void setDate (Date date);
    
    public Date getDate ();

}
