package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

public interface Controller {
    /**
     * 요청을 처리하고 view 이름을 반환
     * @param model  View에 전달할 데이터를 담는 Map
     * @return       논리적 view 이름 (예: "home", "members/list")
     */
    String process(Map<String, Object> model,
                   HttpServletRequest req,
                   HttpServletResponse res) throws Exception;
}