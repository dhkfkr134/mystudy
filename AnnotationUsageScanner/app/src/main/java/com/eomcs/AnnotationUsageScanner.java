package com.eomcs;
import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

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