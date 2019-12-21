package dao;

import entities.user;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.sql.*;

public class loginDao {

    public static void main(String[] args) {
        user auser = new user("liao","1245586921");
        loginDao loginDao = new loginDao();
        System.out.println(loginDao.checkUser(auser));
    }

    public boolean checkUser(user user1){
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/eplatform";
        String userName = "root";
        String userPassword = "1245586921";
        try {
            Class.forName(driverClassName);
            Connection connection = DriverManager.getConnection(url, userName, userPassword);
            Statement statement = connection.createStatement();

//            String sql = "select * from user where userName="
//                    + "'" + tempUserName + "'"
//                    + " and " + "'" + tempUserPassword + "'";
            String sql = "select * from user";
            ResultSet rs = statement.executeQuery(sql);
            String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAL+BvpdZBa79csVkW6cCQsOLt0WgukAf8dvTFoA3Xj2brIqxV48/VifAG90P/3Biom/KIKvpJL98fV5GcxQ8SOr12gHvhKo+Jqb4VwOZVTBlqUm0vTECXxVXjfgFScxfWLp2JYYCPc7v2Et02KCRQQyRQSXxheTWstEndEQEQinBAgMBAAECgYEAr/GQ3FYCncHnFylb9zVhh2yupb7EPzPaLh9ilcvIvotu20GRc186VWzvbItNIMDOAizPFYIuq+rA98N76QR17Cm0I7H7vm/rb3QzTVB+BmzWXi+zTkxiKjgO810Z3cvMLH6NfZjhGaCJVScoiYfReoJ1jrC5Yu7/zVOIAK26Dz0CQQDfMQ9t8llZ5jtvC13X8Tt8qiUjQQ6OptloYil3vR+VGBsFCsvWSRdhmnncldJcRs7E8bbwB3Z1Yq49pIpS5hEDAkEA26hZsMOCwusydWYEyDnMCft6Tt8GdK/k2YVKeAwwRpgNyJIcSXW5gjsFvW5Gvuyib7qaCUdHhaY5RYydixmE6wJAenKdB3HlSWgBhWuUAavsOfnSxCOmC+dH8XehTnrov9Boynxg1mBlPnwUjUt5DH0gZXZDKi6986q+8zy5Ur+75wJAGDxgAQfhYp5Ox/NErc7qu2M64H7tGGzb5EA3sj0uCmv2gV3VrylFGaBnhronJiO33HoLSuDJfG6VvR3BuDpNlwJAHf3xZFtRhej+4gVIuU4FX4CD+DXIodkgWrzh9AxBIDAhYR1Q0RP7jqoPGqlgYYdiHiaIwn0voG/gUnzmhdBlZg==";
            while (rs.next()) {
                String tempUserName = decrypt(rs.getString("userName"),privateKey);
                String tempUserPassword = decrypt(rs.getString("userPassword"),privateKey);
                System.out.println("用户名称:"+tempUserName+"用户密码:"+tempUserPassword);
                System.out.println("用户名称1:"+user1.getUserName()+"用户密码1:"+user1.getUserPassword());
                System.out.println("1:"+user1.getUserName().equals(tempUserName));
                System.out.println("2:"+user1.getUserPassword().equals(tempUserPassword));
                if (user1.getUserName().equals(tempUserName) && user1.getUserPassword().equals(tempUserPassword)){
                    return true;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String decrypt(String str, String privateKey) throws Exception{
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }



    public static String encrypt( String str, String publicKey ) throws Exception{
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

}
