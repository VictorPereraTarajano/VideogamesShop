package entities;

import interfaces.ICatalog;
import interfaces.IShoppingCart;
import java.util.Date;
import java.util.HashMap;
import javax.ejb.Stateful;
import loader.ProductLoader;

@Stateful
public class ShoppingCart implements IShoppingCart {

    private HashMap<Product, Integer> cart = new HashMap<>();
    private double total = 0;
    private Date date;
    private boolean update = false;
  
    @Override
    public int getTotalProducts() {
        int total=0;
        for (Product product : cart.keySet()) {
            total += cart.get(product);
        }
        return total;
    }

    @Override
    public void setUpdate(boolean update) {
        this.update = update;
    }

    @Override
    public boolean isUpdate() {
        return update;
    }
    
    @Override
    public void removeProduct(ICatalog catalog, int productID) {
        new ProductLoader().unload(catalog.getCatalog(), cart , productID);
    }
    
    @Override
    public void addProduct (ICatalog catalog, int productID) {
        new ProductLoader().load(catalog.getCatalog(), cart, productID);
    }
 
    @Override
    public HashMap<Product, Integer> getCart() {
        return cart;
    }

    @Override
    public double getTotal() {
        return total;
    }

    @Override
    public void setTotal(double total) {
        this.total = total;
    }
    
    @Override
    public void setDate (Date date) {
        this.date = date;
    }
    
    @Override
    public Date getDate () {
        return this.date;
    }

}
