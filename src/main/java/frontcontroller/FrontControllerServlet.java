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

@WebServlet("/")
public class FrontControllerServlet extends HttpServlet {

    private final Map<String, controller.Controller> handlerMappingMap = new HashMap<>();

    @Override
    public void init() {
        handlerMappingMap.put("/",                 new HomeController());
        handlerMappingMap.put("/members/new-form", new MemberFormController());
        handlerMappingMap.put("/members/save",     new MemberSaveController());
        handlerMappingMap.put("/members",          new MemberListController());
        handlerMappingMap.put("/members/detail",   new MemberDetailController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String requestURI = req.getRequestURI();
        controller.Controller controller = handlerMappingMap.get(requestURI);

        if (controller == null) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        try {
            ModelAndView mv = controller.process(req, res);
            if (mv == null) return;

            View view = new View(mv.getViewName());
            view.render(mv.getModel(), req, res);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}