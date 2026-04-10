package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

import java.io.IOException;

public class MemberSaveController implements  Controller {

    private final MemberService service = MemberService.getInstance();

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        service.save(new Member(name));

        return new ModelAndView("redirect:/front-controller/members");
    }
}
