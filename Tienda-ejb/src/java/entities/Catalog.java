package entities;

import interfaces.ICatalog;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import loader.ProductLoader;

@Stateless
public class Catalog implements ICatalog {

    public ArrayList<Product> listProduct = new ArrayList<>();
    
    @PostConstruct
    public void init () {
        new ProductLoader().load(listProduct);
    }

    @Override
    public ArrayList<Product> getCatalog() {
        return listProduct;
    } 
}
