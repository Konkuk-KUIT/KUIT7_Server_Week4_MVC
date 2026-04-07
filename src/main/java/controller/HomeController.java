package controller;

import frontcontroller.ModelAndView;
import java.util.Map;

public class HomeController implements Controller {
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "home"; // home.jsp로 이동
    }
}