package controller;

import commands.FrontCommand;
import interfaces.IStadistics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/frontcontroller"})
public class frontcontroller extends HttpServlet {
    
    @EJB
    IStadistics stats;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String str = request.getParameter("command");
            System.out.println("commands." + request.getParameter("command"));
            if (str == null) 
                str = "commands.HomeCMD";
            else
                str="commands."+str;
            FrontCommand f = (FrontCommand) Class.forName(str).newInstance();
            getServletContext().setAttribute("Stadistics", stats);
            f.init(getServletContext(), request, response);
            f.process();
        } finally {
            response.getWriter();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frontcontroller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frontcontroller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frontcontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frontcontroller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(frontcontroller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(frontcontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
