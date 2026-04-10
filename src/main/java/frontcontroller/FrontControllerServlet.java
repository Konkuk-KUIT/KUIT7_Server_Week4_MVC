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
    private Map<String, Controller> handlerMapping = new HashMap<>();

    public FrontControllerServlet() {
        initHandlerMapping();
    }

    private void initHandlerMapping() {
        handlerMapping.put("/front-controller/home", new HomeController());
        handlerMapping.put("/front-controller/members/new-form", new MemberFormController());
        handlerMapping.put("/front-controller/members/save", new MemberSaveController());
        handlerMapping.put("/front-controller/members", new MemberListController());
        handlerMapping.put("/front-controller/members/detail", new MemberDetailController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");

        String requestURI = req.getRequestURI();

        Controller controller = handlerMapping.get(requestURI);

        if (controller == null) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            res.getWriter().write("404 Not Found");
            return;
        }

        Map<String, String> paramMap = createParamMap(req);

        ModelAndView mv = controller.modelAndView(paramMap);

        View view = viewResolver(mv.getViewName());
        view.render(mv.getModel(), req, res);
    }

    private Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();

        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));

        return paramMap;
    }

    private View viewResolver(String viewName) {
        if (viewName.startsWith("redirect:")) {
            return new View(viewName);
        }
        return new View("/WEB-INF/views/" + viewName + ".jsp");
    }
}
