package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberSaveController implements Controller {
    private MemberService memberService = MemberService.getInstance();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("name");

        Member member = new Member(name);
        memberService.save(member);

        ModelAndView mv = new ModelAndView("home");
        mv.getModel().put("member", member);

        return mv;
    }
}
