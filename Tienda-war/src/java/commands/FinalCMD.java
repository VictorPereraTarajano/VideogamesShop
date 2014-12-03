package commands;

import javax.servlet.http.HttpSession;
import interfaces.IShoppingCart;
import interfaces.IStadistics;
import utilities.Generator;

public class FinalCMD extends FrontCommand {
    
    @Override
    public void process() {
        
        HttpSession session = this.getSession();
        IShoppingCart cart = getCart(session);
        IStadistics stats = getStadistics();

        stats.setNumSuccesfulBuys(stats.getNumSuccesfulBuys() + 1);
        stats.setTotal(stats.getTotal() + cart.getTotal());
        
        new Generator().generateFile(session, request);
        
        clear(cart);
        
        forward(request, response, "/views/FinalView.jsp");
    }
    
    private void clear (IShoppingCart cart) {
        cart.getCart().clear();     
    }
}
