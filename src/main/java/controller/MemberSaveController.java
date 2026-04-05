package controller;

import domain.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberSaveController implements Controller {

    private final MemberService memberService = MemberService.getInstance();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String name = request.getParameter("name");
        memberService.save(new Member(name));

        return "redirect:/front-controller/members";
    }
}