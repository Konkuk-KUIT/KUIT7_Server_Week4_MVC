package frontcontroller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

public class View {
    private final String viewPath;

    public View(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse res) throws Exception {
        model.forEach(req::setAttribute);
        req.getRequestDispatcher(viewPath).forward(req, res);
    }
}