package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberListController implements Controller {

    private final MemberService memberService = MemberService.getInstance();

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView("/WEB-INF/views/members.jsp");
        mav.addObject("members", memberService.findAll());

        return mav;
    }

}
