package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

public class HomeController implements Controller {
    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("home");
    }
}