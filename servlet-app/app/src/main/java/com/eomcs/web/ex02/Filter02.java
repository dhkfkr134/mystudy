package com.eomcs.web.ex02;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/ex02/a/*")
public class Filter02 implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // 필터 객체를 생성한 후 제일 처음으로 호출된다.
    // 필터가 사용할 자원을 이 메서드에서 준비한다.
    System.out.println("Filter02.init()");
  }

  @Override
  public void destroy() {
    // 웹 애플리케이션이 종료될 때 호출된다.
    // init()에서 준비한 자원을 해제한다.
    System.out.println("Filter02.destroy()");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // 요청이 들어 올 때 마다 호출된다.
    // => 단 필터를 설정할 때 지정된 URL의 요청에만 호출된다.
    // => 서블릿이 실행되기 전에 필터가 먼저 실행된다.
    // => 서블릿을 실행한 후 다시 필터로 리턴한다.
    System.out.println("Filter02.doFilter() : 시작");

    // 다음 필터를 실행하거나 요청한 서블릿을 실행하려면 다음 코드를 반드시 실행해야 한다.
    chain.doFilter(request, response);

    // 체인에 연결된 필터나 서블릿이 모두 실행된 다음에 다시 이 필터로 리턴될 것이다.
    System.out.println("Filter02.doFilter() : 종료");
  }
}


