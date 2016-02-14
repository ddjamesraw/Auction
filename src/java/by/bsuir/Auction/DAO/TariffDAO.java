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
public class TariffDAO {
    Connector dbCon = new Connector();
    
    public void addTariffDAO(String tariffName, int Rate){
        try {
            String query = "insert into Tariff(TariffName, Rate) values('"+tariffName+"',"+Rate+")";
            dbCon.CreateConnection().executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println("Ошибка подключения к базе");
        }
        
    }
    public void updateTariffDAO(int id,String tariffName, int Rate){
        try {
            String query = "update Tariff set Tariff.TariffName ='"+tariffName+"', Tariff.Rate="+Rate+"where Tariff.ID_Tariff="+id;
            dbCon.CreateConnection().executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println("Ошибка подключения к базе");
        }
    }     
        public void deleteTariffDAO(int id){
        try {
            String query ="delete from Tariff where Tariff.ID_Tariff="+id;
            dbCon.CreateConnection().executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println("Ошибка подключения к базе");
        }
        }
    }
    
    

