/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.model;

/**
 *
 * @author DDJames
 */
public class Admins {

    private int id_Admin;
    private String Name;
    private String adminLogin;
    private String adminPassword;

    public Admins(String Name) {
        this.Name = Name;
    }

    public Admins(int id_Admin, String Name, String adminLogin, String adminPassword) {
        this.id_Admin = id_Admin;
        this.Name = Name;
        this.adminLogin = adminLogin;
        this.adminPassword = adminPassword;
    }

    public int getId_Admin() {
        return id_Admin;
    }

    public String getAdminLogin() {
        return adminLogin;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminLogin(String adminLogin) {
        this.adminLogin = adminLogin;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getName() {
        return Name;
    }

    public void setId_Admin(int id_Admin) {
        this.id_Admin = id_Admin;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Admins() {
    }
}
