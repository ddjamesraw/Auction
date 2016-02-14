/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.DAO.TariffDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateTariffAction implements Command {

    TariffDAO tariffDAO = new TariffDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idenrifier = request.getParameter("id");
        String tariffName = request.getParameter("tariffname");
        String rate = request.getParameter("rate");
        if ((idenrifier == null) || (tariffName == null) || (rate == null)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/UpdateTariffPage.jsp");
            dispatcher.forward(request, response);
        } else {

            tariffDAO.updateTariffDAO(Integer.parseInt(idenrifier), tariffName, Integer.parseInt(rate));
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/AdminPage.jsp");
            dispatcher.forward(request, response);
        }
    }
}
