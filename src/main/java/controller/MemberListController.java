package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberListController implements Controller {

    private final MemberService memberService = MemberService.getInstance();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setAttribute("members", memberService.findAll());

        return "/WEB-INF/views/members.jsp";
    }

}
