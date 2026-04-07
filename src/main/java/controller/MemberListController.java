package controller;

import domain.Member;
import service.MemberService;
import java.util.Map;

public class MemberListController implements Controller {
    private final MemberService service = MemberService.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        model.put("members", service.findAll());
        return "members";
    }
}