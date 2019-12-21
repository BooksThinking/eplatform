package dao;

import entities.production;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.sql.*;

public class registDao {

//    public static void main(String[] args) {
//        registDao dao = new registDao();
//        dao.regist("zhong","213213");
//    }

    public boolean regist(String registName,String registPassword){
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/eplatform";
        String userName = "root";
        String userPassword = "1245586921";
        try {
            Class.forName(driverClassName);
            Connection connection = DriverManager.getConnection(url, userName, userPassword);
            Statement statement = connection.createStatement();
            String tempUserName = encrypt(registName,"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/gb6XWQWu/XLFZFunAkLDi7dFoLpAH/Hb0xaAN149m6yKsVePP1YnwBvdD/9wYqJvyiCr6SS/fH1eRnMUPEjq9doB74SqPiam+FcDmVUwZalJtL0xAl8VV434BUnMX1i6diWGAj3O79hLdNigkUEMkUEl8YXk1rLRJ3REBEIpwQIDAQAB");
            String tempUserPassword = encrypt(registPassword,"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/gb6XWQWu/XLFZFunAkLDi7dFoLpAH/Hb0xaAN149m6yKsVePP1YnwBvdD/9wYqJvyiCr6SS/fH1eRnMUPEjq9doB74SqPiam+FcDmVUwZalJtL0xAl8VV434BUnMX1i6diWGAj3O79hLdNigkUEMkUEl8YXk1rLRJ3REBEIpwQIDAQAB");
            String sql = "insert into user values ('"+tempUserName+"','"+tempUserPassword+"')";
            boolean result = statement.execute(sql);
            return result;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
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
