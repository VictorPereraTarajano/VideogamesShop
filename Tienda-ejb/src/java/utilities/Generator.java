package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import interfaces.IShoppingCart;
import entities.Product;
import java.util.Map.Entry;

public class Generator {

    public void generateFile (HttpSession session, HttpServletRequest request) {

        IShoppingCart cart = (IShoppingCart) session.getAttribute("ShoppingCart");
        HashMap<Product, Integer> cartList = cart.getCart();

        try {
            FileWriter fw = new FileWriter(new File("C:\\Users\\Victor\\Documents\\NetBeansProjects\\Tienda\\Tienda-ejb\\src\\java\\registro\\registro.txt"));
            BufferedWriter file = new BufferedWriter(fw);

            file.append("\n\n**************** USER INFO **************** \n");

            file.append("*                                                      \n");

            file.append("*      Date    : " + cart.getDate() + "\n");
            file.append("*      Name    : " + session.getAttribute("name") + "\n");
            file.append("*      Surname : " + session.getAttribute("surname") + "\n");
            file.append("*      Email   : " + session.getAttribute("email") + "\n");
            file.append("*      Card    : " + session.getAttribute("cardnumber")+ "\n");
            file.append("*      MM/YY   : " + session.getAttribute("mmyy") + "\n");
            file.append("*      CVC     : " + session.getAttribute("cvc") + "\n");

            file.append("*\n");
            
            String format = "      %-10s %-10s %-10s %-10s %-10s%n";
                    
            if (!cartList.isEmpty()) {
                file.append("*********************** SHOPPING CART *******************************\n");
                file.append("*   ID          PRODUCT             PRIZE          AMOUNT          CODE     *\n");
                for (Entry<Product, Integer> entry : cartList.entrySet()) {
                    Product product = entry.getKey();
                    Integer amount = entry.getValue();
                    try {
                        file.append(String.format(format, product.getID(),product.getName(),product.getPrice(),amount, RandomStringGenerator.generateRandomString(8, RandomStringGenerator.Mode.ALPHA)));
                    } catch (Exception ex) {
                        Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            file.append("-------------------------------------------------\n");
            file.append("                    TOTAL : " + cart.getTotal() + " €\n\n");
            file.flush();
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("Cart", cart);
    }

}
