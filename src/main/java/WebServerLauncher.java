import frontcontroller.FrontControllerServlet;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class WebServerLauncher {

    public static void main(String[] args) throws Exception {
        String webappDirLocation = "webapp/";

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        String absolutePath = new File(webappDirLocation).getAbsolutePath();

        Context context = tomcat.addWebapp("", absolutePath);

        File additionWebInfClasses = new File("out/production/classes");

        context.setResources(new org.apache.catalina.webresources.StandardRoot(context));
        context.getResources().addPreResources(
                new org.apache.catalina.webresources.DirResourceSet(
                        context.getResources(),
                        "/WEB-INF/classes",
                        additionWebInfClasses.getAbsolutePath(),
                        "/"
                )
        );

        FrontControllerServlet frontControllerServlet = new FrontControllerServlet();

        Tomcat.addServlet(context, "frontControllerServlet", frontControllerServlet);
        context.addServletMappingDecoded("/front-controller/*", "frontControllerServlet");

        tomcat.start();
        tomcat.getServer().await();
    }
}