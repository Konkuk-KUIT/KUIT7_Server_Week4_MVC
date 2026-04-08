package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        req.getRequestDispatcher("/WEB-INF/views/home.jsp")
                .forward(req, res);
    }
}
// 홈 화면에 대한 get 요청을 받으면, home.jsp를 utf-8기반 Html로 사용자에게 보여준다.
// 일단 jsp가 하는 일은 home 화면에 출력.
// FrontController는 요청을 받는다. text