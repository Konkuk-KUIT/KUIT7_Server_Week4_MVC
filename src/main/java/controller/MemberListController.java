package controller;

import frontcontroller.ModelAndView;
import frontcontroller.View;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

import java.io.IOException;

public class MemberListController implements Controller {

    private final MemberService memberService = MemberService.getInstance();

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        View view = new View("members");
        ModelAndView modelAndView = new ModelAndView(view);

        modelAndView.addModel("members", memberService.findAll());

        return modelAndView;
    }
}
