package commands;

import entities.Client;

public class ConfirmationCMD extends FrontCommand {

    @Override
    public void process() {
        
        Client client = new Client ();
        
        client.setName(request.getParameter("name"));
        client.setSurname(request.getParameter("surname"));
        client.setEmail(request.getParameter("email"));
        client.setCardnumber(request.getParameter("cardnumber"));
        client.setMmyy(request.getParameter("mmyy"));
        client.setCvc(request.getParameter("cvc"));
        
        getCart(getSession()).setClient(client);
        
        forward(request, response, "/views/ConfirmationView.jsp"); 
    }
    
}
