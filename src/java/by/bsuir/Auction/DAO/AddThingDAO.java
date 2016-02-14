/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.DAO;

import by.bsuir.Auction.DBconnector.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



public class AddThingDAO {
    
    Connector dbCon = new Connector();
    
    public void addThing(String Name, String goodsDescription, int serialNumber, int marketValue, int timerBegin, int startBid, int Step ){
        String query = "Insert into Goods (Name, GoodsDescription, SerialNumber, MarketValue, TimerBegin, StartBid, Step) VALUES ('"+Name+"','"+goodsDescription+"',"+serialNumber+","+marketValue+","+timerBegin+","+startBid+", "+Step+")";
         SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String strDate = "";
        String thirdQuery = "select Goods.ID_Goods from Goods where Goods.SerialNumber = "+serialNumber;
        try {
            dbCon.CreateConnection().executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println("Не могу добавить в базу. Обратитесь к разработчику.");
        }
        ResultSet rs = null;
        
        int id_Goods = 0;
        try {
            rs = dbCon.CreateConnection().executeQuery(thirdQuery);
        } catch (SQLException ex) {
            System.err.println("BLALA");
        }
        try {
            while(rs.next()){
               id_Goods = Integer.parseInt(rs.getString("ID_Goods"));
                
            }
        } catch (SQLException ex) {
            System.err.println("blablabla");
        }
        strDate=sdfDate.format(now);
        String secondQuery = "insert into AuctionLog(ID_Goods,CurrentBid,CurrentTimer,lastUserAction) values("+id_Goods+","+startBid+",'"+strDate+"','admin')"; 
        try {
            dbCon.CreateConnection().executeUpdate(secondQuery);
        } catch (SQLException ex) {
            System.err.println("Не могу добавить в базу. Обратитесь к разработчику.");
        }
    }
    
}
