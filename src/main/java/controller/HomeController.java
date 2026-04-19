package controller;

import frontcontroller.ModelAndView;
import java.util.Map;

public class HomeController implements Controller {

    @Override // 동적으로 반환할 요소 X
    public ModelAndView process(Map<String, String> paraMap) {
        return new ModelAndView("home");
    }
}