package frontcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class View {

    private final String viewName;

    public View(String viewName) {
        this.viewName = viewName;
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        model.forEach(request::setAttribute);
        request.getRequestDispatcher("/WEB-INF/views/" + viewName + ".jsp").forward(request, response);
    }
}
