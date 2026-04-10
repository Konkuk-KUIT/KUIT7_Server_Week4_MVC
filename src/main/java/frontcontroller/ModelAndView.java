package frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private String viewName;
    private Map<String, Object> model = new HashMap<>();

    public ModelAndView(String viewName) {
        this.viewName = viewName;
    }

    public ModelAndView addObject(String name, Object value) {
        model.put(name, value);
        return this;
    }

    public String getViewName() {
        return this.viewName;
    }

    public Map<String, Object> getModel() {
        return this.model;
    }

}
