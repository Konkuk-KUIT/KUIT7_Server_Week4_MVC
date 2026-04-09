package controller;

import frontcontroller.ModelAndView;
import java.util.Map;
import service.MemberService;

public class MemberListController implements Controller {
    private final MemberService memberService = MemberService.getInstance();

    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        ModelAndView mv = new ModelAndView("members");
        mv.getModel().put("members", memberService.findAll());
        return mv;
    }
}
