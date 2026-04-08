package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberSaveController implements Controller {
    private final MemberService service = MemberService.getInstance();

    @Override
    public ModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String name = req.getParameter("name");
        service.save(new Member(name));
        res.sendRedirect("/members");
        return null;
    }
}
