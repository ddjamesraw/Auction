/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.DAO.TariffDAO;
import by.bsuir.Auction.Menu.MenuFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNewTariffAction implements Command {

    TariffDAO tariffDAO = new TariffDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String tariffName = request.getParameter("tariffname");
        String rate = request.getParameter("rate");
        if ((tariffName == null) || (rate == null)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/AddNewTariffPage.jsp");
            dispatcher.forward(request, response);
        } else {
            tariffDAO.addTariffDAO(tariffName, Integer.parseInt(rate));
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/AdminPage.jsp");
            dispatcher.forward(request, response);

        }
    }
}
