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
        shopInfo transeInfo = new shopInfo();
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
        for (Cookie temp: cookies){
            System.out.println(temp.getName()+"    "+temp.getValue());
        }
        req.getAttribute("userPassword");
        transeInfo.setCount(count);
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
