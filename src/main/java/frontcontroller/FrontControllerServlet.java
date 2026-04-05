package frontcontroller;

import controller.Controller;
import controller.HomeController;
import controller.MemberDetailController;
import controller.MemberFormController;
import controller.MemberListController;
import controller.MemberSaveController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontControllerServlet extends HttpServlet {

    private Map<String, Controller> controllerMap = new HashMap<>();

    public FrontControllerServlet() {
        controllerMap.put("/front-controller/home", new HomeController());
        controllerMap.put("/front-controller/members/detail", new MemberDetailController());
        controllerMap.put("/front-controller/members/new-form", new MemberFormController());
        controllerMap.put("/front-controller/members", new MemberListController());
        controllerMap.put("/front-controller/members/save", new MemberSaveController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("🔔request accepted");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String requestURI = request.getRequestURI();
        Controller controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 없으면 404
            return;
        }

        Map<String, String> params = createRequestParams(request);
        ModelAndView modelAndView = controller.process(params);

        String viewName = modelAndView.getViewName();
        View view = viewResolver(viewName);
        view.render(modelAndView.getModel(), request, response);
    }

    private Map<String, String> createRequestParams(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();

        request.getParameterNames().asIterator().forEachRemaining(paramName ->
                params.put(paramName, request.getParameter(paramName))
        );
        return params;

    }

    private View viewResolver(String viewName) {
        return new View(viewName);
    }
}
