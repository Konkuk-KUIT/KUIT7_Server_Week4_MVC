package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

import java.util.List;

public class MemberListController implements Controller {
    private MemberService memberService = MemberService.getInstance();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {

        List<Member> members = memberService.findAll();

        ModelAndView mv = new ModelAndView("members");
        mv.getModel().put("members", members);

        return mv;
    }
}
