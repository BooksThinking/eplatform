package dao;

import entities.production;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class eplatformDao {

//    public static void main(String[] args) {
//        eplatformDao dao = new eplatformDao();
//        List<production> result = dao.getAllProduction();
//        System.out.println(result.get(4).getProductionName());
//        System.out.println(result.get(4).getProductionPrice());
//        System.out.println(result.get(4).getProductionNumber());
//    }

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
                a.setProductionPrice(rs.getInt("productionPrice"));
                a.setProductionNumber(rs.getInt("productionNumber"));
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
