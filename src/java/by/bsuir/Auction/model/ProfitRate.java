/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.model;

/**
 *
 * @author DDJames
 */
public class ProfitRate {
    private int id;
    private int profitCount;

    public ProfitRate(int id, int profitCount) {
        this.id = id;
        this.profitCount = profitCount;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    

    public void setProfitCount(int profitCount) {
        this.profitCount += profitCount;
    }
    public void setProfitNull(){
        this.profitCount = 0;
    }

    public int getProfitCount() {
        return profitCount;
    }

    public ProfitRate() {
    }

    public ProfitRate(int profitCount) {
        this.profitCount = profitCount;
    }
    
}
