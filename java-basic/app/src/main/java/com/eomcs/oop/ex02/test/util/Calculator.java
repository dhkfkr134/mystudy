package com.eomcs.oop.ex02.test.util;

// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입
// 4) 인스턴스 변수 도입
// 5) 인스턴스 메서드 활용
// 6) 패키지 멤버 클래스로 분리
// 7) 클래스를 역할에 따라 패키지로 분류하기
//
public class Calculator {

  public int result = 0;

  public static int a = 0;

  public int plus(int b) {
    this.result += b;
    return this.result;
  }

  public int minus(int b) {
    this.result -= b;
    return this.result;
  }

  public int multiple(int b) {
    this.result *= b;
    return this.result;
  }

  public int divide(int b) {
    this.result /= b;
    return this.result;
  }

}


