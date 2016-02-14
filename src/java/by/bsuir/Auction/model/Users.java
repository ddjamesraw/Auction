/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.model;

/**
 *
 * @author DDJames
 */
public class Users {
    private int id_User;
    private String Name;
    private String secondName;
    private String Birthday;
    private String userLogin;
    private String userPassword;
    private int userRate;
    
    public int getId_User() {
        return id_User;
    }

    public int getUserRate() {
        return userRate;
    }

    public Users() {
    }

    public void setUserRate(int userRate) {
        this.userRate = userRate;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public Users(int id_User, String Name, String secondName, String Birthday, String userLogin, String userPassword, int userRate) {
        this.id_User = id_User;
        this.Name = Name;
        this.secondName = secondName;
        this.Birthday = Birthday;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userRate = userRate;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

  

    public String getName() {
        return Name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getBirthday() {
        return Birthday;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    
}
