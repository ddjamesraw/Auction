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

/**
 *
 * @author DDJames
 */
public class StatisticAdminAction implements Command{
    ShowAllDataDAO showAllDataDAO = new ShowAllDataDAO();
    List<Goods> goodsList = new LinkedList<Goods>();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("MenuString", MenuFactory.getInstance().getMenu("AdminMenu").toHtml());
             try{        
            goodsList = showAllDataDAO.showLatestSales();
                 }
             catch(SQLException e){
                 System.err.println("123");
             }
        request.setAttribute("statistic", goodsList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/StatisticAdminPage.jsp");
        dispatcher.forward(request, response);
        
    }
}
