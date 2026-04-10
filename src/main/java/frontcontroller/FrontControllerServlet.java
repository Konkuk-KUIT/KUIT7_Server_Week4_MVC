package frontcontroller;


import controller.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServlet", urlPatterns = "/front-controller/*")
public class FrontControllerServlet extends HttpServlet {
    private Map<String, Controller> controllerMap = new HashMap<>();

    public FrontControllerServlet() {
        controllerMap.put("/front-controller/home", new HomeController());
        controllerMap.put("/front-controller/members/new-form", new MemberFormController());
        controllerMap.put("/front-controller/members/save", new MemberSaveController());
        controllerMap.put("/front-controller/members", new MemberListController());
        controllerMap.put("/front-controller/members/detail", new MemberDetailController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String requestURI = request.getRequestURI();

        Controller controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }


        try {
            ModelAndView mav = controller.handleRequest(request, response);
            String viewName = mav.getViewName();

            if (viewName.startsWith("redirect:")) {
                response.sendRedirect(viewName.substring("redirect:".length()));
            } else {
                View view = new View(viewName);
                view.render(mav.getModel(), request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
