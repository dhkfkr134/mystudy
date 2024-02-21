package com.eomcs.web;

import com.eomcs.CustomServlet;
import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@CustomServlet
@WebServlet("/hello2")
public class HelloServlet2 extends GenericServlet {
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    System.out.println("Hello2!");
  }
}
