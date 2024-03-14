package bitcamp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebApplicationInitializerImpl extends AbstractContextLoaderInitializer {

  private static Log log = LogFactory.getLog(WebApplicationInitializerImpl.class);
  AnnotationConfigWebApplicationContext rootContext;
  @Override
  protected WebApplicationContext createRootApplicationContext() {
    rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(RootConfig.class);
    rootContext.refresh();
    return rootContext;
  }



  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    log.debug("onStartup() 호출됨!");

    super.onStartup(servletContext);

    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();

    appContext.register(AppConfig.class);
    appContext.setParent(rootContext);
    appContext.refresh();
    Dynamic appServletRegistration = servletContext.addServlet("app", new DispatcherServlet(appContext));
    appServletRegistration.addMapping("/app/*");
    appServletRegistration.setLoadOnStartup(1);

    AnnotationConfigWebApplicationContext adminContext = new AnnotationConfigWebApplicationContext();
    adminContext.setParent(rootContext);
    adminContext.register(AdminConfig.class);
    adminContext.refresh();
    Dynamic adminServletRegistration = servletContext.addServlet("admin", new DispatcherServlet(adminContext));
    adminServletRegistration.addMapping("/admin/*");
    adminServletRegistration.setLoadOnStartup(1);
  }
}
