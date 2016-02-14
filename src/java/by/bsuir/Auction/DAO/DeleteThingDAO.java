/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.DAO;

import by.bsuir.Auction.DBconnector.Connector;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DDJames
 */
public class DeleteThingDAO {
    Connector dbCon = new Connector();
    
    public void deleteThingDAO(int serial){
        try {
            String query = "delete from Goods where Goods.SerialNumber ="+serial;
            dbCon.CreateConnection().executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println("Ошибка подключения к базе");
        }
    }
    
}
