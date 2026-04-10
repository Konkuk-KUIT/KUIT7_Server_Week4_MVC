package frontcontroller;

import controller.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class FrontControllerServlet extends HttpServlet {

    private final Map<String, Controller> controllers = new HashMap<>();

    public FrontControllerServlet() {

        controllers.put("/home", new HomeController());
        controllers.put("/members/detail", new MemberDetailController());
        controllers.put("/members/new-form", new MemberFormController());
        controllers.put("/members", new MemberListController());
        controllers.put("/members/save", new MemberSaveController());
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        process(req, res);
    }

    protected void  doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        process(req, res);
    }

    private void process(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String url = req.getPathInfo();
        ModelAndView mav = controllers.get(url)
                .execute(req, res);

        String viewName = mav.getViewName();

        // redirect 하는 경우
        if (viewName.startsWith("redirect:")) {
            viewName = viewName.replace("redirect:", "");
            res.sendRedirect(viewName);
            return;
        }

        // redirect 하지 않는 경우. GET 방식 처리와 동일
        for (Map.Entry<String, Object> entry : mav.getModel().entrySet()) {
            req.setAttribute(entry.getKey(), entry.getValue());
        }

        View view = new View(mav.getViewName());
        req.getRequestDispatcher(view.getJspPath())
                .forward(req, res);
    }
}
