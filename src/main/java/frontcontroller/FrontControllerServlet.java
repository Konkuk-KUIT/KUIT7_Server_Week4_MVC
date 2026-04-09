package frontcontroller;

import controller.Controller;
import controller.HomeController;
import controller.MemberDetailController;
import controller.MemberFormController;
import controller.MemberListController;
import controller.MemberSaveController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontControllerServlet extends HttpServlet {
	private final Map<String, Controller> handlerMappingMap = new HashMap<>();

	public FrontControllerServlet() {
		handlerMappingMap.put("/home", new HomeController());
		handlerMappingMap.put("/members", new MemberListController());
		handlerMappingMap.put("/members/new-form", new MemberFormController());
		handlerMappingMap.put("/members/save", new MemberSaveController());
		handlerMappingMap.put("/members/detail", new MemberDetailController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String lookupPath = requestURI.substring((contextPath + "/front-controller").length());

		Controller controller = handlerMappingMap.get(lookupPath);
		if (controller == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		ModelAndView mv = controller.process(req, resp);
		if (mv == null) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}

		View view = viewResolver(mv.getViewName());
		view.render(mv.getModel(), req, resp);
	}

	private View viewResolver(String viewName) {
		return new View("/WEB-INF/views/" + viewName + ".jsp");
	}
}
