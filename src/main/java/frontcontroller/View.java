package frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

public class View {
    private final String viewPath;
    private boolean isRedirect;

    public View(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (model != null) {
            model.forEach(request::setAttribute);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
