/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.DAO.AddThingDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DDJames
 */
public class AddThingAction implements Command {

    AddThingDAO addThing = new AddThingDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String goodsDesctiption = request.getParameter("description");
        String serial = request.getParameter("serial");
        String timerBegin = request.getParameter("timer");
        String marketValue = request.getParameter("marketvalue");
        String startBid = request.getParameter("startbid");
        String Step = request.getParameter("step");

        if ((name == null) || (goodsDesctiption == null) || (serial == null) || (timerBegin == null) || (marketValue == null) || (startBid == null) || (Step == null)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/AddNewThingPage.jsp");
            dispatcher.forward(request, response);
        } else {
            addThing.addThing(name, goodsDesctiption, Integer.parseInt(serial), Integer.parseInt(marketValue), Integer.parseInt(timerBegin), Integer.parseInt(startBid), Integer.parseInt(Step));
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/AdminPage.jsp");
            dispatcher.forward(request, response);
        }
    }
}
