/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminTariffAction implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/AdminTariffPage.jsp");
        dispatcher.forward(request, response);
    }
}
