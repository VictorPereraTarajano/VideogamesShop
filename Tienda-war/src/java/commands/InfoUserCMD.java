package commands;

public class InfoUserCMD extends FrontCommand {

    @Override
    public void process() {
        forward(request, response, "/views/InfoUserView.jsp");     
    }
    
}
