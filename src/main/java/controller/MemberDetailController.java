package controller;

import domain.Member;
import frontcontroller.ModelAndView;

import java.util.Map;

public class MemberDetailController implements Controller {
    @Override
    public ModelAndView process(Map<String, String> params) {
        Long id = Long.parseLong(params.get("id"));
        Member member = service.findById(id);
        System.out.println(params);

        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("member", member);

        return modelAndView;
    }
}
