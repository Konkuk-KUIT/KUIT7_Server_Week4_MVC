package controller;

import domain.Member;
import frontcontroller.ModelAndView;

import java.util.Map;

public class MemberSaveController implements Controller {
    @Override
    public ModelAndView process(Map<String, String> params) {
        String name = params.get("name");
        service.save(new Member(name));
        System.out.println("save");

        return new ModelAndView("redirect:/front-controller/members");
    }
}
