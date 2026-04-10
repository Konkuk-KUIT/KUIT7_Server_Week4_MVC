package frontcontroller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

public class View {

    private static final String PREFIX = "/WEB-INF/views/";
    private static final String SUFFIX = ".jsp";

    private final String viewPath;

    public View(String viewName) {
        this.viewPath = PREFIX + viewName + SUFFIX;
    }

    public void render(Map<String, Object> model,
                       HttpServletRequest req,
                       HttpServletResponse res) throws Exception {
        // model → request attribute
        model.forEach(req::setAttribute);

        req.getRequestDispatcher(viewPath).forward(req, res);
    }
}