/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.DAO.ShowAllDataDAO;
import by.bsuir.Auction.Menu.MenuFactory;
import by.bsuir.Auction.model.ProfitRate;
import by.bsuir.Auction.model.Users;
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

public class BuyNewTariffAction implements Command {

    ShowAllDataDAO showAllDataDAO = new ShowAllDataDAO();
    Users user = new Users();
    

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setAttribute("MenuString", MenuFactory.getInstance().getMenu("UserMenu").toHtml());
        
            int tariffRate = Integer.parseInt(request.getParameter("checktarif"));
            String userSession = (String) request.getSession().getAttribute("role");
            showAllDataDAO.updateUsersRate(userSession, tariffRate);
            showAllDataDAO.setProfitRate(1, tariffRate);
            user = showAllDataDAO.getUserByLogin(userSession);
            request.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/ProfilePage.jsp");
            dispatcher.forward(request, response);
        

    }
}
