package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import service.MemberService;

public class MemberDetailServlet extends HttpServlet {

    private final MemberService service = MemberService.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        Long id = Long.parseLong(req.getParameter("id"));

        req.setAttribute("member", service.findById(id));

        req.getRequestDispatcher("/WEB-INF/views/detail.jsp")
                .forward(req, res);
    }
}

// 요청 파라미터에서 id 값을 거내고 그 id로 회원을 조회한 뒤 조회한 회원 객체를 member라는
// 이름으로 request에 담는다.
// 상세 조회 GET 요청에서 전달된 id 파라미터를 숫자로 변환하고, 그 id에 해당하는 회원을 조회해서
// request의 member 속성에 담은 뒤 detail.jsp로 forward하는 서블릿