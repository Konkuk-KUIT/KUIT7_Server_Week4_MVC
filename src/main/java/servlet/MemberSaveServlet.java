package servlet;

import domain.Member;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import service.MemberService;

public class MemberSaveServlet extends HttpServlet {

    private final MemberService service = MemberService.getInstance();

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        service.save(new Member(name));

        res.sendRedirect("/members");
    }
}

// 이 클래스는 회원 등록 폼에서 전송된 post 요청을 받아서,
// 요청 파라미터 name을 읽고, 새로운 Member를 저장한 뒤 /members로 리다이렉트 함.