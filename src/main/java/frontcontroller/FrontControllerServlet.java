package frontcontroller;

import controller.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontControllerServlet extends HttpServlet {

    private final HomeController homeController = new HomeController();
    private final MemberFormController memberFormController = new MemberFormController();
    private final MemberSaveController memberSaveController = new MemberSaveController();
    private final MemberListController memberListController = new MemberListController();
    private final MemberDetailController memberDetailController = new MemberDetailController();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {

        String uri = request.getRequestURI();

        try {
            Controller controller = null;

            if (uri.equals("/home")) {
                controller = homeController;

            } else if (uri.equals("/members/new-form")) {
                controller = memberFormController;

            } else if (uri.equals("/members/save")) {
                controller = memberSaveController;

            } else if (uri.equals("/members")) {
                controller = memberListController;

            } else if (uri.equals("/members/detail")) {
                controller = memberDetailController;

            } else {
                response.setStatus(404);
                return;
            }

            ModelAndView mv = controller.handle(request, response);

            View view = new View(mv.getViewName());
            view.render(mv.getModel(), request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}