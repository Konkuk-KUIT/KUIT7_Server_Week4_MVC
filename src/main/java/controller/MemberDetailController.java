package controller;

import service.MemberService;

import java.util.Map;

public class MemberDetailController implements Controller {
    private final MemberService service = MemberService.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        Long id = Long.parseLong(paramMap.get("id"));
        model.put("member", service.findById(id));
        return "detail";
    }
}
