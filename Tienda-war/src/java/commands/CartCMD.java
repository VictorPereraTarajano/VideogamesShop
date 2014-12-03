package commands;

import interfaces.ICatalog;
import interfaces.IShoppingCart;
import interfaces.IStadistics;
import javax.servlet.http.HttpSession;


public class CartCMD extends FrontCommand {

    @Override
    public void process() {

        HttpSession session = this.getSession();
        
        ((ICatalog) session.getAttribute("Catalog")).applyCartDiscounts((IShoppingCart) session.getAttribute("ShoppingCart"));
    
        IStadistics stats = getStadistics(session);
        
        stats.setNumAccessShoppingCart(stats.getNumAccessShoppingCart() + 1);
        
        forward(request, response, "/views/CartView.jsp"); 
    }
    
}
