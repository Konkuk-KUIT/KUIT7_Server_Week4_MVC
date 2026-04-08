package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        req.getRequestDispatcher("/WEB-INF/views/new-form.jsp")
                .forward(req, res);
    }
}
// 회원 등록 화면을 보여주기 위한 GET 요청을 받아서 new-form.jsp로 forward하는 서블릿.

//얘도 jsp는 new-form 화면을 출력
// text/html과 utf-8로 해석하겠다는 건 frontcontroller로 공통으로 묶어