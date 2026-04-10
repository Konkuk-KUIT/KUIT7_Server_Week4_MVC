package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFormController implements Controller {
    @Override
    public ModelAndView process(HttpServletRequest req, HttpServletResponse res) throws Exception {

        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        return new ModelAndView("/WEB-INF/views/new-form.jsp");
    }
}
