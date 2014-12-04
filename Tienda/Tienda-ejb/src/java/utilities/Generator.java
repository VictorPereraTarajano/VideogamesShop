package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Product;
import interfaces.IShoppingCart;

public class Generator {

    public void generateFile (HttpSession session, HttpServletRequest request) {

        IShoppingCart cart = (IShoppingCart) session.getAttribute("Cart");
        ArrayList<Product> cartList = cart.getCart();

        try {

            FileOutputStream fo = new FileOutputStream(getClass().getResource("/register/registro.txt").getPath().replaceAll("%20", " ").substring(1), true);
            OutputStreamWriter file = new OutputStreamWriter(fo, "UTF-8");
            
            file.write("\n\n**************** USER INFO **************** \n");

            file.write("*                                                      \n");

            file.write("*      Date    : " + cart.getDate() + "\n");
            file.write("*      Name    : " + session.getAttribute("name") + "\n");
            file.write("*      Surname : " + session.getAttribute("surname") + "\n");
            file.write("*      Email   : " + session.getAttribute("email") + "\n");
            file.write("*      Card    : " + session.getAttribute("cardnumber")+ "\n");
            file.write("*      MM/YY   : " + session.getAttribute("mmyy") + "\n");
            file.write("*      CVC     : " + session.getAttribute("cvc") + "\n");

            file.write("*\n");
            
            String format = "      %-10s %-10s %-10s %-10s%n";
                    
            if (!cartList.isEmpty()) {
                file.write("*********************** SHOPPING CART ***********************\n");
                file.write("*   ID          PRODUCT             PRIZE          CODE     *\n");
                for (Product product : cartList) {
                    try {
                        file.write(String.format(format, product.getID(),product.getName(),product.getPrize(),RandomStringGenerator.generateRandomString(8, RandomStringGenerator.Mode.ALPHA)));
                    } catch (Exception ex) {
                        Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            file.write("-------------------------------------------------\n");
            file.write("                    TOTAL : " + cart.getTotal() + " €\n\n");
            file.flush();
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("Cart", cart);
    }

}
