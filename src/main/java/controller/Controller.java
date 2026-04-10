package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;

public interface Controller {
    ModelAndView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
