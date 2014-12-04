package commands;

import javax.servlet.http.HttpSession;

public class ConfirmationCMD extends FrontCommand {

    @Override
    public void process() {
        
        HttpSession session = this.getSession();
        
        session.setAttribute("name", request.getParameter("name"));
        session.setAttribute("surname", request.getParameter("surname"));
        session.setAttribute("email", request.getParameter("email"));
        session.setAttribute("cardnumber", request.getParameter("cardnumber"));
        session.setAttribute("mmyy", request.getParameter("mmyy"));
        session.setAttribute("cvc", request.getParameter("cvc"));
        
        forward(request, response, "/views/ConfirmationView.jsp"); 
    }
    
}
