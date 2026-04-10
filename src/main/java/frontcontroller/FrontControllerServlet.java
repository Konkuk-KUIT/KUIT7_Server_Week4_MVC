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
    private final Map<String, Controller> handlerMapping = new HashMap<>();
    private final View view = new View();

    @Override
    public void init() {
        // HandlerMapping: URL 패턴과 Controller 매핑
        handlerMapping.put("/front-controller/home", new HomeController());
        handlerMapping.put("/front-controller/members", new MemberListController());
        handlerMapping.put("/front-controller/members/new-form", new MemberFormController());
        handlerMapping.put("/front-controller/members/detail", new MemberDetailController());
        handlerMapping.put("/front-controller/members/save", new MemberSaveController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        
        // HandlerMapping에서 해당 요청의 Controller 조회
        Controller controller = handlerMapping.get(requestURI);
        
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("Not Found: " + requestURI);
            return;
        }

        // Controller 실행
        ModelAndView mav = controller.process(request, response);
        
        // 리다이렉트인 경우는 null을 반환하므로 뷰를 렌더링하지 않음
        if (mav != null) {
            view.render(mav, request, response);
        }
    }
}
