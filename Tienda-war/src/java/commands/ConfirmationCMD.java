package commands;

import javax.servlet.http.HttpSession;
import entities.Client;
import interfaces.IShoppingCart;

public class ConfirmationCMD extends FrontCommand {

    @Override
    public void process() {
        
        HttpSession session = this.getSession();

        IShoppingCart cart = (IShoppingCart) getCart(session);
        
        Client client = new Client ();
        
        client.setName(request.getParameter("name"));
        client.setSurname(request.getParameter("surname"));
        client.setEmail(request.getParameter("email"));
        client.setCardnumber(request.getParameter("cardnumber"));
        client.setMmyy(request.getParameter("mmyy"));
        client.setCvc(request.getParameter("cvc"));
        
        cart.setClient(client);
        
        forward(request, response, "/views/ConfirmationView.jsp"); 
    }
    
}
