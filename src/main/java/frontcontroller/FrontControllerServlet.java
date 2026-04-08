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

    private final Map<String, Controller> controllerMap =new HashMap<>();

    @Override
    public void init(){
        controllerMap.put("/front-controller/home", new HomeController());
        controllerMap.put("/front-controller/members/new-form", new MemberFormController());
        controllerMap.put("/front-controller/members", new MemberListController());
        controllerMap.put("/front-controller/members/detail", new MemberDetailController());
        controllerMap.put("/front-controller/members/save", new MemberSaveController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String requestURI = req.getRequestURI();
        Controller controller = controllerMap.get(requestURI);

        if (controller == null) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        ModelAndView mv = controller.process(req, res);
        String viewName = mv.getViewName();

        if (viewName.startsWith("redirect:")) {
            String redirectPath = viewName.substring("redirect:".length());
            res.sendRedirect(
                    "/front-controller".equals(redirectPath) || redirectPath.startsWith("/front-controller")
                            ? redirectPath
                            : "/front-controller" + redirectPath);

            return;
        }



        View view = viewResolver(viewName);
        view.render(mv.getModel(), req, res);
    }
    private View viewResolver(String viewName){
        return new View("/WEB-INF/views/" + viewName + ".jsp");
    }
    //1. 요청 url 받기
    //2. url에 맞는 controller 찾기
    //3. controller 실행
    //4. modelandview 받기
    //5. view로 forward
}
