/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Servlet;


import by.bsuir.Auction.Command.Command;
import by.bsuir.Auction.Command.Factory.ActionFactory;
import by.bsuir.Auction.Menu.MenuFactory;
import by.bsuir.Auction.Menu.XmlMenuReader;
import by.bsuir.Auction.Timer.TimerAction;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DDJames
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        Timer timer = new Timer();
        TimerTask task = new TimerAction();
        timer.schedule( task, 1000, 1000 );
        
        
        MenuFactory.getInstance().registerMenu("MainPage", XmlMenuReader.readMenuFromFile("D:\\Учёба\\6сем\\Курсовой\\Auction\\web\\xml\\MenuPage.xml"));
        MenuFactory.getInstance().registerMenu("UserMenu", XmlMenuReader.readMenuFromFile("D:\\Учёба\\6сем\\Курсовой\\Auction\\web\\xml\\UserMenu.xml"));
        MenuFactory.getInstance().registerMenu("AdminMenu", XmlMenuReader.readMenuFromFile("D:\\Учёба\\6сем\\Курсовой\\Auction\\web\\xml\\AdminMenu.xml"));
        
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
                Command abstractAction = new ActionFactory().defineAction(request);
                abstractAction.execute(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
