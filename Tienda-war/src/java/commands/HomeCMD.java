package commands;

import javax.servlet.http.HttpSession;
import interfaces.IStadistics;

public class HomeCMD extends FrontCommand {
    
    @Override
    public void process() {

        HttpSession session = this.getSession();

        IStadistics stats = getStadistics();
        
        stats.setNumAccess(stats.getNumAccess() + 1);
        
        getCatalog().applyProductDiscounts();
        
        session.setAttribute("ShoppingCart", getCart(session));
        
        forward(request, response, "/views/HomeView.jsp");
    }
}
