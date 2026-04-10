package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberListController implements Controller {
    private final MemberService service = MemberService.getInstance();

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("members", service.findAll());

        return "members";
    }
}