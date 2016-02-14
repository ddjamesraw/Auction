/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.DAO;

import by.bsuir.Auction.DBconnector.Connector;
import by.bsuir.Auction.model.Admins;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DDJames
 */
public class AddNewAdminDAO {
    
    private List<Admins> adminList = new LinkedList<Admins>();
    Connector dbCon = new Connector();
    ShowAllDataDAO allDataDAO = new ShowAllDataDAO();
    
    public int registerAdmin(String Name, String adminLogin, String adminPassword)  {
        int Count = 0;
        try {
            adminList = allDataDAO.showAllAdmins();
        } catch (SQLException ex) {
            System.err.println("Ошибка подключения к базе");
        }
        for (int i = 0; i < adminList.size(); i++) {
            if (adminList.get(i).getAdminLogin().equals(adminLogin)) {
                Count++;
                return Count;
            }

        }
        if (Count == 0) {
            String query = "insert into Admins(Name, AdminLogin, AdminPassword) values ('" + Name + "','" + adminLogin + "','" + adminPassword + "')";
            try {
                dbCon.CreateConnection().executeUpdate(query);
            } catch (SQLException ex) {
                System.err.println("Ошибка подключения к базе");
            }
            
        }
        return Count;
    }
    
    
}
