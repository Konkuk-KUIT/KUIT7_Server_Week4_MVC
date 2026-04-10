package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

import java.io.IOException;

public class MemberListController implements  Controller {

    private final MemberService service = MemberService.getInstance();

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        ModelAndView mav = new ModelAndView("members");
        mav.getModel()
                .put("members", service.findAll());

        return mav;
    }
}
