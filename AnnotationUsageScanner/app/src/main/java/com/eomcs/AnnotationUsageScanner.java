package com.eomcs;
import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/* 서블릿에 대해서 알아보다보니
   어노테이션을 서블릿컨테이너가 어떻게 처리하는지 궁금했다.

   웹서버 구현 순서를 생각해보면,
   1) 웹 브라우저에서 동적경로를 요청한다.
   2) 나는 지금 톰켓 서버를 사용하고 있으므로 서블릿 컨테이너역할을 하는 톰켓서버에서 내 어플리케이션에
      해당 자원(경로)를 요청할 것이다.
   3) 해당 경로와 매칭되는 값을 갖는 클래스를 어노테이션을 통해 찾는다. ex) WebServlet("/test")
   4) 해당 클래스의 객체를 생성한다.
   5) Servlet Container가 다루는 Servlet, Filter, Listener의 메서드를 동작시킨다.
   이런 순서에서 어떻게 서블릿 컨테이너가 해당경로와 매칭되는 클래스의 정보를 알고 생성자를 실행시키는지 궁금해졌다.

   정확한 구현은 알 수 없고, 어떤 방식으로 구현했는지는 잘 찾아보면 나오겠지만
   나는 그냥 1)롬북을 사용하거나 2)어노테이션을 지정한 클래스정보를 찾을 수 있다고 생각했다.
   그래서 2번의 방법을 구현해보았다.

   간단하게 Servlet클래스는 한 패키지 안에 있다고 가정하고, WebServlet어노테이션역할을 하는 CustomServlet어노테이션
   을 만들어서 Servlet패키지 안에서 WebServlet어노테이션을 명시한 클래스를 찾는 방법을 구현해 보았다. */

public class AnnotationUsageScanner {

  public AnnotationUsageScanner start() {
    List<Class<?>> classesWithAnnotation = findClassesWithAnnotation("com.eomcs", CustomServlet.class);
    // 출력
    for (Class<?> clazz : classesWithAnnotation) {
      System.out.println("Class with annotation: " + clazz.getName());
    }
    return this;
  }

  public static List<Class<?>> findClassesWithAnnotation(String packageName, Class<? extends Annotation> annotationClass) {
    List<Class<?>> classesWithAnnotation = new ArrayList<>();

    // 패키지 내의 모든 클래스를 가져와서 애노테이션을 가진 클래스인지 확인
    try {
      for (Class<?> clazz : getClasses(packageName)) {
        if (clazz.isAnnotationPresent(annotationClass)) {
          classesWithAnnotation.add(clazz);
        }
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    return classesWithAnnotation;
  }

  public static List<Class<?>> getClasses(String packageName) throws ClassNotFoundException {
    List<Class<?>> classes = new ArrayList<>();
    Package pkg = Package.getPackage(packageName);
    if (pkg == null) {
      return classes;
    }
    String packagePath = packageName.replace('.', '/');
    for (String className : getClassNames()) {
      Class<?> clazz = Class.forName(packageName + ".web" + "." + className);
      classes.add(clazz);
    }


    return classes;
  }

  public static List<String> getClassNames() {
    List<String> classNames = new ArrayList<>();
    File packageDir = new File("./build/classes/java/main/com/eomcs/web");
    if (packageDir.exists() && packageDir.isDirectory()) {
      File[] files = packageDir.listFiles();
      if (files != null) {
        for (File file : files) {
          if (file.isFile() && file.getName().endsWith(".class")) {
            String className = file.getName().substring(0, file.getName().lastIndexOf('.'));
            classNames.add(className);
          }
        }
      }
    }
    return classNames;
  }
}