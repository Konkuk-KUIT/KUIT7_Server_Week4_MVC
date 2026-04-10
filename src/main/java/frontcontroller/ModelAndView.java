package frontcontroller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {

    private final String viewName;
    private final Map<String, Object> model = new HashMap<>();
    private final String redirectUrl;

    public ModelAndView(String viewName) {
        this.viewName = viewName;
        this.redirectUrl = null;
    }

    private ModelAndView(String redirectUrl, boolean redirect) {
        this.viewName = null;
        this.redirectUrl = redirectUrl;
    }

    public static ModelAndView redirect(String url) {
        return new ModelAndView(url, true);
    }

    public ModelAndView addObject(String name, Object value) {
        model.put(name, value);
        return this;
    }

    public String getViewName() {
        return viewName;
    }

    public Map<String, Object> getModel() {
        return Collections.unmodifiableMap(model);
    }

    public boolean isRedirect() {
        return redirectUrl != null;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }
}
