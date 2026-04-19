package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import service.MemberService;

import java.util.List;
import java.util.Map;

public class MemberListController implements Controller {

    MemberService memberService = MemberService.getInstance();

    @Override
    public ModelAndView process(Map<String, String> paraMap) {
        List<Member> members = memberService.findAll();
        ModelAndView mv = new ModelAndView("members");
        mv.getModel().put("members", members);

        return mv;
    }
}
