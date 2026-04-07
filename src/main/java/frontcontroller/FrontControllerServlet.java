package frontcontroller;

import controller.*;
import jakarta.servlet.ServletException;
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
        controllerMap.put("/front-controller/members", new MemberListController());
        controllerMap.put("/front-controller/members/new-form", new MemberFormController());
        controllerMap.put("/front-controller/members/save", new MemberSaveController());
        controllerMap.put("/front-controller/members/detail", new MemberDetailController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        Controller controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();


        String viewName = controller.process(paramMap, model);
        modelToRequestAttribute(model, request);

        String viewPath = viewResolver(viewName);
        request.getRequestDispatcher(viewPath).forward(request, response);
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        model.forEach(request::setAttribute);
    }

    private String viewResolver(String viewName) {
        return "/WEB-INF/views/" + viewName + ".jsp";
    }
}