package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public interface Controller {
    final MemberService service = MemberService.getInstance();

    ModelAndView process(Map<String, String> params);
}
