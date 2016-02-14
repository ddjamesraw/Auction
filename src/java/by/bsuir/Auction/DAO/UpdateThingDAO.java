/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.DAO;

import by.bsuir.Auction.DBconnector.Connector;
import java.sql.SQLException;

/**
 *
 * @author DDJames
 */
public class UpdateThingDAO {
    Connector dbConnect = new Connector();
    
    public void updateThingBySerial(int curSerial,String name, String goodsDescription, int serial,int timerBegin, int marketValue, int startBid, int Step){
           String query = "update Goods set Goods.Name='"+name+"', Goods.GoodsDescription='"+goodsDescription+"',Goods.SerialNumber="+serial+",Goods.TimerBegin="+timerBegin+",Goods.MarketValue="+marketValue+",Goods.StartBid="+startBid+",Goods.Step="+Step+"where Goods.SerialNumber="+curSerial;
        try {
            dbConnect.CreateConnection().executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println("UPDATETHING");
        }
       }
}
