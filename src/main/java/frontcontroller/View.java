package frontcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class View {
    public void render(ModelAndView mav, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String viewName = mav.getViewName();
        Map<String, Object> model = mav.getModel();

        // 모델 데이터를 request에 설정
        for (Map.Entry<String, Object> entry : model.entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue());
        }

        // JSP로 forward
        request.getRequestDispatcher("/WEB-INF/views/" + viewName + ".jsp")
                .forward(request, response);
    }
}
