/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.model;

/**
 *
 * @author DDJames
 */
public class Goods {

    private int id_Goods;
    private String Name;
    private String goodsDescription;
    private int serialNumber;
    private int marketValue;
    private int timerBegin;
    private int startBid;
    private int Step;

    public Goods(int id_Goods, String Name, String goodsDescription, int serialNumber, int marketValue, int timerBegin, int startBid, int Step) {
        this.id_Goods = id_Goods;
        this.Name = Name;
        this.goodsDescription = goodsDescription;
        this.serialNumber = serialNumber;
        this.marketValue = marketValue;
        this.timerBegin = timerBegin;
        this.startBid = startBid;
        this.Step = Step;
    }

    public Goods(String Name, String goodsDescription, int serialNumber, int marketValue, int timerBegin, int startBid, int Step) {
        this.Name = Name;
        this.goodsDescription = goodsDescription;
        this.serialNumber = serialNumber;
        this.marketValue = marketValue;
        this.timerBegin = timerBegin;
        this.startBid = startBid;
        this.Step = Step;
    }

    public Goods() {
    }

    public int getId_Goods() {
        return id_Goods;
    }

    public String getName() {
        return Name;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public int getTimerBegin() {
        return timerBegin;
    }

    public int getStartBid() {
        return startBid;
    }

    public int getStep() {
        return Step;
    }

    public void setId_Goods(int id_Goods) {
        this.id_Goods = id_Goods;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }

    public void setTimerBegin(int timerBegin) {
        this.timerBegin = timerBegin;
    }

    public void setStartBid(int startBid) {
        this.startBid = startBid;
    }

    public void setStep(int Step) {
        this.Step = Step;
    }
    
}
