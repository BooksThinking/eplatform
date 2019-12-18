package servlet;

import dao.eplatformDao;
import entities.production;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/eplatformServlet")
public class eplatformServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> shopCar = new ArrayList<>();
        for (int i = 1;i <= 5;i++){
            shopCar.add(Integer.parseInt(req.getParameter("count"+i)));
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
