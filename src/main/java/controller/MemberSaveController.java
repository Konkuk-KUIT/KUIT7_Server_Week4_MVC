package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import java.util.Map;
import service.MemberService;

public class MemberSaveController implements Controller {
    private final MemberService memberService = MemberService.getInstance();

    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        String name = paramMap.get("name");
        memberService.save(new Member(name));

        return new ModelAndView("redirect:/front-controller/members");
    }
}
