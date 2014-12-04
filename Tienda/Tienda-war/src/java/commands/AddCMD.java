package commands;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import model.IShoppingCart;
import model.Product;

public class AddCMD extends FrontCommand {

    @Override
    public void process() {
        HttpSession session = this.getSession();
        IShoppingCart cart = getCart(session);

        ArrayList<Product> cartList = cart.getCart();
        int productID = Integer.parseInt(request.getParameter("productID"));

        //cartList.add(catalog.loadProducts("products/products.txt").get(productID - 1));

        session.setAttribute("Cart", cart);
        forward(request, response, "/views/HomeView.jsp");
    }
}
