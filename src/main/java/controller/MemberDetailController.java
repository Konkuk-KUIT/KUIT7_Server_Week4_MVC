package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;
import java.util.Map;

public class MemberDetailController implements Controller {

    private final MemberService service = MemberService.getInstance();

    @Override
    public String process(Map<String, Object> model,
                          HttpServletRequest req,
                          HttpServletResponse res) throws Exception {
        Long id = Long.parseLong(req.getParameter("id"));
        model.put("member", service.findById(id));
        return "detail";
    }
}