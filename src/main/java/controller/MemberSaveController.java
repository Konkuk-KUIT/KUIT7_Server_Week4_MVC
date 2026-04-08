package controller;

import domain.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberSaveController implements Controller {
    private final MemberService service = MemberService.getInstance();

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        // 회원 저장
        String name = request.getParameter("name");
        service.save(new Member(name));

        // "redirect:" 접두사 사용
        return "redirect:/members";
    }
}