package frontcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class View {
    String link;

    public View(String link) {
        this.link = link;
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (link.startsWith("redirect:")) {
            String redirectPath = link.substring("redirect:".length());
            System.out.println(link);
            response.sendRedirect(redirectPath);
            return; // 리다이렉트 과정
        }

        if (model != null) {
            model.forEach(request::setAttribute);
        } // 원복 과정

        request.getRequestDispatcher("/WEB-INF/views/" + link + ".jsp")
                .forward(request, response);
    }
}
