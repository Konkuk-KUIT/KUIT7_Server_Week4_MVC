package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

import java.io.IOException;

public class MemberSaveController implements Controller {

    private final MemberService memberService = MemberService.getInstance();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        memberService.save(new Member(name));

        return new ModelAndView("redirect:/front-controller/members");
    }
}
