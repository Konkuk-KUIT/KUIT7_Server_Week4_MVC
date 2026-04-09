package controller;

import domain.Member;
import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class MemberDetailController implements Controller {
	private final MemberService service = MemberService.getInstance();

	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		Member member = service.findById(id);

		ModelAndView modelAndView = new ModelAndView("detail");
		modelAndView.getModel().put("member", member);
		return modelAndView;
	}
}
