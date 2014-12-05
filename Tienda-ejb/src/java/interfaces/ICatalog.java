package interfaces;

import java.util.ArrayList;
import javax.ejb.Local;
import entities.Product;

@Local
public interface ICatalog {
     
    public ArrayList<Product> getCatalog();
    
    public ArrayList<Product> getPage(int page);
    
}
