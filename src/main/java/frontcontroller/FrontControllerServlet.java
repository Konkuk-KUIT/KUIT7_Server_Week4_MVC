package frontcontroller;

import controller.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 모든 /front-controller/* 요청을 단일 진입점으로 받아
 * HandlerMapping → Controller → View 순으로 처리
 */
public class FrontControllerServlet extends HttpServlet {

    // URL → Controller 매핑 테이블 (HandlerMapping)
    private final Map<String, Controller> handlerMapping = new HashMap<>();

    @Override
    public void init() {
        handlerMapping.put("/front-controller/home",           new HomeController());
        handlerMapping.put("/front-controller/members/new-form", new MemberFormController());
        handlerMapping.put("/front-controller/members/save",   new MemberSaveController());
        handlerMapping.put("/front-controller/members",        new MemberListController());
        handlerMapping.put("/front-controller/members/detail", new MemberDetailController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");

        String requestURI = req.getRequestURI();

        // 1. HandlerMapping: URL로 Controller 조회
        Controller controller = handlerMapping.get(requestURI);

        if (controller == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND,
                    "요청한 페이지를 찾을 수 없습니다: " + requestURI);
            return;
        }

        // 2. Controller 실행
        Map<String, Object> model = new HashMap<>();
        String viewName;
        try {
            viewName = controller.process(model, req, res);
        } catch (Exception e) {
            throw new ServletException("Controller 처리 중 오류 발생", e);
        }

        // 3. redirect 케이스 (viewName == null) 는 이미 응답 완료
        if (viewName == null) {
            return;
        }

        // 4. View 렌더링 (model → request attribute → JSP forward)
        View view = new View(viewName);
        try {
            view.render(model, req, res);
        } catch (Exception e) {
            throw new ServletException("View 렌더링 중 오류 발생", e);
        }
    }
}