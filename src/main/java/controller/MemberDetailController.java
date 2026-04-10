package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberDetailController implements Controller {

    private final MemberService service = MemberService.getInstance();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("id"));
        return new ModelAndView("detail").addObject("member", service.findById(id));
    }
}
