package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import service.MemberService;

import java.util.Map;

public class MemberSaveController implements Controller {

    private final MemberService memberService = MemberService.getInstance();

    @Override
    public ModelAndView process(Map<String, String> paraMap) {

        String name = paraMap.get("name");
        memberService.save(new Member(name));

        return new ModelAndView("redirect:/front-controller/members");
    }
}
