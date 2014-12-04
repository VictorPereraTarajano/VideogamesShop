package commands;

import javax.servlet.http.HttpSession;
import model.IShoppingCart;
import utilities.Generator;

public class FinalCMD extends FrontCommand {
    
    @Override
    public void process() {
        
        HttpSession session = this.getSession();
        IShoppingCart cart = getCart(session);

        new Generator().generateFile(session, request);
        
        clear(cart);
        session.setAttribute("Cart", cart);
        
        forward(request, response, "/views/FinalView.jsp");
    }
    
    private void clear (IShoppingCart cart) {
        cart.getCart().clear();     
    }
}
