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
public class ViewUsersAction implements Command{
    ShowAllDataDAO showAllDAO = new ShowAllDataDAO();
    List<Users> userList = new LinkedList<Users>();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("MenuString", MenuFactory.getInstance().getMenu("AdminMenu").toHtml());
        try {        
            userList = showAllDAO.showAllUsers();
        } catch (SQLException ex) {
            System.err.println("Ошибка подключения к базе");
        }
        
        request.setAttribute("users", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/AdminMainView.jsp");
        dispatcher.forward(request, response);
    }
    
}
