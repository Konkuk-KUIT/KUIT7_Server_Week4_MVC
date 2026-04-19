package controller;

import frontcontroller.ModelAndView;
import frontcontroller.View;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        View view = new View("new-form");
        ModelAndView modelAndView = new ModelAndView(view);
        return modelAndView;
    }
}
