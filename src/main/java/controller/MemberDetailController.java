package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberDetailController implements Controller {
    private final MemberService memberService = MemberService.getInstance();

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView("/WEB-INF/views/detail.jsp");

        Long id = Long.parseLong(request.getParameter("id"));
        Member member = memberService.findById(id);
        mav.addObject("member", member);


        return mav;
    }
}
