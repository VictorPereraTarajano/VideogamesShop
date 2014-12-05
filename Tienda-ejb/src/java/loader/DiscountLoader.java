package loader;

import discount.Discount;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiscountLoader {

    private static final String filename = "C:\\Users\\Victor\\Documents\\NetBeansProjects\\Tienda\\Tienda-ejb\\src\\java\\discounts\\discounts.txt";
    
    public ArrayList<Discount> load(int ID) {
        ArrayList<Discount> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(";");
                if (Integer.parseInt(splitLine[0]) == ID) {
                    try {
                        list.add((Discount) Class.forName("discount.type."+splitLine[1]).newInstance());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                        Logger.getLogger(DiscountLoader.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
            }
        } catch (IOException ex) {         
        }
        return list;
    }          
}
