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

    //if, else 등 없에고 map으로
    private final Map<String, Controller> handlerMapping = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        initHandlerMapping();
    }

    private void initHandlerMapping() {
        handlerMapping.put("/", new HomeController());
        handlerMapping.put("/home", new HomeController());
        handlerMapping.put("/members/new-form", new MemberFormController());
        handlerMapping.put("/members/save", new MemberSaveController());
        handlerMapping.put("/members", new MemberListController());
        handlerMapping.put("/members/detail", new MemberDetailController());
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doDispatch(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doDispatch(req, res);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");

        //url 뽑기
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = requestURI.substring(contextPath.length());

        String mappingPath = path.substring("/front-controller".length());

        Controller controller = handlerMapping.get(mappingPath);

        if (controller == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        try {
            ModelAndView mav = controller.handle(req, res);

            if (mav != null) {
                String viewName = mav.getViewName();
                Map<String, Object> model = mav.getModel();

                // 모델 데이터를 request에 설정
                for (String key : model.keySet()) {
                    req.setAttribute(key, model.get(key));
                }

                String jspPath = "/WEB-INF/views" + viewName + ".jsp";
                req.getRequestDispatcher(jspPath).forward(req, res);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void addController(String path, Controller controller) {
        handlerMapping.put(path, controller);
    }
}
