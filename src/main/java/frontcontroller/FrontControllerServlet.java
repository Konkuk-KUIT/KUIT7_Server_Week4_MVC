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

    public FrontControllerServlet() {
        // URL, 컨트롤러 매핑
        handlerMapping.put("/front-controller/home", new HomeController());
        handlerMapping.put("/front-controller/members/new-form", new MemberFormController());
        handlerMapping.put("/front-controller/members/save", new MemberSaveController());
        handlerMapping.put("/front-controller/members", new MemberListController());
        handlerMapping.put("/front-controller/members/detail", new MemberDetailController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 요청한 URI에 맞는 컨트롤러 찾기
        String requestURI = request.getRequestURI();
        Controller controller = handlerMapping.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 컨트롤러를 실행, 논리적인 뷰 이름 받기
        String viewName = controller.process(request, response);

        // 뷰 처리 수행
        if (viewName.startsWith("redirect:")) {
            // "redirect:"로 시작하면 리다이렉트 처리
            String redirectPath = viewName.substring("redirect:".length());
            response.sendRedirect(redirectPath);
        } else {
            // 그 외 JSP로 포워딩
            String viewPath = "/WEB-INF/views/" + viewName + ".jsp";
            request.getRequestDispatcher(viewPath).forward(request, response);
        }
    }
}