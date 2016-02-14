/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.DAO.ShowAllDataDAO;
import by.bsuir.Auction.Menu.MenuFactory;
import by.bsuir.Auction.model.AuctionLog;
import java.io.IOException;
import java.sql.SQLException;
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
public class StatisticAdminBidAction implements Command {

    ShowAllDataDAO showAllDAO = new ShowAllDataDAO();
    AuctionLog aucLog = new AuctionLog();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("MenuString", MenuFactory.getInstance().getMenu("AdminMenu").toHtml());
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/StatisticAdminBidPage.jsp");
        request.setAttribute("goodItem", showAllDAO.getGoodByID(Integer.parseInt(request.getParameter("id"))));
        aucLog = showAllDAO.getAuctionLogByGoods(Integer.parseInt(request.getParameter("id")));
        //request.setAttribute("goodItem", showAllDAO.getGoodByID(Integer.parseInt(request.getParameter("id"))));
        request.setAttribute("auctionlog", aucLog);

        dispatcher.forward(request, response);

    }
}
