package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import java.util.Map;

public class HomeController implements Controller {
    @Override
    public ModelAndView process(Map<String, String> params) {
        return new ModelAndView("home");
    }
}