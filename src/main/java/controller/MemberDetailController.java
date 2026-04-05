package controller;

import domain.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberDetailController implements Controller {
    private final MemberService memberService = MemberService.getInstance();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Long id = Long.parseLong(request.getParameter("id"));
        Member member = memberService.findById(id);
        request.setAttribute("member", member);

        return "/WEB-INF/views/detail.jsp";
    }
}
