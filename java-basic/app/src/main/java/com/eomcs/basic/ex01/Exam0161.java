// Object 클래스 - getClass() : 해당 클래스의 정보를 리턴한다.
package com.eomcs.basic.ex01;


public class Exam0161 {

  static class My {
  }
  

  public static void main(String[] args) {
  //primitive Type은 Object의 서브 클래스가 아니기 때문에 getClass()를 호출할 수 없다.
    // 대신 Staticc 변수인 class를 사용하여 Class 정보를 리턴 받을 수 있다.
    Class classInfo = byte.class;
   System.out.println(classInfo.getName());
   System.out.println(short.class.getName());

  }
}







