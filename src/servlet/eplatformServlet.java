package servlet;

import com.ndktools.javamd5.Mademd5;
import dao.eplatformDao;
import entities.production;
import entities.shopInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@WebServlet("/eplatformServlet")
public class eplatformServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            eplatformDao dao = new eplatformDao();
            List<production> productionList = getProduction();
            int count = 0;
            for (int i = 1;i <= 5;i++){
                shopInfo temp = new shopInfo();
                int tempInt = Integer.parseInt(req.getParameter("count"+i));
                if (tempInt > 0){
                    count += productionList.get(i-1).getProductionPrice()*tempInt;
                }
            }
            Cookie[] cookies = req.getCookies();
            String userName = null;
            String userPassword = null;
            for (Cookie temp: cookies){
                if (temp.getName() == "userName"){
                    userName = temp.getValue();
                }
                if (temp.getName() == "userPassword"){
                    userPassword = temp.getValue();
                }
            }
            JSONArray json = new JSONArray();
            JSONObject object = new JSONObject();
            object.put("amount", count);
            object.put("source",1);
            object.put("target",2);
            String PI = String.valueOf(count+1+2);
            JSONObject object1 = new JSONObject();
            Mademd5 md5 = new Mademd5();
            String OIMD = md5.toMd5("something");
            object1.put("OIMD",OIMD);
            System.out.println("PI的哈希值"+PI);
            System.out.println("PI的哈希值"+md5.toMd5(PI));
            System.out.println(md5.toMd5(PI)+OIMD);
            String POMD = md5.toMd5(md5.toMd5(PI)+OIMD);
            System.out.println(String.valueOf(object));
            String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/gb6XWQWu/XLFZFunAkLDi7dFoLpAH/Hb0xaAN149m6yKsVePP1YnwBvdD/9wYqJvyiCr6SS/fH1eRnMUPEjq9doB74SqPiam+FcDmVUwZalJtL0xAl8VV434BUnMX1i6diWGAj3O79hLdNigkUEMkUEl8YXk1rLRJ3REBEIpwQIDAQAB";
            String DualSignature = dao.encrypt(POMD,publicKey);
            System.out.println("解密之前"+POMD);
            System.out.println("解密之后的哈希值"+dao.decrypt(DualSignature,"MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAL+BvpdZBa79csVkW6cCQsOLt0WgukAf8dvTFoA3Xj2brIqxV48/VifAG90P/3Biom/KIKvpJL98fV5GcxQ8SOr12gHvhKo+Jqb4VwOZVTBlqUm0vTECXxVXjfgFScxfWLp2JYYCPc7v2Et02KCRQQyRQSXxheTWstEndEQEQinBAgMBAAECgYEAr/GQ3FYCncHnFylb9zVhh2yupb7EPzPaLh9ilcvIvotu20GRc186VWzvbItNIMDOAizPFYIuq+rA98N76QR17Cm0I7H7vm/rb3QzTVB+BmzWXi+zTkxiKjgO810Z3cvMLH6NfZjhGaCJVScoiYfReoJ1jrC5Yu7/zVOIAK26Dz0CQQDfMQ9t8llZ5jtvC13X8Tt8qiUjQQ6OptloYil3vR+VGBsFCsvWSRdhmnncldJcRs7E8bbwB3Z1Yq49pIpS5hEDAkEA26hZsMOCwusydWYEyDnMCft6Tt8GdK/k2YVKeAwwRpgNyJIcSXW5gjsFvW5Gvuyib7qaCUdHhaY5RYydixmE6wJAenKdB3HlSWgBhWuUAavsOfnSxCOmC+dH8XehTnrov9Boynxg1mBlPnwUjUt5DH0gZXZDKi6986q+8zy5Ur+75wJAGDxgAQfhYp5Ox/NErc7qu2M64H7tGGzb5EA3sj0uCmv2gV3VrylFGaBnhronJiO33HoLSuDJfG6VvR3BuDpNlwJAHf3xZFtRhej+4gVIuU4FX4CD+DXIodkgWrzh9AxBIDAhYR1Q0RP7jqoPGqlgYYdiHiaIwn0voG/gUnzmhdBlZg=="));
            object1.put("DualSignature",DualSignature);
            json.put(object);
            json.put(object1);
            System.out.println("{\"INFO\":"+json+"}");
            String url = URLEncoder.encode("{\"INFO\":"+json+"}","utf-8");
            System.out.println(url);
            resp.sendRedirect("http://192.168.137.197:8000/pay?ds="+ url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 用来显示商品的
     * @return 商品列表
     */
    public List<production> getProduction(){
        eplatformDao dao = new eplatformDao();
        return dao.getAllProduction();
    }

}
