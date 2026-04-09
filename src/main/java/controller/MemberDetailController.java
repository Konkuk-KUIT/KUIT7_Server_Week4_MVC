package controller;

import frontcontroller.ModelAndView;
import java.util.Map;
import service.MemberService;

public class MemberDetailController implements Controller {
    private final MemberService memberService = MemberService.getInstance();

    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        Long id = Long.parseLong(paramMap.get("id"));

        ModelAndView mv = new ModelAndView("detail");
        mv.getModel().put("member", memberService.findById(id));
        return mv;
    }
}
