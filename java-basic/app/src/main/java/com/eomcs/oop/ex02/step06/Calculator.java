package com.eomcs.oop.ex02.step06;

public class Calculator {
  // 인스턴스 변수(= non-static 변수)
  // - 작업 결과를 개별적으로 관리하고 싶을 때 인스턴스 변수로 선언한다.
  // - 인스턴스 변수는 클래스가 로딩 될 때 만들어지지 않는다.
  // - new 명령을 사용해서 만들어야 한다.
  // - 변수 선언 앞에 static이 붙지 않는다.
  int result = 0;


  void plus(int value) {
    // 메서드를 호출할 때 앞에서 전달한 인스턴스는
    // this라는 이름의 내장 변수에 자동 저장된다.
    this.result += value; // result = result + value
  }

  void minus(int value) {
    this.result -= value; // result = result - value
  }

  void multiple(int value) {
    this.result *= value; // result = result * value
  }

  void divide(int value) {
    this.result /= value; // result = result / value
  }

  static int abs(int a) {
    // 스태틱 메서드는 this라는 내장 변수가 없다.
    return a >= 0 ? a : a * -1;
  }
}
