package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberSaveController implements Controller {
    @Override
    public ModelAndView process(HttpServletRequest req, HttpServletResponse res) throws Exception {

        MemberService service = MemberService.getInstance();

        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        service.save(new Member(name));

        return new ModelAndView("redirect:/front-controller/members");
    }
}
