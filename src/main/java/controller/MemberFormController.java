package controller;

import frontcontroller.ModelAndView;

import java.util.Map;

public class MemberFormController implements Controller{
    @Override
    public ModelAndView modelAndView(Map<String, String> paramMap) {
        return new ModelAndView("new-form");
    }
}
