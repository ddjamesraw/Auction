/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

import by.bsuir.Auction.DAO.ShowAllDataDAO;
import by.bsuir.Auction.Menu.MenuFactory;
import by.bsuir.Auction.model.Goods;
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


public class StatisticAction implements Command{
    ShowAllDataDAO showAllDataDAO = new ShowAllDataDAO();
    List<Goods> goodsList = new LinkedList<Goods>();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            
                        goodsList = showAllDataDAO.showLatestSales();
     
        } catch (SQLException ex) {
            Logger.getLogger(StatisticAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("MenuString", MenuFactory.getInstance().getMenu("UserMenu").toHtml());
        
        request.setAttribute("statistic", goodsList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/StatisticPage.jsp");
        dispatcher.forward(request, response);
    }
}

