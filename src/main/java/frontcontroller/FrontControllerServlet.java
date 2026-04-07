package frontcontroller;

import controller.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class FrontControllerServlet extends HttpServlet {

    private final String defaultPath = "/WEB-INF/views/";
    private final String redirectPrefix = "redirect:/";

    private final Map<String, Controller> controllers = Map.of(
            "/home", new HomeController(),
            "/members/detail", new MemberDetailController(),
            "/members/new-form", new MemberFormController(),
            "/members", new MemberListController(),
            "/members/save", new MemberSaveController()
    );

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String relativePath = req.getRequestURI().substring(req.getServletPath().length());

        Controller controller = controllers.get(relativePath);

        if (controller == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        ModelAndView result = controller.handleRequest(req, res);
        String viewName = result.getViewName();

        result.getModel().forEach(req::setAttribute);

        if(viewName.startsWith(redirectPrefix)) {
            String redirectPath = req.getContextPath() + req.getServletPath() + "/" + viewName.substring(redirectPrefix.length());
            res.sendRedirect(redirectPath);
        } else {
            String forwardPath = defaultPath + viewName + ".jsp";
            req.getRequestDispatcher(forwardPath).forward(req, res);
        }
    }

}
