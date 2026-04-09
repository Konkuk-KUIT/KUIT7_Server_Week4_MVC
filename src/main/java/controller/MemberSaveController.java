package controller;

import domain.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;
import java.util.Map;

public class MemberSaveController implements Controller {

    private final MemberService service = MemberService.getInstance();

    @Override
    public String process(Map<String, Object> model,
                          HttpServletRequest req,
                          HttpServletResponse res) throws Exception {
        String name = req.getParameter("name");
        service.save(new Member(name));

        // 저장 후 목록 페이지로 리다이렉트
        res.sendRedirect("/front-controller/members");
        return null; // redirect이므로 viewName 없음
    }
}