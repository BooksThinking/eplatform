package servlet;

import dao.registDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registServlet")
public class registServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        registDao dao = new registDao();
        dao.regist(req.getParameter("userName"),req.getParameter("userPassword"));
        resp.sendRedirect("/index.html");
    }
}
