package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class HomeController implements Controller {

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        return new ModelAndView("home");
    }
}