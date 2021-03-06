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

/**
 *
 * @author DDJames
 */
public class ViewTariffsAction implements Command{
    ShowAllDataDAO showAllDAO = new ShowAllDataDAO();
    List<Tariff> tariffList = new LinkedList<Tariff>();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("MenuString", MenuFactory.getInstance().getMenu("AdminMenu").toHtml());
       
            tariffList = showAllDAO.showAllTariffs();
        
        request.setAttribute("tariffs", tariffList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/AdminMainView.jsp");
        dispatcher.forward(request, response);
    }
    
}
