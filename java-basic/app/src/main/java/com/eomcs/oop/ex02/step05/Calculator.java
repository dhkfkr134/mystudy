package com.eomcs.oop.ex02.step05;

public class Calculator {
  // 인스턴스 변수(= non-static 변수)
  // - 작업 결과를 개별적으로 관리하고 싶을 때 인스턴스 변수로 선언한다.
  // - 인스턴스 변수는 클래스가 로딩 될 때 만들어지지 않는다.
  // - new 명령을 사용해서 만들어야 한다.
  // - 변수 선언 앞에 static이 붙지 않는다.
  int result = 0;

  static void plus(Calculator instance, int value) {
    // 메서드 작업 결과는 클래스 변수에 보관한다.
    instance.result += value; // result = result + value
  }

  static void minus(Calculator instance, int value) {
    instance.result -= value; // result = result - value
  }

  static void multiple(Calculator instance, int value) {
    instance.result *= value; // result = result * value
  }

  static void divide(Calculator instance, int value) {
    instance.result /= value; // result = result / value
  }

  // 인스턴스를 사용하지 않는 메서드라면 그냥 클래스 메서드로 두어라.
  static int abs(int a) {
    return a >= 0 ? a : a * -1;
  }
}
