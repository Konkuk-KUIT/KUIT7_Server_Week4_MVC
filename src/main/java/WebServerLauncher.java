import frontcontroller.FrontControllerServlet;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import servlet.HomeServlet;
import servlet.MemberDetailServlet;
import servlet.MemberFormServlet;
import servlet.MemberListServlet;
import servlet.MemberSaveServlet;

public class WebServerLauncher {

    public static void main(String[] args) throws Exception {

        String webappDirLocation = "webapp/";

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.getConnector();

        // 현재 프로젝트 기준 디렉토리
        String absolutePath = new File(webappDirLocation).getAbsolutePath();

        Context context = tomcat.addWebapp("", absolutePath);

        // classes 경로 설정 (중요🔥)
        File additionWebInfClasses = new File("build/classes/java/main");
        context.setResources(new org.apache.catalina.webresources.StandardRoot(context));
        context.getResources().addPreResources(
                new org.apache.catalina.webresources.DirResourceSet(
                        context.getResources(),
                        "/WEB-INF/classes",
                        additionWebInfClasses.getAbsolutePath(),
                        "/"
                )
        );

        Tomcat.addServlet(context, "frontControllerServlet", new FrontControllerServlet());
        context.addServletMappingDecoded("/front-controller/*", "frontControllerServlet");

        tomcat.start();
        tomcat.getServer().await();
    }
}