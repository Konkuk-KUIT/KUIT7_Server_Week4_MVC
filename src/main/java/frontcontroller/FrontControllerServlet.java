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

    private final Map<String, Controller> controllers = new HashMap<>();

    public FrontControllerServlet() {
        controllers.put("/front-controller/home", new HomeController());
        controllers.put("/front-controller/members/new-form", new MemberFormController());
        controllers.put("/front-controller/members/save", new MemberSaveController());
        controllers.put("/front-controller/members", new MemberListController());
        controllers.put("/front-controller/members/detail", new MemberDetailController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            String url = req.getRequestURI();

            Controller controller = controllers.get(url);

            if (controller == null) {
                res.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            ModelAndView modelView = controller.process(req, res);

            View view = new View(modelView.getViewName());
            view.render(modelView.getModel(), req, res);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
