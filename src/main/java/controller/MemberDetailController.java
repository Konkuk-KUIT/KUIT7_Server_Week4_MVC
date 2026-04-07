package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import org.apache.tomcat.util.log.UserDataHelper;
import service.MemberService;

import java.util.Map;

public class MemberDetailController implements Controller {


    private final MemberService memberService = MemberService.getInstance();

    @Override
    public ModelAndView process(Map<String, String> paraMap) {

        String id = paraMap.get("id");
        Member member = memberService.findById(Long.valueOf(id));
        ModelAndView mv = new ModelAndView("detail");
        mv.getModel().put("model", member);


        return mv;
    }
}
