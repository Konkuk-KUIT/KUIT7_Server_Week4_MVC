package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFormController implements Controller {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        return "new-form";
    }
}