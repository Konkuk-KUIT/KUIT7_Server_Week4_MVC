package frontcontroller;

import jakarta.servlet.RequestDispatcher;
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

    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        if(viewPath.startsWith("redirect:")) {
            String redirectUrl = viewPath.split(":")[1];
            res.sendRedirect(redirectUrl);
            return;
        }
        addAttribute(model, req);

        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, res);
    }

    private void addAttribute(Map<String, Object> model, HttpServletRequest req) {
        model.forEach((k, v) -> {req.setAttribute(k, v);});
    }
}
