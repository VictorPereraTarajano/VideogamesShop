package commands;

import javax.servlet.http.HttpSession;
import entities.Client;

public class ConfirmationCMD extends FrontCommand {

    @Override
    public void process() {
        
        HttpSession session = this.getSession();
        
        Client client = (Client) session.getAttribute("Client");
        
        client.setName(request.getParameter("name"));
        client.setSurname(request.getParameter("surname"));
        client.setEmail(request.getParameter("email"));
        client.setCardnumber(request.getParameter("cardnumber"));
        client.setMmyy(request.getParameter("mmyy"));
        client.setCvc(request.getParameter("cvc"));
        
        session.setAttribute("Client", client);
        
        forward(request, response, "/views/ConfirmationView.jsp"); 
    }
    
}
