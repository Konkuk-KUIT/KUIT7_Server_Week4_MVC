package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberDetailController implements Controller {
    @Override
    public ModelAndView process(HttpServletRequest req, HttpServletResponse res) throws Exception {

        MemberService service = MemberService.getInstance();

        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        ModelAndView modelView = new ModelAndView("/WEB-INF/views/detail.jsp");

        Long id = Long.parseLong(req.getParameter("id"));
        modelView.getModel().put("member", service.findById(id));

        return modelView;
    }
}
