package commands;

import javax.servlet.http.HttpSession;
import model.IShoppingCart;

public class HomeCMD extends FrontCommand {
    
    public void process() {
        
        HttpSession session = this.getSession();
        IShoppingCart cart = getCart(session);
        
        
        session.setAttribute("Productos", loadProducts("/products/products.txt"));
        session.setAttribute("Cart", cart);
        
        forward(request, response, "/views/HomeView.jsp");
    }
}
