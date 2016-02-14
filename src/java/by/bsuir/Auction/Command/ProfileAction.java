/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.DAO.ShowAllDataDAO;
import by.bsuir.Auction.Menu.MenuFactory;
import by.bsuir.Auction.model.Users;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileAction implements Command {

    ShowAllDataDAO showAllDataDAO = new ShowAllDataDAO();
    Users user = new Users();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            String userSession = (String) request.getSession().getAttribute("role");
            user = showAllDataDAO.getUserByLogin(userSession);
            request.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/ProfilePage.jsp");
            
            request.setAttribute("MenuString", MenuFactory.getInstance().getMenu("UserMenu").toHtml());
            
            dispatcher.forward(request, response);
        
    }
}
