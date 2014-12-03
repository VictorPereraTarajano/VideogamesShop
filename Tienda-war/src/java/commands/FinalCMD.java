package commands;

import javax.servlet.http.HttpSession;
import interfaces.IShoppingCart;
import interfaces.IStadistics;
import utilities.Generator;

public class FinalCMD extends FrontCommand {
    
    @Override
    public void process() {
        
        HttpSession session = getSession();
        IShoppingCart cart = getCart(session);
        IStadistics stats = getStadistics();

        stats.setNumSuccesfulBuys(stats.getNumSuccesfulBuys() + 1);
        stats.setTotal(stats.getTotal() + cart.getTotal());
        
        new Generator().generateFile(session, request);
        
        cart.clear();
        
        forward(request, response, "/views/FinalView.jsp");
    }
}
