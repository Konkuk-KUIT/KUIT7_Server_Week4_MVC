package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

import java.io.IOException;

public class MemberListController implements Controller {

    private final MemberService memberService = MemberService.getInstance();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", memberService.findAll());

        return mv;
    }
}
