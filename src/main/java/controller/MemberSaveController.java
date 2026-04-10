package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberSaveController implements Controller {

    private final MemberService service = MemberService.getInstance();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        service.save(new Member(name));
        String contextPath = request.getContextPath();
        return ModelAndView.redirect(contextPath + "/front-controller/members");
    }
}
