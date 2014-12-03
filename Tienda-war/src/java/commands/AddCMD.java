package commands;

import javax.servlet.http.HttpSession;
import interfaces.ICatalog;
import interfaces.IShoppingCart;

public class AddCMD extends FrontCommand {

    @Override
    public void process() {
        
        HttpSession session = this.getSession();
        IShoppingCart cart = getCart(session);
        ICatalog catalog = getCatalog();

        int productID = Integer.parseInt(request.getParameter("productID"));
        
        cart.addProduct(catalog, productID);

        cart.setUpdate(false);
        
        session.setAttribute("ShoppingCart", cart);
        forward(request, response, "/views/HomeView.jsp");
    }
}
