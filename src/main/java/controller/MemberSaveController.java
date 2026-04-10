package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberSaveController implements Controller {

    private final MemberService memberService = MemberService.getInstance();

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView("redirect:/front-controller/members");

        String name = request.getParameter("name");
        memberService.save(new Member(name));

        return mav;
    }
}