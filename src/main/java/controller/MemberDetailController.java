package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberDetailController implements Controller {
    private final MemberService service = MemberService.getInstance();

    @Override
    public ModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Long id = Long.parseLong(req.getParameter("id"));
        ModelAndView mav = new ModelAndView("/detail");
        mav.addAttribute("member", service.findById(id));
        return mav;
    }
}
