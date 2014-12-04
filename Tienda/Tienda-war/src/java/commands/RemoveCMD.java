package commands;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import model.IShoppingCart;
import model.Product;

public class RemoveCMD extends FrontCommand {

    @Override
    public void process() {

        HttpSession session = this.getSession();
        IShoppingCart cart = this.getCart(session);
        
        ArrayList<Product> cartList = cart.getCart();

        int productID = Integer.parseInt(request.getParameter("productID"));
        cartList.remove(productID - 1);

        session.setAttribute("Cart", cart);
        forward(request, response, "/views/CartView.jsp");
    }
}
