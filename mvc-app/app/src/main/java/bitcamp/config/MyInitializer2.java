package bitcamp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.WebApplicationInitializer;

public class MyInitializer2 implements WebApplicationInitializer {

  private static Log log = LogFactory.getLog(MyInitializer2.class);

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    log.debug("MyInitializer1.onStart() 호출됨!");
  }
}
