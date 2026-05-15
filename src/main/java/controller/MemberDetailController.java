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
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Long id = Long.parseLong(request.getParameter("id"));

        ModelAndView mav = new ModelAndView("detail");
        mav.addAttribute("member", service.findById(id));
        return mav;
    }
}
