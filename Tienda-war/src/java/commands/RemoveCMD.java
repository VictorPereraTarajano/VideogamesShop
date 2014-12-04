package commands;

import interfaces.ICatalog;
import interfaces.IShoppingCart;

public class RemoveCMD extends FrontCommand {

    @Override
    public void process() {

        IShoppingCart cart = getCart(getSession());
        ICatalog catalog = getCatalog();
        
        cart.removeProduct(catalog, Integer.parseInt(request.getParameter("productID")));
        
        forward(request, response, "/views/CartView.jsp");
    }
}
