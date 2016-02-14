/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.DAO;

import by.bsuir.Auction.DBconnector.Connector;
import by.bsuir.Auction.model.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author DDJames
 */
public class LoginDAO {
    
    Connector dbCon = new Connector();
    private List<Users> usersList = new LinkedList<Users>();

    public List<Users> getUsersList() {
        return usersList;
    }
    
    public void login(String login, String password) throws SQLException, ClassNotFoundException{
        
        String str = "SELECT * FROM Users WHERE UserLogin='" + login + "' AND UserPassword='" + password + "'";
        ResultSet rs = dbCon.CreateConnection().executeQuery(str);
        String id_User, Name, secondName, BirthDay, userLogin, userPassword, userRate;
        while(rs.next())
        {
            id_User = rs.getString(1);
            Name = rs.getString(2);
            secondName = rs.getString(3);
            BirthDay = rs.getString(4);
            userLogin = rs.getString(5);
            userPassword = rs.getString(6);
            userRate = rs.getString(7);
            Users user = new Users(Integer.parseInt(id_User), Name, secondName, BirthDay, userLogin, userPassword, Integer.parseInt(userRate));
            usersList.add(user);
        }
    }
    
}
