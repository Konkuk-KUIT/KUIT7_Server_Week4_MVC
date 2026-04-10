package controller;

import frontcontroller.ModelAndView;
import java.util.Map;

public interface Controller {
    ModelAndView modelAndView(Map<String, String> paramMap);
}
