package commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import model.IShoppingCart;

public abstract class FrontCommand {

    ServletContext context;
    HttpServletRequest request;
    HttpServletResponse response;

    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        this.context = context;
        this.request = request;
        this.response = response;
    }
    
    public abstract void process();

    public HttpSession getSession() {
        return request.getSession(true);
    }
    
    public ArrayList<Product> loadProducts(String filename) {
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
        BufferedReader br = new BufferedReader(new FileReader ("C:\\Users\\Victor\\Desktop\\Tienda\\Tienda\\Tienda-ejb\\src\\java\\products\\products.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(";");
                listProduct.add(new Product(splitLine[0], Integer.parseInt(splitLine[1]), splitLine[2], splitLine[3], Float.parseFloat(splitLine[4])));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return listProduct;
    }

    public IShoppingCart getCart(HttpSession session) {
        try {
            Context ctx = new InitialContext();
            return (IShoppingCart) ctx.lookup("java:app/Tienda-ejb/ShoppingCart");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void forward(HttpServletRequest request, HttpServletResponse response, String to) {
        RequestDispatcher disp = context.getRequestDispatcher(to);
        try {
            disp.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(FrontCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
