package commands;

import interfaces.IShoppingCart;
import interfaces.IStadistics;


public class CartCMD extends FrontCommand {

    @Override
    public void process() {
        
        getCatalog().applyCartDiscounts((IShoppingCart) getSession().getAttribute("ShoppingCart"));
    
        IStadistics stats = getStadistics();
        
        stats.setNumAccessShoppingCart(stats.getNumAccessShoppingCart() + 1);
        
        forward(request, response, "/views/CartView.jsp"); 
    }
    
}
