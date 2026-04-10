package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

import java.util.List;

public class MemberListController implements Controller {
	private final MemberService service = MemberService.getInstance();

	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("members");
		List<Member> members = service.findAll();
		modelAndView.getModel().put("members", members);
		return modelAndView;
	}
}
