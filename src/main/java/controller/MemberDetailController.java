package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberDetailController implements Controller {
    private final MemberService service = MemberService.getInstance();

    @Override
    public ModelAndView process(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Long id = Long.parseLong(req.getParameter("id"));
        ModelAndView mv = new ModelAndView("/WEB-INF/views/detail.jsp");
        mv.addObject("member", service.findById(id));
        return mv;
    }
}