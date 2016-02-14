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

public class DeleteTariffAction implements Command {

    TariffDAO tariffDAO = new TariffDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        if (id == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/DeleteTariffPage.jsp");
            dispatcher.forward(request, response);
        } else {
            tariffDAO.deleteTariffDAO(Integer.parseInt(id));
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/AdminPage.jsp");
            dispatcher.forward(request, response);
        }
    }
}
