/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.DBconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



/**
 *
 * @author DDJames
 */
public class Connector {
    private static String url = "jdbc:jtds:sqlserver://localhost:1433/AuctionBase";
    private static String log = "AuctionUser";
    private static String pas = "12345";
    
    public Statement st;
    
    public Statement CreateConnection()
    {
     try
     {
         DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
         Connection connect = DriverManager.getConnection(url, log, pas);
         st = (Statement) connect.createStatement();
     }
    catch(Exception ex)
    {  
        System.err.println("Ошибка подключения с базой. Обратитесь к администратору!");
    }
        return st;
    }
}