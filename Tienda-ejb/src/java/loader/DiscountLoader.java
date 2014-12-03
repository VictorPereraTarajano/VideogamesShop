package loader;

import discount.Discount;
import discount.productdiscount.RandomDiscount;
import discount.productdiscount.Tax;
import discount.productdiscount.TemporaryDiscount;
import discount.cartdiscount.TwoForOne;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import entities.Product;

public class DiscountLoader {

    private static final String filename = "C:\\Users\\Victor\\Documents\\NetBeansProjects\\Tienda\\Tienda-ejb\\src\\java\\discounts\\discounts.txt";
    
    public void load(ArrayList<Product> list) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(";");
                list.get(Integer.parseInt(splitLine[0]) - 1).setDiscount(getDiscount(Integer.parseInt(splitLine[1])));
            }
        } catch (IOException ex) {
            
        }
    }
    
    private Discount getDiscount (int discountID) {
        switch (discountID) {
            case 0:
                    return new Tax();
            case 1:
                    return new TemporaryDiscount(25);
            case 2: 
                    return new RandomDiscount(50);
            default:
                    return new TwoForOne();
        }
    }
            
    
}
