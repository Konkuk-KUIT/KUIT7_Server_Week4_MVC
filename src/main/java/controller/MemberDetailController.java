package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

import java.io.IOException;

public class MemberDetailController implements Controller {

    private final MemberService memberService = MemberService.getInstance();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        ModelAndView mv = new ModelAndView("detail");
        mv.addObject("member", memberService.findById(id));

        return mv;
    }
}
