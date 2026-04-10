package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberDetailController implements Controller {
    private final MemberService service = MemberService.getInstance();

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        // 1. 요청 파라미터에서 ID를 추출합니다.
        Long id = Long.parseLong(request.getParameter("id"));

        // 2. 데이터를 조회하여 Model에 담습니다.
        request.setAttribute("member", service.findById(id));

        // 3. 뷰 이름을 반환합니다.
        return "detail";
    }
}