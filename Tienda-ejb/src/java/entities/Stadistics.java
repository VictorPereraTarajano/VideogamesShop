
package entities;

import interfaces.IShoppingCart;
import interfaces.IStadistics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class Stadistics implements IStadistics {

    private int numAccess, numAccessShoppingCart,numSuccesfulBuys;
    private double total;
    private Map<Product, Integer> mostPurchasedProducts;
    
    @PostConstruct
    private void init () {
        mostPurchasedProducts = new TreeMap<>();
    }
    
    @Lock(LockType.READ)    
    @Override
    public int getNumAccess() {
        return this.numAccess;
    }
    
    @Lock(LockType.READ)
    @Override
    public int getNumAccessShoppingCart() {
        return this.numAccessShoppingCart;
    }
    
    @Lock(LockType.READ)
    @Override
    public int getNumSuccesfulBuys() {
        return this.numSuccesfulBuys;
    }
    
    @Lock(LockType.WRITE)
    @Override
    public void setNumAccess(int numAccess) {
        this.numAccess=numAccess;
    }
    
    @Lock(LockType.WRITE)
    @Override
    public void setNumAccessShoppingCart(int numAccessShoppingCart) {
        this.numAccessShoppingCart=numAccessShoppingCart;
    }
    
    @Lock(LockType.WRITE)
    @Override
    public void setNumSuccesfulBuys(int numSuccesfulBuys) {
        this.numSuccesfulBuys=numSuccesfulBuys;
    }
    
    @Lock(LockType.READ)
    @Override
    public double getTotal() {
        return this.total;
    }
    
    @Lock(LockType.WRITE)
    @Override
    public void setTotal(double total) {
        this.total=total;
    }

    @Lock(LockType.READ)
    @Override
    public List<Product> getMostPurchasedProducts(int tam) {
        List<Product> list = new ArrayList<>(mostPurchasedProducts.keySet());
        Collections.sort(list, new Comparator<Product>() {

            @Override
            public int compare(Product t, Product t1) {
                return mostPurchasedProducts.get(t1) - mostPurchasedProducts.get(t); 
            }
            
        });
              
        return list;
    }

    @Override
    public void applyMostPurchasedProducts(IShoppingCart cart) {
        for (Product product : cart.getCart().keySet()) {
            if (mostPurchasedProducts.containsKey(product)) {
                mostPurchasedProducts.put(product, mostPurchasedProducts.get(product)+1);
            } else {
                mostPurchasedProducts.put(product, 1);
            }
        }
    }   
}