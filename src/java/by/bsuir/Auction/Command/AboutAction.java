/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.Menu.MenuFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AboutAction implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/AboutPage.jsp");
        
        request.setAttribute("MenuString", MenuFactory.getInstance().getMenu("MainPage").toHtml());
        
        dispatcher.forward(request, response);
    }
}
