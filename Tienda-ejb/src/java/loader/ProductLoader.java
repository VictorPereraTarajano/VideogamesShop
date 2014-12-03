package loader;

import entities.Product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductLoader {
    
    public static final String filename = "C:\\Users\\Victor\\Documents\\NetBeansProjects\\Tienda\\Tienda-ejb\\src\\java\\products\\products.txt";
    
    public void load (ArrayList<Product> list) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(";");
                list.add(new Product(splitLine[0], Integer.parseInt(splitLine[1]), splitLine[2], splitLine[3], Float.parseFloat(splitLine[4])));
            }
        } catch (IOException ex) {
            
        }
    }
    
    public void load (ArrayList<Product> catalog, HashMap<Product, Integer> list, int productID) {
        Product product = catalog.get(productID);
        if (list.containsKey(product)) {
            list.put(product, list.get(product) + 1);
        } else {
            list.put(product, 1);
        }
    }

    public void unload (ArrayList<Product> catalog, HashMap<Product, Integer> list, int productID) {
        Product product = catalog.get(productID);
        if (list.get(product) == 1) {
            list.remove(product);
        } else {
            list.put(product, list.get(product) - 1);
        }
    }
    
}
