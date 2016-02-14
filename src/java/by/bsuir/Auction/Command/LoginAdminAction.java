/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.DAO.LoginAdminDAO;
import by.bsuir.Auction.Menu.MenuFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginAdminAction implements Command {
    LoginAdminDAO loginAdminDAO = new LoginAdminDAO();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if((request == null) || (response == null)){return;}
        
        request.setAttribute("MenuString", MenuFactory.getInstance().getMenu("MainPage").toHtml());
        
        if(!(request.getSession().getAttribute("role").equals("guest") || request.getSession().getAttribute("role").equals("login")))
            {
                
                request.getSession().setAttribute("role", "guest");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/AdminLoginPage.jsp");
                dispatcher.forward(request, response);
            }
        
        if(request.getSession().getAttribute("role").equals("guest")){
                    System.out.println(request.getSession().getAttribute("role"));
                    request.getSession().setAttribute("role", "login");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/AdminLoginPage.jsp");
                    dispatcher.forward(request, response);
                    
            }
            else 
            {
            
            String adminLogin = request.getParameter("login");
            String adminPassword = request.getParameter("password");

            if((adminLogin == null) || (adminPassword == null))
            {
                request.getSession().setAttribute("role", "guest");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/AdminLoginPage.jsp");
                dispatcher.forward(request, response);
            }
            if(!adminLogin.isEmpty() && !adminPassword.isEmpty())
            {
                try {                
                    loginAdminDAO.loginAdmin(adminLogin, adminPassword);
                    if(loginAdminDAO.getAdminsList().isEmpty())
                    {   
                        
                        request.getSession().setAttribute("role", "guest");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/ErrorLoginPage.jsp");
                        dispatcher.forward(request, response);
                    }
                    else{
                       
                       request.getSession().setAttribute("role", adminLogin);
                       request.getSession().setAttribute("loginAdmin", "loginAdmin");
                       RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/AdminPage.jsp");
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
 