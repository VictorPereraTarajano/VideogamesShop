package interfaces;

import entities.Product;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IStadistics {
     
  public int getNumAccess();
  
  public int getNumAccessShoppingCart();
  
  public int getNumSuccesfulBuys();
  
  public double getTotal ();
  
  public void setTotal (double total);
  
  public List<Product> getMostPurchasedProducts(int tam);
  
  public void applyMostPurchasedProducts(IShoppingCart cart);
  
  public void setNumAccess(int numAccess);
  
  public void setNumAccessShoppingCart(int numAccessShoppingCart);
  
  public void setNumSuccesfulBuys(int numSuccesfulBuys);
  
}
