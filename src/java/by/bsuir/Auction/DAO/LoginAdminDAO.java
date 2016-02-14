/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.DAO;

import by.bsuir.Auction.DBconnector.Connector;
import by.bsuir.Auction.model.Admins;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author DDJames
 */
public class LoginAdminDAO {

    Connector dbCon = new Connector();
    private List<Admins> adminsList = new LinkedList<Admins>();

    public List<Admins> getAdminsList() {
        return adminsList;
    }

    public void loginAdmin(String login, String password) throws SQLException, ClassNotFoundException {
        String str = "SELECT * FROM Admins WHERE AdminLogin='" + login + "' AND AdminPassword='" + password + "'";
        ResultSet resultSet = dbCon.CreateConnection().executeQuery(str);
        String id_Admin, Name, adminLogin, adminPassword;
        while (resultSet.next()) {
            id_Admin = resultSet.getString(1);
            Name = resultSet.getString(2);
            adminLogin = resultSet.getString(3);
            adminPassword = resultSet.getString(4);
            Admins admin = new Admins(Integer.parseInt(id_Admin), Name, adminLogin, adminPassword);
            adminsList.add(admin);
        }
    }
}
