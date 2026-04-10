package frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class View {
    private String path;

    public View(String path) {
        this.path = path;
    }

    public void render(Map<String, Object> model,
                       HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        if (path.startsWith("redirect:")) {
            response.sendRedirect(path.substring("redirect:".length()));
            return;
        }

        for (Map.Entry<String, Object> entry : model.entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
}
