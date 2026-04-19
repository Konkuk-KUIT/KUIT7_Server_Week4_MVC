package controller;

import frontcontroller.ModelAndView;
import frontcontroller.View;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

import java.io.IOException;

public class MemberDetailController implements Controller {

    private final MemberService service = MemberService.getInstance();

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));

        View view = new View("detail");
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addModel("member", service.findById(id));

        return modelAndView;
    }
}
