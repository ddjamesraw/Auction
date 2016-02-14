/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.DAO.DeleteThingDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteThingAction implements Command {

    DeleteThingDAO deleteThingDAO = new DeleteThingDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String serial = request.getParameter("serial");
        if (serial == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/DeleteThingPage.jsp");
            dispatcher.forward(request, response);
        } else {

            deleteThingDAO.deleteThingDAO(Integer.parseInt(serial));
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/AdminPage.jsp");
            dispatcher.forward(request, response);
        }
    }
}

