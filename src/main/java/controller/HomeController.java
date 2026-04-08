package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomeController implements Controller {
    @Override
    public ModelAndView handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
        return new ModelAndView("/home");
    }
}