/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.DAO.ShowAllDataDAO;
import by.bsuir.Auction.Menu.MenuFactory;
import by.bsuir.Auction.model.AuctionLog;
import by.bsuir.Auction.model.ErrorCatcher;
import by.bsuir.Auction.model.Goods;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetBidAction implements Command {

    ShowAllDataDAO showAllData = new ShowAllDataDAO();
    AuctionLog aucLog = new AuctionLog();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setAttribute("MenuString", MenuFactory.getInstance().getMenu("UserMenu").toHtml());
        
        String userLogin = (String) request.getSession().getAttribute("role");
        String goodsID = (String) request.getSession().getAttribute("thingID");
        int count = 0;
        count = showAllData.bidUserRateAction(userLogin);
        
        if (count > 0) {
            ErrorCatcher error = new ErrorCatcher("У вас закончились ставки. Пожалуйста, купите ещё!");
            request.setAttribute("error", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/SetBidError.jsp");
            dispatcher.forward(request, response);
        } else {
            try {
                showAllData.updateAuctionLogCurrentBid(Integer.parseInt(goodsID), userLogin);
            } catch (ParseException ex) {
                Logger.getLogger(SetBidAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            aucLog = showAllData.getAuctionLogByGoods(Integer.parseInt(goodsID));
            Goods item = showAllData.getGoodByID(Integer.parseInt(goodsID));
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/BidPage.jsp");
            
            String str = (String) request.getParameter("newbid");
            if(item.getTimerBegin() < 30 && request.getParameter("newbid")!=null){
                showAllData.updateTimerBegin(item.getId_Goods(), 30);
                item.setTimerBegin(30);
            }
            
            request.setAttribute("goodItem", item);
            request.setAttribute("auctionlog", aucLog);
            
            dispatcher.forward(request, response);
        }
    }
}
