/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.model;

/**
 *
 * @author DDJames
 */
public class Tariff {
    private int id_Tariff;
    private String tariffName;
    private int Rate;

    public Tariff(String Name, int Rate) {
        this.tariffName = Name;
        this.Rate = Rate;
    }

    public int getId_Tariff() {
        return id_Tariff;
    }

    public void setId_Tariff(int id_Tariff) {
        this.id_Tariff = id_Tariff;
    }

    public void setName(String Name) {
        this.tariffName = Name;
    }

    public Tariff(int id_Tariff, String Name, int Rate) {
        this.id_Tariff = id_Tariff;
        this.tariffName = Name;
        this.Rate = Rate;
    }

    public void setRate(int Rate) {
        this.Rate = Rate;
    }

    public String getName() {
        return tariffName;
    }

    public int getRate() {
        return Rate;
    }

    public Tariff() {
    }
    
}
