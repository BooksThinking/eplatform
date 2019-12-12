package dao;

import entities.user;

import java.sql.*;

public class loginDao {

//    public static void main(String[] args) {
//        user auser = new user("liao","1245586921");
//        loginDao loginDao = new loginDao();
//        System.out.println(loginDao.checkUser(auser));
//    }

    public boolean checkUser(user user1){
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/eplatform";
        String userName = "root";
        String userPassword = "1245586921";
        try {
            Class.forName(driverClassName);
            Connection connection = DriverManager.getConnection(url, userName, userPassword);
            Statement statement = connection.createStatement();
            String sql = "select * from user where userName="
                    + "'" + user1.getUserName() + "'"
                    + " and " + "'" + user1.getUserPassword() + "'";
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
