package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

public class HomeController implements Controller {

    @Override
    public String process(Map<String, Object> model,
                          HttpServletRequest req,
                          HttpServletResponse res) throws Exception {
        return "home";
    }
}