package commands;

public class StatsCMD extends FrontCommand {

    @Override
    public void process() {
        forward(request, response, "/views/StadisticsView.jsp"); 
    }
    
}
