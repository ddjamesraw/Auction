/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.DAO.AddNewAdminDAO;
import by.bsuir.Auction.Menu.MenuFactory;
import by.bsuir.Auction.model.ErrorCatcher;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNewAdminAction implements Command {

    AddNewAdminDAO addAdminDAO = new AddNewAdminDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("MenuString", MenuFactory.getInstance().getMenu("AdminMenu").toHtml());
        String adminName = request.getParameter("adminname");
        String userLogin = request.getParameter("login");
        String userPassword = request.getParameter("password");
        if ((userLogin == null) || (userPassword == null) || (adminName == null)) {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/AddNewAdminPage.jsp");
            dispatcher.forward(request, response);

        } else {
            
                int count = addAdminDAO.registerAdmin(adminName, userLogin, userPassword);
                if (count == 0) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/AdminPage.jsp");
                    dispatcher.forward(request, response);
                } else {
                    ErrorCatcher error = new ErrorCatcher("Пользователь с таким логином уже существует!");
                    request.setAttribute("error", error);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/AdminErrorRegistration.jsp");
                    dispatcher.forward(request, response);
                }
            
        }


    }
}
