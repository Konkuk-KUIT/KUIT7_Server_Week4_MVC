package frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private View view;
    private Map<String, Object> model = new HashMap<>();

    public ModelAndView(View view) {
        this.view = view;
    }

    public void addModel(String name, Object value) {
        model.put(name, value);
    }

    public String getViewName() {
        return view.getViewName();
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
