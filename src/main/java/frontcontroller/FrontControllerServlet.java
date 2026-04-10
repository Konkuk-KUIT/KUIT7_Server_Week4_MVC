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

    private final static Map<String, Controller> controllerMap = new HashMap<>();

    public FrontControllerServlet() {
        controllerMap.put("/home", new HomeController());
        controllerMap.put("/members/new-form", new MemberFormController());
        controllerMap.put("/members/save", new MemberSaveController());
        controllerMap.put("/members", new MemberListController());
        controllerMap.put("/members/detail", new MemberDetailController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 경로를 통해 컨트롤러 찾기
        String path = request.getPathInfo();

        Controller controller = controllerMap.get(path);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }


        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // 개별 컨트롤러 실행 및 ModelAndView 반환
        ModelAndView mv = controller.process(request, response);

        String viewName = mv.getViewName();

        if (viewName.startsWith("redirect:")) {
            String redirectPath = viewName.substring(viewName.indexOf(':') + 1);
            System.out.println(redirectPath);
            response.sendRedirect(redirectPath);
            return;
        }

        View view = viewResolver(viewName);
        view.render(mv.getModel(), request, response);
    }

    private View viewResolver(String viewName) {
        return new View("/WEB-INF/views/" + viewName + ".jsp");
    }
}
