package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import service.MemberService;

import java.util.Map;

public class MemberSaveController implements Controller {
    private MemberService service = MemberService.getInstance();

    @Override
    public ModelAndView modelAndView(Map<String, String> paramMap) {
        String name = paramMap.get("name");
        service.save(new Member(name));

        return new ModelAndView("redirect:/front-controller/members");
    }
}
