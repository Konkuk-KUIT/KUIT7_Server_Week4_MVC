package frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

public class View {

    private String path;

    public View(String path) {
        this.path = path;
    }

    public void render(Map<String, Object> model,
                       HttpServletRequest request,
                       HttpServletResponse response) throws Exception {

        // ⭐ redirect 처리
        if (path.startsWith("redirect:")) {
            response.sendRedirect(path.substring(9));
            return;
        }

        for (String key : model.keySet()) {
            request.setAttribute(key, model.get(key));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
}