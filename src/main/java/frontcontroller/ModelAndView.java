package frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private final String viewName;
    private final Map<String, Object> model = new HashMap<>();

    public ModelAndView(String viewName) {
        this.viewName = viewName;
    }

    public void addObject(String name, Object value) {
        model.put(name, value);
    }

    public String getViewName() { return viewName; }
    public Map<String, Object> getModel() { return model; }
}