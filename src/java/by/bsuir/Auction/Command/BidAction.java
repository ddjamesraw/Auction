/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.DAO.ShowAllDataDAO;
import by.bsuir.Auction.Menu.MenuFactory;
import by.bsuir.Auction.model.AuctionLog;
import by.bsuir.Auction.model.Goods;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BidAction implements Command {

//    ShowAllDataDAO showAllDAO = new ShowAllDataDAO();
//    AuctionLog aucLog = new AuctionLog();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ShowAllDataDAO showAllDAO = new ShowAllDataDAO();
            AuctionLog aucLog = new AuctionLog();
            
            request.setAttribute("MenuString", MenuFactory.getInstance().getMenu("UserMenu").toHtml());
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/BidPage.jsp");
            aucLog = showAllDAO.getAuctionLogByGoods(Integer.parseInt(request.getParameter("id")));
            Goods item = showAllDAO.getGoodByID(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("goodItem", item);
            request.getSession().setAttribute("thingID", request.getParameter("id"));
            request.setAttribute("auctionlog", aucLog);
            if(item.getTimerBegin() == 0){
                request.setAttribute("winner", aucLog.getLastUserAction());
            }
            
            
            dispatcher.forward(request, response);
            
            
    }
}
