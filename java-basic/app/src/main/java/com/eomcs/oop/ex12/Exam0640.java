// 메서드 레퍼런스 - 활용예
package com.eomcs.oop.ex12;

import java.util.function.Predicate;

public class Exam0640 {
  
  static class My {
    public static boolean test1(String value) {
      return true;
    }
    
    public boolean test2(String value) {
      return true;
    }
    
    public static boolean test3() {
      return true;
    }
    
    public boolean test4() {
      return true;
    }
  }
  

  public static void main(String[] args) {

    Predicate<String> p1 = My::test1;
    My my = new My();
    Predicate<String> p2 = my::test2;
    
    Predicate<String> p3 = My::test3;
    
    My my2 = new My();
    Predicate<String> p4 = my2::test4;
    
    Predicate<My> p5 = My::test4;
    // 제네릭을 사용하면 왼쪽 함수의 파라미터가
    // 오른쪽 함수를 실행하는 인스턴스로 바뀐다.
  }

}


