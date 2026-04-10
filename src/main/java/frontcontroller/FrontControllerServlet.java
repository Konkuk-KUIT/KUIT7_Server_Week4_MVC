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

public class FrontControllerServlet extends HttpServlet {

    private HandlerMapping handlerMapping;

    @Override
    public void init() {
        handlerMapping = new HandlerMapping();
        handlerMapping.register("GET", "/home", new HomeController());
        handlerMapping.register("GET", "/members/new-form", new MemberFormController());
        handlerMapping.register("POST", "/members/save", new MemberSaveController());
        handlerMapping.register("GET", "/members", new MemberListController());
        handlerMapping.register("GET", "/members/detail", new MemberDetailController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Controller controller = handlerMapping.getController(request);
        if (controller == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        try {
            ModelAndView modelAndView = controller.process(request, response);
            render(modelAndView, request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void render(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (modelAndView.isRedirect()) {
            response.sendRedirect(modelAndView.getRedirectUrl());
            return;
        }
        new View(modelAndView.getViewName()).render(modelAndView.getModel(), request, response);
    }
}
