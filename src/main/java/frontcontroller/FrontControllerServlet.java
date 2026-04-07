package frontcontroller;

import controller.*;
import jakarta.annotation.Nonnull;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontController" , urlPatterns = "/front-controller")
public class FrontControllerServlet extends HttpServlet {

    private Map<String, Controller> controllerMap = new HashMap<>();

    public FrontControllerServlet(){
        //필요한 Controller 추가하기
        controllerMap.put("/front-controller/home" , new HomeController());
        controllerMap.put("/front-controller/members/detail" , new MemberDetailController());
        controllerMap.put("/front-controller/members/new-form" , new MemberFormController());
        controllerMap.put("/front-controller/members" , new MemberListController());
        controllerMap.put("/front-controller/members/save" , new MemberSaveController());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String requestURI = request.getRequestURI();

        // 해당하는 컨트롤러 찾아옴 key 넣어서
        Controller controller =controllerMap.get(requestURI);
        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 넘어온 request에 대해서 Map<string,string> 형태로 변환
        Map<String, String> paraMap = createRequestParams(request);

        ModelAndView mv = controller.process(paraMap);

        String viewName = mv.getViewName();
        View view;

        if (viewName.startsWith("redirect:")) {
            // redirect 일 때
            view = new View(viewName);
        } else {
            // 일반적인 경로
            view = new View("/WEB-INF/views/" + viewName + ".jsp");
        }
        view.render(mv.getModel(),request , response);

    }

    @Nonnull
    private Map<String, String> createRequestParams(HttpServletRequest request) {
        Map<String, String> paraMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paraName -> paraMap.put(paraName, request.getParameter(paraName)));
        return paraMap;
    }


}
