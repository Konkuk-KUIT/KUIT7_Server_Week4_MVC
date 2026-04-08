package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFormController implements Controller{

    @Override
    public ModelAndView process(HttpServletRequest req, HttpServletResponse res){
        return new ModelAndView("new-form");
    }
}
