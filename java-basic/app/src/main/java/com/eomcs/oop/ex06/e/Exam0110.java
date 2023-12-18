// final 사용법: 상속 불가!
package com.eomcs.oop.ex06.e;

// 클래스에 final 을 붙이면 이 클래스의 서브 클래스를 만들 수 없다.
// - 서브 클래스의 생성을 방지하여
//   기존 클래스를 대체하지 못하도록 할 때 사용한다.
// - 예)
//     java.lang.String
//
final class A1 {
}

//서브 클래스를 정의하지 못한다.
// class A2 extends A1 {
//  
//}

//String 클래스는 final클래스이다. 서브 클래스 정의 불가능
//class MyString extends String{
//  
//}

// final 클래스를 상속 받을 수 없다.
public class Exam0110 // extends A
{
  public static void main(String[] args) {
    m(new A1());
    
    //상속 받지 못해서 m()의 인자로 못 넘긴다.
//    m(new A2());
    
  }
  static void m(A1 obj) {
    
  }
}
