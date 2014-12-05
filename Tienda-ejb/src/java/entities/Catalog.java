package entities;

import interfaces.ICatalog;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import loader.ProductLoader;

@Stateless
public class Catalog implements ICatalog {

    public ArrayList<Product> listProduct = new ArrayList<>();
    private final int numProductsPerPage = 3;
    
    @PostConstruct
    public void init () {
        new ProductLoader().load(listProduct);
    }

    @Override
    public ArrayList<Product> getCatalog() {
        return listProduct;
    }

    @Override
    public ArrayList<Product> getPage(int page) {
        if (page <= 0) page = 1;
        int numMax = listProduct.size()/numProductsPerPage;
        if (page > listProduct.size()/numProductsPerPage) page = numMax;
        ArrayList<Product> listPage = new ArrayList<>();
        int firstProduct = (page*numProductsPerPage) - numProductsPerPage;
        for (int i = firstProduct; i < (firstProduct+numProductsPerPage); i++) {
            listPage.add(listProduct.get(i));
        }
        return listPage;
    }
    
}
