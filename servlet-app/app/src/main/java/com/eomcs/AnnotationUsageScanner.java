package com.eomcs;

import javax.annotation.processing.*;
import javax.lang.model.*;
import javax.lang.model.element.*;
import javax.tools.*;
import java.util.*;
import javax.tools.JavaCompiler.CompilationTask;

public class AnnotationUsageScanner {

  public AnnotationUsageScanner start() {
    // Initialize the compiler task
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

    // Set up the compilation task
    Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromStrings(Arrays.asList("src/main/java"));
    CompilationTask task = compiler.getTask(null, fileManager, null, null, null, compilationUnits);

    // Set up the annotation processor
    Set<String> annotations = new HashSet<>();
    annotations.add("com.eomcs.CustomServlet"); // Replace YourPackage.A with the fully qualified name of your annotation
    task.setProcessors(Collections.singleton(new AnnotationProcessor(annotations)));

    // Run the annotation processor
    task.call();
    return this;
  }

  static class AnnotationProcessor extends AbstractProcessor {
    private final Set<String> annotations;

    AnnotationProcessor(Set<String> annotations) {
      this.annotations = annotations;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
      for (TypeElement annotation : annotations) {
        if (this.annotations.contains(annotation.getQualifiedName().toString())) {
          Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);
          for (Element element : annotatedElements) {
            System.out.println("Class " + element.getSimpleName() + " uses annotation " + annotation);
          }
        }
      }
      return false;
    }
  }
}
