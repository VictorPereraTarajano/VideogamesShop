package commands;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import interfaces.ICatalog;
import interfaces.IShoppingCart;
import entities.Product;

public class RemoveCMD extends FrontCommand {

    @Override
    public void process() {

        HttpSession session = this.getSession();
        IShoppingCart cart = this.getCart(session);
        ICatalog catalog = getCatalog();
        
        HashMap<Product, Integer> cartList = cart.getCart();

        int productID = Integer.parseInt(request.getParameter("productID"));
        
        cart.removeProduct(catalog, productID);

        cart.setUpdate(false);
        catalog.applyCartDiscounts(cart);
        
        session.setAttribute("ShoppingCart", cart);
        forward(request, response, "/views/CartView.jsp");
    }
}
