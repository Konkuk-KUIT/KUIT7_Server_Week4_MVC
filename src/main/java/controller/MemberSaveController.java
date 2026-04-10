package controller;

import domain.Member;
import service.MemberService;
import java.util.Map;

public class MemberSaveController implements Controller {
    private final MemberService service = MemberService.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String name = paramMap.get("name");
        service.save(new Member(name));

        return "redirect:/members";
    }
}