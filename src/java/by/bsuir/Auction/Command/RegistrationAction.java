/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.DAO.RegistrationDAO;
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

public class RegistrationAction implements Command {

    RegistrationDAO registerDAO = new RegistrationDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        request.setAttribute("MenuString", MenuFactory.getInstance().getMenu("MainPage").toHtml());
        
        if (!(request.getSession().getAttribute("role").equals("guest") || request.getSession().getAttribute("role").equals("login"))) {
            
            request.getSession().setAttribute("role", "guest");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/RegistrationPage.jsp");
            dispatcher.forward(request, response);
        }


        if (request.getSession().getAttribute("role").equals("guest")) {
            
            request.getSession().setAttribute("role", "login");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/RegistrationPage.jsp");
            dispatcher.forward(request, response);

        } else {
            try {
                String userName = request.getParameter("username");
                String secondName = request.getParameter("secondname");
                String Birthday = request.getParameter("birthday");
                String userLogin = request.getParameter("login");
                String userPassword = request.getParameter("password");
                if ((userLogin == null) || (userPassword == null) || (userName == null) || (secondName == null) || (Birthday == null) || userName.isEmpty() || secondName.isEmpty() || Birthday.isEmpty() || userLogin.isEmpty() || userPassword.isEmpty()) {
                    request.getSession().setAttribute("role", "guest");
                   // RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/RegistrationPage.jsp");
                   // dispatcher.forward(request, response);
                //}
              //  if (userName.isEmpty() || secondName.isEmpty() || Birthday.isEmpty() || userLogin.isEmpty() || userPassword.isEmpty()) {
                    ErrorCatcher error = new ErrorCatcher("Вы не заполнили все поля!");
                    
                    request.setAttribute("error", error);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/RegistrationError.jsp");
                    dispatcher.forward(request, response);
                } else  {
                    int Count = registerDAO.registerUser(userName, secondName, Birthday, userLogin, userPassword);
                    if (Count == 0) {
                        request.getSession().setAttribute("role", userLogin);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/GoodsPage.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        request.getSession().setAttribute("role", "guest");
                        ErrorCatcher error = new ErrorCatcher("Пользователь с таким логином уже существует!");
                        
                        request.setAttribute("error", error);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/RegistrationError.jsp");
                        dispatcher.forward(request, response);
                    }
                }

            } catch (SQLException ex) {
                request.getSession().setAttribute("role", "guest");
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/RegistrationError.jsp");
                dispatcher.forward(request, response);
            } catch (ClassNotFoundException ex) {
                
            }
        }
    }
}
