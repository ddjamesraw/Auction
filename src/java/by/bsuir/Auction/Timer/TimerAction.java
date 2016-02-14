/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Timer;

import by.bsuir.Auction.DAO.ShowAllDataDAO;
import by.bsuir.Auction.model.Goods;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DDJames
 */
public class TimerAction extends TimerTask{

    
    ShowAllDataDAO showAllDataDAO = new ShowAllDataDAO();
    List<Goods> goodsList = new LinkedList<Goods>();
    @Override
    public void run() {
      
        try {
            goodsList = showAllDataDAO.showAllGoods();
            
            for(int i = 0; i<goodsList.size();i++){
                if(goodsList.get(i).getTimerBegin()>0){
                    showAllDataDAO.updateTimerBegin(goodsList.get(i).getId_Goods(), goodsList.get(i).getTimerBegin()-1);
                    
                }
            }

        } catch (SQLException ex) {
           System.err.println("Ошибка соединения с базой данных. Обратитесь к поставщику!");
        }
    }
    
}
