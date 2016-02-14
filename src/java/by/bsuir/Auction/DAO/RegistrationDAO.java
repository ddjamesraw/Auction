/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.DAO;

import by.bsuir.Auction.DBconnector.Connector;
import by.bsuir.Auction.model.Users;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author DDJames
 */
public class RegistrationDAO {

    private List<Users> usersList = new LinkedList<Users>();
    LoginDAO logDAO = new LoginDAO();
    ShowAllDataDAO allDataDAO = new ShowAllDataDAO();
    Connector dbCon = new Connector();

    public int registerUser(String Name, String secondName, String Birthday, String userLogin, String userPassword) throws SQLException, ClassNotFoundException {
        int Count = 0;
        usersList = allDataDAO.showAllUsers();
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getUserLogin().equals(userLogin)) {
                Count++;
                return Count;
            }

        }
        if (Count == 0) {
            String query = "insert into Users(Name, SecondName, Birthday, UserLogin, UserPassword) values ('" + Name + "','" + secondName + "','" + Birthday + "','" + userLogin + "','" + userPassword + "')";
            dbCon.CreateConnection().executeUpdate(query);
            logDAO.login(userLogin, userPassword);
        }
        return Count;
    }
}
