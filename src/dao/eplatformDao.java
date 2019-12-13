package dao;

import entities.production;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class eplatformDao {
    public List<production> getAllProduction(){
        List<production> productionList = new ArrayList<>();
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/eplatform";
        String userName = "root";
        String userPassword = "1245586921";
        try {
            Class.forName(driverClassName);
            Connection connection = DriverManager.getConnection(url, userName, userPassword);
            Statement statement = connection.createStatement();
            String sql = "select * from production";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                production a = new production();
                a.setProductionName(rs.getString("productionName"));
                a.setProductionPrice(rs.getString("productionPrice"));
                a.setProductionNumber(rs.getString("productionNumber"));
                productionList.add(a);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productionList;
    }
}
