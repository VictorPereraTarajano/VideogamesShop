package commands;


public class CartCMD extends FrontCommand {

    @Override
    public void process() {
        forward(request, response, "/views/CartView.jsp"); 
    }
    
}
