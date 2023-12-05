package com.eomcs.oop.ex02.step18;

import com.eomcs.oop.ex02.step18.vo.Score;

//0) 낱개 변수 사용
//1) 성적 데이터를 저장할 사용자 정의 데이터 타입을 만든다.
//2) 리팩토링: 메서드 추출(extract method), static nested class
//3) 리팩토링: 메서드 추출(extract method) = 한 개의 메서드는 한 개의 기능을 수행해야 한다.
//4) GRASP(General Responsibility Assignment Software Patterns) 패턴 
//   => Information Expert: 데이터를 다룰 때는 그 데이터를 갖고 있는 객체에게 묻는다.
// 리팩토링: 메서드 이동(Move Method)
//   => 메서드를 관련된 클래스로 이동시킨다. => 코드의 이해가 쉽다.
//5) 인스턴스 메서드: 인스턴스 주소를 받는 더 쉬운 문법
//6) 클래스를 역할에 따라 패키지로 분류
//  - 클래스가 많을 경우 유지보수하기 쉽도록 적절한 패키지로 분산 배치한다.
//  - 데이터 타입의 역할을 하는 클래스의 경우
//    보통 domain, vo(value object), dto(data transfer object) 라는 이름을 가진
//    패키지에 분류한다.
//7) 생성자 도입:
//  - 인스턴스를 생성할 때 값을 초기화시키는 특별한 메서드
//  - 
public class App {
  public static void main(String[] args) {
    // 사용자 정의 데이터 타입을 사용하는 방법
    // - new 명령을 사용하여 설계도에 기술된 대로 메모리(변수)를 준비한다.
    // - 변수는 Heap 영역에 생성된다.
    // - 변수들이 생성된 메모리의 주소를 레퍼런스(주소 변수)에 저장한다.
    Score s1 = new Score("홍길동",100, 90, 85);
    Score s2 = new Score("임꺽정", 90, 80, 75);
    Score s3 = new Score("유관순", 80,70 , 65);
    // - Heap영역에 생성된 인스턴스의 변수는 레퍼런스를 통해 접근한다.
    printScore(s1);
    printScore(s2);
    printScore(s3);
  }
    static void printScore(Score s) {
      System.out.printf("%s: %d, %d, %d, %d, %.1f\n",
          s.name, s.kor, s.eng, s.math, s.sum, s.aver);
    }
}
