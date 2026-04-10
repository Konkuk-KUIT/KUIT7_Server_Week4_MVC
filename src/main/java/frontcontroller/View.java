package frontcontroller;

public class View {

    private final String jspPath;

    public View(String jspPath) {
        this.jspPath = "/WEB-INF/views/" + jspPath + ".jsp";
    }

    public String getJspPath() {
        return jspPath;
    }
}
