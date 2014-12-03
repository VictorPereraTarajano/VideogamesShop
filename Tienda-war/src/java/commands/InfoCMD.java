package commands;

public class InfoCMD extends FrontCommand {

    @Override
    public void process() {
        forward(request, response, "/views/InfoGameView.jsp");     
    }
    
}
