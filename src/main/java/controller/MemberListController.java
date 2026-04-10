package controller;

import frontcontroller.ModelAndView;
import service.MemberService;

import java.util.Map;

public class MemberListController implements Controller{
    private MemberService service = MemberService.getInstance();

    @Override
    public ModelAndView modelAndView(Map<String, String> paramMap) {
        ModelAndView mv = new ModelAndView("members");
        mv.addModel("members", service.findAll());
        return mv;
    }
}
