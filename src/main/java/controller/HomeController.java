package controller;

import frontcontroller.ModelAndView;
import java.util.Map;

public class HomeController implements Controller {
    @Override
    public ModelAndView modelAndView(Map<String, String> paramMap) {
        return new ModelAndView("home");
    }
}