package frontcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class View {
    private String viewPath;

    public View(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        model.forEach((key, value) -> request.setAttribute(key, value));
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}
