package frontcontroller;

import controller.Controller;
import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {

    private final Map<MappingKey, Controller> mappings = new HashMap<>();

    public void register(String httpMethod, String path, Controller controller) {
        mappings.put(new MappingKey(httpMethod, normalizePath(path)), controller);
    }

    public Controller getController(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        return mappings.get(new MappingKey(request.getMethod(), normalizePath(pathInfo)));
    }

    private static String normalizePath(String path) {
        if (path == null || path.isEmpty()) {
            return "/";
        }
        return path.startsWith("/") ? path : "/" + path;
    }

    private static final class MappingKey {

        private final String method;
        private final String path;

        MappingKey(String method, String path) {
            this.method = method;
            this.path = path;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            MappingKey that = (MappingKey) o;
            return method.equals(that.method) && path.equals(that.path);
        }

        @Override
        public int hashCode() {
            int result = method.hashCode();
            result = 31 * result + path.hashCode();
            return result;
        }
    }
}
