package frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private String viewName;
    private Map<String, Object> model;

    public ModelAndView(String viewName) {
        this.viewName = viewName;
        this.model = new HashMap<>();
    }

    public String getViewName() {
        return viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void addAttribute(String name, Object value) {
        model.put(name, value);
    }
}
