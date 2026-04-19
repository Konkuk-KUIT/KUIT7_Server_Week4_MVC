package frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class View {
    private String viewPath;

    public View(String viewPath){
        this.viewPath = viewPath;
    }


    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (viewPath.startsWith("redirect:")) {
            // "redirect:" 라는 글자 이후의 실제 이동할 URL만 잘라냅니다.
            String redirectUrl = viewPath.substring("redirect:".length());
            response.sendRedirect(redirectUrl);
            return; // 리다이렉트 후 아래 forward 로직이 실행되지 않도록 꼭 return 해줍니다.
        }

        model.forEach((key,value) -> request.setAttribute(key,value));
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request , response);

    }


}
