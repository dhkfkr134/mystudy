package com.eomcs.reflect.ex06.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Exam0120 {
  public static void main(String[] args) {
    Class<?> clazz = Exam0120.class;
    ClassLoader classLoader = clazz.getClassLoader();
    Class<?>[] interfaceTypes = new Class<?>[] {A.class, B.class, C.class};
    
    InvocationHandler invocationHandler = new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("===>" + method.getName());
        return null;
      }
      
    };
    
    Object obj = Proxy.newProxyInstance(classLoader, interfaceTypes, invocationHandler);
    
    ((A)obj).m1();
    ((B)obj).m2();
  }
}
