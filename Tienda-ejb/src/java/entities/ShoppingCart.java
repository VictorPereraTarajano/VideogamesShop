package entities;

import discount.Discountable;
import interfaces.ICatalog;
import interfaces.IShoppingCart;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import loader.ProductLoader;

@Stateful
public class ShoppingCart extends Discountable implements IShoppingCart {

    private HashMap<Product, Integer> cart;
    private double total = 0, subtotal = 0;
    private Date date;
    private Client client;
  
    @PostConstruct
    public void init () {
        cart = new HashMap<>();
        client = new Client();
    }     
    
    @Override
    public int getTotalProducts() {
        int total=0;
        for (Product product : cart.keySet()) {
            total += cart.get(product);
        }
        return total;
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
        return this.getDiscount(cart);
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

    @Override
    public Client getClient() {
        return this.client;
    }

    @Override
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public void clear () {
        cart.clear();     
    }

    @Override
    public double getSubTotal() {
        double subtotal = 0;
        for (Entry<Product, Integer> entry : cart.entrySet()) {
            subtotal += entry.getKey().getPricePerUnit()*entry.getValue();
        }
        return subtotal;
    }

    @Override
    public boolean isEmpty() {
        return cart.isEmpty();
    }

}
