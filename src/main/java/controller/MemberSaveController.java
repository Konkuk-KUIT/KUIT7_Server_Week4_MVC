package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import frontcontroller.View;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

import java.io.IOException;

public class MemberSaveController implements Controller {

    private final MemberService service = MemberService.getInstance();

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        View view = new View("redirect:members");
        ModelAndView modelAndView = new ModelAndView(view);

        String name = req.getParameter("name");
        service.save(new Member(name));

        return modelAndView;
    }
}
