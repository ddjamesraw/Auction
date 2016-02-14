/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.DAO.UpdateThingDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateThingAction implements Command {

    UpdateThingDAO updateThing = new UpdateThingDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String curSerial = request.getParameter("curserial");
        String name = request.getParameter("name");
        String goodsDescription = request.getParameter("description");
        String serial = request.getParameter("serial");
        String timerBegin = request.getParameter("timer");
        String marketValue = request.getParameter("marketvalue");
        String startBid = request.getParameter("startbid");
        String Step = request.getParameter("step");
        if ((curSerial == null) || (name == null) || (goodsDescription == null) || (serial == null) || (timerBegin == null) || (marketValue == null) || (startBid == null) || (Step == null)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/UpdateThingPage.jsp");
            dispatcher.forward(request, response);

        } else {
            updateThing.updateThingBySerial(Integer.parseInt(curSerial), name, goodsDescription, Integer.parseInt(serial), Integer.parseInt(timerBegin), Integer.parseInt(marketValue), Integer.parseInt(startBid), Integer.parseInt(Step));
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/AdminPage.jsp");
            dispatcher.forward(request, response);
        }
    }
}
