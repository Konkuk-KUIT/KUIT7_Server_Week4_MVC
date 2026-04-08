package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 공통 인터페이스

public interface Controller {
    String process(HttpServletRequest request, HttpServletResponse response);
}