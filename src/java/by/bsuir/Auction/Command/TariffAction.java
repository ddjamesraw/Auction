/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.DAO.ShowAllDataDAO;
import by.bsuir.Auction.Menu.MenuFactory;
import by.bsuir.Auction.model.Tariff;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TariffAction implements Command{
    ShowAllDataDAO showAllDataDAO = new ShowAllDataDAO();
    List<Tariff> listTariffs = new LinkedList<Tariff>();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            request.setAttribute("MenuString", MenuFactory.getInstance().getMenu("UserMenu").toHtml());
        
            listTariffs=showAllDataDAO.showAllTariffs();
            request.setAttribute("tariffname", listTariffs);
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/TariffPage.jsp");
                dispatcher.forward(request, response);
           
    }
}
