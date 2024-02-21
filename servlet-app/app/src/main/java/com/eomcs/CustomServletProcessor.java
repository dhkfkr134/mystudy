package com.eomcs;

import javax.annotation.processing.*;
import javax.lang.model.*;
import javax.lang.model.element.*;
import java.util.*;

@SupportedAnnotationTypes("CustomServlet")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CustomServletProcessor extends AbstractProcessor {

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    for (Element element : roundEnv.getElementsAnnotatedWith(CustomServlet.class)) {
      if (element.getKind() == ElementKind.CLASS) {
        CustomServlet annotation = element.getAnnotation(CustomServlet.class);
        String servletName = annotation.value(); // Get the value of the annotation
        System.out.println("Servlet class: " + element.getSimpleName() + ", Servlet name: " + servletName);
      }
    }
    return true;
  }
}

