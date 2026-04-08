package frontcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class View {

    private final String viewPath;

    public View(String viewPath){
        this.viewPath = viewPath;
    }
    public void render(Map<String, Object> model, HttpServletRequest req,
                       HttpServletResponse res) throws ServletException, IOException{
        for(Map.Entry<String, Object> entry : model.entrySet()){
            req.setAttribute(entry.getKey(), entry.getValue());
        }
        req.getRequestDispatcher(viewPath).forward(req, res);
    }
}
