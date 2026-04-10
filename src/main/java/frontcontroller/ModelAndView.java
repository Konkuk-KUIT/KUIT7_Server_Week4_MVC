package frontcontroller;

import domain.Member;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    String viewName;
    private final Map<String, Object> model = new HashMap<>();

    public ModelAndView(String viewName) {
        this.viewName = viewName;
    }

    public void addObject(String id, Object value) {
        model.put(id, value);
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public String getViewName() {
        return viewName;
    }
}
