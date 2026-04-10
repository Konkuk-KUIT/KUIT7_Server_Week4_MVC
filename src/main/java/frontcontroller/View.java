package frontcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class View {
	private final String viewPath;

	public View(String viewPath) {
		this.viewPath = viewPath;
	}

	public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		for (Map.Entry<String, Object> entry : model.entrySet()) {
			request.setAttribute(entry.getKey(), entry.getValue());
		}
		request.getRequestDispatcher(viewPath).forward(request, response);
	}
}
