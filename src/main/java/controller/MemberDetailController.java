package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

import java.io.IOException;

public class MemberDetailController implements Controller {

    private final MemberService service = MemberService.getInstance();

    @Override
    public ModelAndView execute(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));

        ModelAndView mav = new ModelAndView("detail");
        mav.getModel()
                .put("member", service.findById(id));

        return mav;
    }
}
