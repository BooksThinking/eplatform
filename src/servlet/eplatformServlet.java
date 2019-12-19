package servlet;

import dao.eplatformDao;
import entities.production;
import entities.shopInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/eplatformServlet")
public class eplatformServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        shopInfo transeInfo = new shopInfo();
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
        req.getAttribute("userPassword");
        Cookie countCookie = new Cookie("count",String.valueOf(count));
        Cookie nameCookie = new Cookie("userName",userName);
        Cookie passwordCookie = new Cookie("userPassword",userPassword);
        resp.addCookie(countCookie);
        resp.addCookie(nameCookie);
        resp.addCookie(passwordCookie);
//        transeInfo.setCount(count);
//        transeInfo.setUserName(userName);
//        transeInfo.setUserPassword(userPassword);
        System.out.println("运行成功");
        resp.sendRedirect("http://192.168.137.197:8000");
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
