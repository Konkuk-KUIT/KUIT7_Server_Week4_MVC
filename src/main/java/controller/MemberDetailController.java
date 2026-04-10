package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberDetailController implements Controller {
    private MemberService memberService = MemberService.getInstance();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {

        String idParam = request.getParameter("id");
        Long id = Long.parseLong(idParam);

        Member member = memberService.findById(id);

        ModelAndView mv = new ModelAndView("detail");
        mv.getModel().put("member", member);

        return mv;
    }
}
