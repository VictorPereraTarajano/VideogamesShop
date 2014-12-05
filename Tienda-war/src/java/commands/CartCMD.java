package commands;

import interfaces.IStadistics;


public class CartCMD extends FrontCommand {

    @Override
    public void process() {
        
        IStadistics stats = getStadistics();
        
        stats.setNumAccessShoppingCart(stats.getNumAccessShoppingCart() + 1);
        
        forward(request, response, "/views/CartView.jsp"); 
    }
    
}
