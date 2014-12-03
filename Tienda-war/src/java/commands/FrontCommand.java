package commands;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import interfaces.IShoppingCart;
import interfaces.ICatalog;
import interfaces.IStadistics;

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

    public IShoppingCart getCart(HttpSession session) {
        IShoppingCart cart = (IShoppingCart) session.getAttribute("ShoppingCart");
        if (cart == null) {
            try {
                return (IShoppingCart) new InitialContext().lookup("java:app/Tienda-ejb/ShoppingCart");
            } catch (NamingException ex) {
                ex.printStackTrace();
            }
        }
        return cart;
    }
    
    public ICatalog getCatalog () {
        try {
            return (ICatalog) new InitialContext().lookup("java:app/Tienda-ejb/Catalog");
        } catch (NamingException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public IStadistics getStadistics () {
            try {
                return (IStadistics) new InitialContext().lookup("java:app/Tienda-ejb/Stadistics");
            } catch (NamingException ex) {
                ex.printStackTrace();
                return null;
            }
    }

    public void forward(HttpServletRequest request, HttpServletResponse response, String to) {
        RequestDispatcher disp = context.getRequestDispatcher(to);
        try {
            disp.forward(request, response);
        } catch (ServletException | IOException | NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}
