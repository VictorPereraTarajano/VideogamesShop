package model;

import java.util.ArrayList;
import java.util.Date;

public interface IShoppingCart {

    public ArrayList<Product> cart = new ArrayList<>();
    public double total = 0;

    public ArrayList<Product> getCart();

    public double getTotal();

    public void setTotal(double total);
    
    public void setDate (Date date);
    
    public Date getDate ();

}
