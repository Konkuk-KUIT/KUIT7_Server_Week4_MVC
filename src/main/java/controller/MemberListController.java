package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberListController implements Controller {
    private final MemberService service = MemberService.getInstance();

    @Override
    public ModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ModelAndView mav = new ModelAndView("/members");
        mav.addAttribute("members", service.findAll());
        return mav;
    }
}
