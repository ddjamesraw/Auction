/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.DAO.LoginDAO;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author DDJames
 */
public class LoginAction implements Command {

    LoginDAO loginDAO = new LoginDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("MenuString", MenuFactory.getInstance().getMenu("MainPage").toHtml());
        
        if (!(request.getSession().getAttribute("role").equals("guest") || request.getSession().getAttribute("role").equals("login"))) {

            request.getSession().setAttribute("role", "guest");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/UserLogin.jsp");
            dispatcher.forward(request, response);
        }



        if (request.getSession().getAttribute("role").equals("guest")) {

            request.getSession().setAttribute("role", "login");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/UserLogin.jsp");
            dispatcher.forward(request, response);

        } else {

            String userLogin = (String) request.getParameter("login");
            String userPassword = (String) request.getParameter("password");

            if ((userLogin == null) || (userPassword == null)) {
                request.getSession().setAttribute("role", "guest");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/UserLogin.jsp");
                dispatcher.forward(request, response);
            }
            if (!userLogin.isEmpty() && !userPassword.isEmpty()) {
                try {
                    loginDAO.login(userLogin, userPassword);
                    if (loginDAO.getUsersList().isEmpty()) {

                        request.getSession().setAttribute("role", "guest");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/ErrorLoginPage.jsp");
                        dispatcher.forward(request, response);
                    } else {

                        request.getSession().setAttribute("role", userLogin);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/GoodsPage.jsp");
                        dispatcher.forward(request, response);
                    }
                } catch (SQLException ex) {
                    request.getSession().setAttribute("role", "guest");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/ErrorLoginPage.jsp");
                    dispatcher.forward(request, response);
                } catch (ClassNotFoundException ex) {
                }
            }
        }

    }
}
