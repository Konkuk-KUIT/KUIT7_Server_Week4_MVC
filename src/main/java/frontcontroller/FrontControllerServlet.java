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

    @Override
    public void init() {

        handlerMapping.put("/home", new HomeController());
        handlerMapping.put("/members", new MemberListController());
        handlerMapping.put("/members/new-form", new MemberFormController());
        handlerMapping.put("/members/save", new MemberSaveController());
        handlerMapping.put("/members/detail", new MemberDetailController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();

        String path = uri.substring(contextPath.length());
        path = path.replace("/front-controller", "");

        Controller controller = handlerMapping.get(path);

        if (controller == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        ModelAndView mv = controller.process(request, response);

        // model 데이터 request에 넣기
        for (String key : mv.getModel().keySet()) {
            request.setAttribute(key, mv.getModel().get(key));
        }

        String viewPath = "/WEB-INF/views/" + mv.getViewName() + ".jsp";

        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}
