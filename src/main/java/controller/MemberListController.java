package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberListController implements Controller {
    private final MemberService service = MemberService.getInstance();

    @Override
    public ModelAndView process(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ModelAndView mv = new ModelAndView("/WEB-INF/views/members.jsp");
        mv.addObject("members", service.findAll());
        return mv;
    }
}