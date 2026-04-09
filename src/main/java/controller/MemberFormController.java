package controller;

import frontcontroller.ModelAndView;
import java.util.Map;

public class MemberFormController implements Controller {
    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        return new ModelAndView("new-form");
    }
}
