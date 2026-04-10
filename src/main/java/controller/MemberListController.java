package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberListController implements Controller {
    @Override
    public ModelAndView process(HttpServletRequest req, HttpServletResponse res) throws Exception {

        MemberService service = MemberService.getInstance();

        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        ModelAndView modelView = new ModelAndView("/WEB-INF/views/members.jsp");

        modelView.getModel().put("members", service.findAll());

        return modelView;
    }
}
