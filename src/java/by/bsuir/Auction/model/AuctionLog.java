/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.model;

/**
 *
 * @author DDJames
 */
public class AuctionLog {
    private int id_Log;
    
    private int id_Goods;
    private int currentBid;
    private String currentTime;
    private String lastUserAction;

    public AuctionLog(int id_Log, int id_Goods, int currentBid, String currentTime, String lastUserAction) {
        this.id_Log = id_Log;
        this.id_Goods = id_Goods;
        this.currentBid = currentBid;
        this.currentTime = currentTime;
        this.lastUserAction = lastUserAction;
    }

    public void setId_Log(int id_Log) {
        this.id_Log = id_Log;
    }

    public void setId_Goods(int id_Goods) {
        this.id_Goods = id_Goods;
    }

    public void setCurrentBid(int currentBid) {
        this.currentBid = currentBid;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public void setLastUserAction(String lastUserAction) {
        this.lastUserAction = lastUserAction;
    }

    public AuctionLog() {
    }

    public int getId_Log() {
        return id_Log;
    }

    public int getId_Goods() {
        return id_Goods;
    }

    public int getCurrentBid() {
        return currentBid;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public String getLastUserAction() {
        return lastUserAction;
    }

   

    
    
}
