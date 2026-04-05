package controller;

import domain.Member;
import frontcontroller.ModelAndView;

import java.util.Map;

public class MemberListController implements Controller {
    @Override
    public ModelAndView process(Map<String, String> params) {

        ModelAndView modelAndView = new ModelAndView("members");
        modelAndView.addObject("members", service.findAll());

        return modelAndView;
    }
}
