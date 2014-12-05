package commands;

public class AddCMD extends FrontCommand {

    @Override
    public void process() {
        
        getCart(getSession()).addProduct(getCatalog(), Integer.parseInt(request.getParameter("productID")));

        forward(request, response, "/views/HomeView.jsp");
    }
}
