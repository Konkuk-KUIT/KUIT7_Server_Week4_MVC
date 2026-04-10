package controller;

import frontcontroller.ModelAndView;
import service.MemberService;

import java.util.Map;

public class MemberDetailController implements Controller{
    private MemberService service = MemberService.getInstance();

    @Override
    public ModelAndView modelAndView(Map<String, String> paramMap) {
        Long id = Long.parseLong(paramMap.get("id"));

        ModelAndView mv = new ModelAndView("detail");
        mv.addModel("member", service.findById(id));
        return mv;
    }
}
