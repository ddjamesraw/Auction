/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.DAO;

import by.bsuir.Auction.DBconnector.Connector;
import by.bsuir.Auction.model.Users;
import java.util.LinkedList;
import by.bsuir.Auction.model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShowAllDataDAO {

    private List<Users> userList = new LinkedList<Users>();
    private List<Admins> adminList = new LinkedList<Admins>();
    private List<Goods> goodsList = new LinkedList<Goods>();
    private List<AuctionLog> statisticList = new LinkedList<AuctionLog>();
    private List<Tariff> tariffList = new LinkedList<Tariff>();
    private List<ProfitRate> profitRate = new LinkedList<ProfitRate>();
    Connector dbConnect = new Connector();

    public int bidUserRateAction(String userLogin) {
        int count = 0;
        String secondQuery = "update Users set Users.UserRate = UserRate -1 where Users.UserLogin ='" + userLogin + "'";
        try {

            dbConnect.CreateConnection().execute(secondQuery);
        } catch (SQLException ex) {
            System.err.println("Ошибка подключения к базе! Не могу обновить");
            count++;
            return count;
        }
        return count;
    }

    public AuctionLog getAuctionLogByGoods(int id) {
        AuctionLog aucLog = new AuctionLog();
        String id_Log, id_Goods, currentBid, currentTime, lastUserAction;
        String query = "select* from AuctionLog where AuctionLog.ID_Goods=" + id;
        ResultSet resultSet = null;
        try {
            resultSet = dbConnect.CreateConnection().executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("Не могу соединиться с базой. гетаукгудс");
        }
        try {
            while (resultSet.next()) {
                id_Log = resultSet.getString(1);
                id_Goods = resultSet.getString("ID_Goods");

                currentBid = resultSet.getString("CurrentBid");
                currentTime = resultSet.getString("CurrentTimer");
                lastUserAction = resultSet.getString("lastUserAction");
                aucLog = new AuctionLog(Integer.parseInt(id_Log), Integer.parseInt(id_Goods), Integer.parseInt(currentBid), currentTime, lastUserAction);
            }
        } catch (SQLException ex) {
            System.err.println("Не могу соединиться с базой. гетаукгудс");
        }

        return aucLog;
    }

    public void updateAuctionLogCurrentBid(int goodsID, String userLastName) throws ParseException {
        int step = 0;
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String strDate = "";
        String query = "select Goods.Step from Goods where Goods.ID_Goods=" + goodsID;
        ResultSet rs = null;
        try {
            rs = dbConnect.CreateConnection().executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("Не могу сделать запрос из гудс по айдигудса");
        }
        try {
            while (rs.next()) {
                step = Integer.parseInt(rs.getString("Step"));
            }
        } catch (SQLException ex) {
            System.err.println("Не могу сделать запрос из юзер степ");
        }

        strDate = sdfDate.format(now);
        String secondQuery = "update AuctionLog set AuctionLog.CurrentBid = AuctionLog.CurrentBid +" + step + ", AuctionLog.lastUserAction ='" + userLastName + "', AuctionLog.CurrentTimer ='" + strDate + "' where AuctionLog.ID_Goods=" + goodsID;
        try {
            dbConnect.CreateConnection().executeUpdate(secondQuery);
        } catch (SQLException ex) {
            System.err.println("Не могу апдейтнуть аукционлог");
        }
        //now = sdfDate.parse(strDate);
//         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//         Date curDate = new Date();
//         String stroka = "";
//         stroka = dateFormat.format(curDate);
         
//         System.out.println(stroka+"ХУЙ");
//         curDate = dateFormat.parse(stroka);
//        LinkedList<Date> list = new LinkedList<Date>();
//        for(int i = 0; i < 5; i++)
//        {   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date curDate = new Date();
//            String stroka = "";
//            stroka = dateFormat.format(curDate);
//            System.out.println(stroka+"ХУЙ");
//            curDate = dateFormat.parse(stroka);
//            list.add(curDate);
//        }
//        Collections.sort(list, new Comparator<Date>() {
//            @Override
//            public int compare(Date left, Date right) {
//                if (left.compareTo(right) > 0) {
//                    return 1;
//                } else if (left.compareTo(right) < 0) {
//                    return -1;
//                }
//                return 0;
//            }
//        }
//                );
//        for (int i = 0; i < list.size(); i++){
//            System.out.println(""+list.get(i).toString());
//        }
    }

    public List<Goods> showLatestSales() throws SQLException {
        goodsList.clear();
        String id_Goods, Name, goodsDescription, seriaNumber, marketValue, timerBegin, startBid, Step;
        String query = "select * from Goods where Goods.TimerBegin=0";
        ResultSet rs = null;
        try {
            rs = dbConnect.CreateConnection().executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("хуй");
        }
        try {

            while (rs.next()) {
                id_Goods = rs.getString(1);
                Name = rs.getString(2);
                goodsDescription = rs.getString(3);
                seriaNumber = rs.getString(4);
                marketValue = rs.getString(5);
                timerBegin = rs.getString(6);
                startBid = rs.getString(7);
                Step = rs.getString(8);
                Goods thing = new Goods(Integer.parseInt(id_Goods), Name, goodsDescription, Integer.parseInt(seriaNumber), Integer.parseInt(marketValue), Integer.parseInt(timerBegin), Integer.parseInt(startBid), Integer.parseInt(Step));
                goodsList.add(thing);
            }
        } catch (SQLException ex) {
            System.err.println("Сосихуй");
        }

        return goodsList;
    }

    public List<ProfitRate> showAllProfitRate() throws SQLException {
        String query = "select * from ProfitRate";
        ResultSet rs = null;
        try {
            rs = dbConnect.CreateConnection().executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("Ошибка соединения с базой! ПРОФИТ");
        }
        while (rs.next()) {
            int id = Integer.parseInt(rs.getString("ID_Profit"));
            int count = Integer.parseInt(rs.getString("ProfitCount"));
            ProfitRate profit = new ProfitRate(id, count);
            profitRate.add(profit);
        }
        return profitRate;
    }

    public int calculateProfit() {
        try {
            goodsList.clear();
            profitRate.clear();
            statisticList.clear();
            String id_Goods, Name, goodsDescription, seriaNumber, marketValue, timerBegin, startBid, Step;

            String id_Log, id_Good, currentBid, currentTime, lastUserAction;
            String query = "select * from Goods where Goods.TimerBegin=0";
            String secondQuery = "select * from ProfitRate";
            String thirdQuery = "select * from AuctionLog";
            ResultSet rs = null;
            try {
                rs = dbConnect.CreateConnection().executeQuery(query);

            } catch (SQLException ex) {
                System.err.println("Error");
            }
            try {
                while (rs.next()) {
                    id_Goods = rs.getString(1);
                    Name = rs.getString(2);
                    goodsDescription = rs.getString(3);
                    seriaNumber = rs.getString(4);
                    marketValue = rs.getString(5);
                    timerBegin = rs.getString(6);
                    startBid = rs.getString(7);
                    Step = rs.getString(8);
                    Goods thing = new Goods(Integer.parseInt(id_Goods), Name, goodsDescription, Integer.parseInt(seriaNumber), Integer.parseInt(marketValue), Integer.parseInt(timerBegin), Integer.parseInt(startBid), Integer.parseInt(Step));
                    goodsList.add(thing);
                }
            } catch (SQLException ex) {
                System.err.println("Ошибка подключения к базе");
            }
            int sum = 0;
            for (Goods thing : goodsList) {
                sum += thing.getMarketValue();
            }
            rs = dbConnect.CreateConnection().executeQuery(thirdQuery);
            while (rs.next()) {
                id_Log = rs.getString(1);
                id_Good = rs.getString("ID_Goods");

                currentBid = rs.getString("CurrentBid");
                currentTime = rs.getString("CurrentTimer");
                lastUserAction = rs.getString("lastUserAction");
                AuctionLog aucLog = new AuctionLog(Integer.parseInt(id_Log), Integer.parseInt(id_Good), Integer.parseInt(currentBid), currentTime, lastUserAction);
                statisticList.add(aucLog);
            }
            int curProfit = 0;
            int finalProfit = 0;
            for (AuctionLog aucLog : statisticList) {
                curProfit += aucLog.getCurrentBid();
            }

            rs = dbConnect.CreateConnection().executeQuery(secondQuery);
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("ID_Profit"));
                int count = Integer.parseInt(rs.getString("ProfitCount"));
                ProfitRate profit = new ProfitRate(id, count);
                profitRate.add(profit);
            }



            finalProfit = (curProfit + profitRate.get(0).getProfitCount()) - sum;

            return finalProfit;
        } catch (SQLException ex) {
            System.err.println("Ошибка подключения к базе");
            return 1;
        }
    }

    public void setProfitRate(int id, int profit) {
        try {
            String query = "update ProfitRate set ProfitCount = ProfitCount+" + profit + "where ProfitRate.ID_Profit=" + id;
            dbConnect.CreateConnection().execute(query);
        } catch (SQLException ex) {
            System.err.println("Ошибка подключения с базой");
        }
    }

    public void updateTimerBegin(int id, int time) {
        String query = "update Goods set Goods.TimerBegin=" + time + "where Goods.ID_Goods = " + id;

        try {
            dbConnect.CreateConnection().execute(query);

        } catch (SQLException ex) {
            System.err.println("Соединение с базой не установлено, обратитесь к администратору! UPDATETIMER");
        }

    }

    public void updateUsersRate(String userLogin, int rate) {
        String query = "update Users set Users.UserRate=Users.UserRate+" + rate + "where Users.UserLogin ='" + userLogin + "'";
        try {
            dbConnect.CreateConnection().executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println("Соединение с базой не установлено, обратитесь к администратору! UPDATEUSERRATE");
        }
    }

    public List<Users> showAllUsers() throws SQLException {
        userList.clear();
        String query = "select * from Users";
        String id_User, Name, secondName, BirthDay, userLogin, userPassword, userRate;
        ResultSet resultSet = null;

        resultSet = dbConnect.CreateConnection().executeQuery(query);


        while (resultSet.next()) {
            id_User = resultSet.getString(1);
            Name = resultSet.getString(2);
            secondName = resultSet.getString(3);
            BirthDay = resultSet.getString(4);
            userLogin = resultSet.getString(5);
            userPassword = resultSet.getString(6);
            userRate = resultSet.getString(7);
            Users user = new Users(Integer.parseInt(id_User), Name, secondName, BirthDay, userLogin, userPassword, Integer.parseInt(userRate));
            userList.add(user);
        }


        return userList;
    }

    public List<Tariff> showAllTariffs() {
        tariffList.clear();
        String query = "select * from tariff";
        String id_Tariff, Name, Rate;
        ResultSet resultSet = null;
        try {
            resultSet = dbConnect.CreateConnection().executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("Соединение с базой не установлено, обратитесь к администратору!");
        }
        try {
            while (resultSet.next()) {
                id_Tariff = resultSet.getString(1);
                Name = resultSet.getString(2);
                Rate = resultSet.getString(3);
                Tariff tariff = new Tariff(Integer.parseInt(id_Tariff), Name, Integer.parseInt(Rate));
                tariffList.add(tariff);
            }
        } catch (SQLException ex) {
            System.err.println("Ошибка подключения к базе");
        }
        return tariffList;
    }

    public List<Admins> showAllAdmins() throws SQLException {
        adminList.clear();
        String query = "select * from Admins";
        String id_Admin, Name, adminLogin, adminPassword;
        ResultSet resultSet = null;
        try {
            resultSet = dbConnect.CreateConnection().executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("Соединение с базой не установлено, обратитесь к администратору!SHOWALLADMINS");
        }
        while (resultSet.next()) {
            id_Admin = resultSet.getString(1);
            Name = resultSet.getString(2);
            adminLogin = resultSet.getString(3);
            adminPassword = resultSet.getString(4);
            Admins admin = new Admins(Integer.parseInt(id_Admin), Name, adminLogin, adminPassword);
            adminList.add(admin);
        }

        return adminList;
    }

    public String getUserLogin(String login) throws SQLException {
        String query = "select * from Users where Users.UserLogin = '" + login + "'";
        String userLogin = null;
        ResultSet resultSet = null;
        try {
            resultSet = dbConnect.CreateConnection().executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("Соединение с базой не установлено, обратитесь к администратору!GETUSERBYLOGIN");
        }
        while (resultSet.next()) {
            userLogin = resultSet.getString("UserLogin");

        }
        return userLogin;
    }

    public Users getUserByLogin(String login) {
        String query = "select * from Users where Users.UserLogin = '" + login + "'";
        String id_User, Name, secondName, BirthDay, userLogin, userPassword, userRate;
        ResultSet resultSet = null;
        try {
            resultSet = dbConnect.CreateConnection().executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("Соединение с базой не установлено, обратитесь к администратору! GETUSERBYLOGIN");
        }
        Users user = new Users();
        try {
            while (resultSet.next()) {
                id_User = resultSet.getString(1);
                Name = resultSet.getString(2);
                secondName = resultSet.getString(3);
                BirthDay = resultSet.getString(4);
                userLogin = resultSet.getString(5);
                userPassword = resultSet.getString(6);
                userRate = resultSet.getString(7);
                user = new Users(Integer.parseInt(id_User), Name, secondName, BirthDay, userLogin, userPassword, Integer.parseInt(userRate));

            }
        } catch (SQLException ex) {
            System.err.println("Ошибка подключения к базе!");
        }

        return user;
    }

    public Goods getGoodByID(int index) {
        String query = "select * from Goods where Goods.ID_Goods = " + index;
        String id_Goods, Name, goodsDescription, seriaNumber, marketValue, timerBegin, startBid, Step;
        ResultSet resultSet = null;
        try {
            resultSet = dbConnect.CreateConnection().executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("Соединение с базой не установлено, обратитесь к администратору!GETGOODBYID");
        }
        Goods thing = new Goods();
        try {
            while (resultSet.next()) {
                id_Goods = resultSet.getString(1);
                Name = resultSet.getString(2);
                goodsDescription = resultSet.getString(3);
                seriaNumber = resultSet.getString(4);
                marketValue = resultSet.getString(5);
                timerBegin = resultSet.getString(6);
                startBid = resultSet.getString(7);
                Step = resultSet.getString(8);
                thing = new Goods(Integer.parseInt(id_Goods), Name, goodsDescription, Integer.parseInt(seriaNumber), Integer.parseInt(marketValue), Integer.parseInt(timerBegin), Integer.parseInt(startBid), Integer.parseInt(Step));
            }
        } catch (SQLException ex) {
            System.err.println("Ошибка гетгудбайид");
        }
        return thing;
    }
    
    public int getGoodsTimerByID(int index){
        int count = 0;
        String query  = "select Goods.TimerBegin from Goods where Goods.ID_Goods = "+index;
        ResultSet rs = null;
        try {
            rs = dbConnect.CreateConnection().executeQuery(query);
        } catch (SQLException ex) {
            
        }
        try {
            while(rs.next()){
                try {
                    count = Integer.parseInt(rs.getString("TimerBegin"));
                } catch (SQLException ex) {
                    
                }
            }
        } catch (SQLException ex) {
            
        }
        return count;
    }

    public List<AuctionLog> showAllLogs() throws SQLException {
        statisticList.clear();
        String query = "select * from AuctionLog";
        String id_Log, id_Goods, currentBid, currentTime, lastUserAction;
        ResultSet resultSet = null;
        try {
            resultSet = dbConnect.CreateConnection().executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("Соединение с базой не установлено, обратитесь к администратору!");
        }
        while (resultSet.next()) {
            id_Log = resultSet.getString(1);
            id_Goods = resultSet.getString("ID_Goods");

            currentBid = resultSet.getString("CurrentBid");
            currentTime = resultSet.getString("CurrentTimer");
            lastUserAction = resultSet.getString("lastUserAction");
            AuctionLog aucLog = new AuctionLog(Integer.parseInt(id_Log), Integer.parseInt(id_Goods), Integer.parseInt(currentBid), currentTime, lastUserAction);
            statisticList.add(aucLog);
        }
        return statisticList;
    }

    public List<Goods> showAllActualGoods() {
        goodsList.clear();
        String query = "select * from Goods where Goods.TimerBegin > 0";
        String id_Goods, Name, goodsDescription, seriaNumber, marketValue, timerBegin, startBid, Step;
        ResultSet resultSet = null;
        try {
            resultSet = dbConnect.CreateConnection().executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("Соединение с базой не установлено, обратитесь к администратору!SHOWALLGOODS");
        }
        try {
            while (resultSet.next()) {
                id_Goods = resultSet.getString(1);
                Name = resultSet.getString(2);
                goodsDescription = resultSet.getString(3);
                seriaNumber = resultSet.getString(4);
                marketValue = resultSet.getString(5);
                timerBegin = resultSet.getString(6);
                startBid = resultSet.getString(7);
                Step = resultSet.getString(8);
                Goods thing = new Goods(Integer.parseInt(id_Goods), Name, goodsDescription, Integer.parseInt(seriaNumber), Integer.parseInt(marketValue), Integer.parseInt(timerBegin), Integer.parseInt(startBid), Integer.parseInt(Step));
                goodsList.add(thing);
            }
        } catch (SQLException ex) {
            System.err.println("Ошибка подключения к базе");
        }
        return goodsList;
    }

    public List<Goods> showAllGoods() throws SQLException {
        goodsList.clear();
        String query = "select * from Goods";
        String id_Goods, Name, goodsDescription, seriaNumber, marketValue, timerBegin, startBid, Step;
        ResultSet resultSet = null;
        try {
            resultSet = dbConnect.CreateConnection().executeQuery(query);
        } catch (SQLException ex) {
            System.err.println("Соединение с базой не установлено, обратитесь к администратору!SHOWALLGOODS");
        }
        while (resultSet.next()) {
            id_Goods = resultSet.getString(1);
            Name = resultSet.getString(2);
            goodsDescription = resultSet.getString(3);
            seriaNumber = resultSet.getString(4);
            marketValue = resultSet.getString(5);
            timerBegin = resultSet.getString(6);
            startBid = resultSet.getString(7);
            Step = resultSet.getString(8);
            Goods thing = new Goods(Integer.parseInt(id_Goods), Name, goodsDescription, Integer.parseInt(seriaNumber), Integer.parseInt(marketValue), Integer.parseInt(timerBegin), Integer.parseInt(startBid), Integer.parseInt(Step));
            goodsList.add(thing);
        }
        return goodsList;
    }
}
