package controller;

import frontcontroller.ModelAndView;
import java.util.Map;

public interface Controller {
    ModelAndView process(Map<String, String> paramMap);
}
