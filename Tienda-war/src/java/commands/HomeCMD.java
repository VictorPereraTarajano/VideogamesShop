package commands;

import javax.servlet.http.HttpSession;
import interfaces.ICatalog;
import interfaces.IShoppingCart;
import interfaces.IStadistics;

public class HomeCMD extends FrontCommand {
    
    @Override
    public void process() {

        HttpSession session = this.getSession();

        IShoppingCart cart = getCart(session);
        ICatalog catalog = getCatalog();
        IStadistics stats = getStadistics();
        
        stats.setNumAccess(stats.getNumAccess() + 1);
        
        catalog.applyProductDiscounts();
        
        session.setAttribute("ShoppingCart", cart);
        
        forward(request, response, "/views/HomeView.jsp");
    }
}
