package com.eomcs.oop.ex02.step17;

import com.eomcs.oop.ex02.step17.vo.Score;

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
//  - 
public class App {
  public static void main(String[] args) {
    // 사용자 정의 데이터 타입을 사용하는 방법
    // - new 명령을 사용하여 설계도에 기술된 대로 메모리(변수)를 준비한다.
    // - 변수는 Heap 영역에 생성된다.
    // - 변수들이 생성된 메모리의 주소를 레퍼런스(주소 변수)에 저장한다.
    Score s1 = new Score();
    Score s2 = new Score();
    Score s3 = new Score();
    // - Heap영역에 생성된 인스턴스의 변수는 레퍼런스를 통해 접근한다.
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 85;
    s1.sum = s1.kor + s1.eng + s1.math;
    s1.aver = (float) s1.sum / 3;
    s1.compute();
    printScore(s1);

    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 80;
    s2.math = 75;
    s2.sum = s2.kor + s2.eng + s2.math;
    s2.aver = (float) s2.sum / 3;
    s2.compute();
    printScore(s2);

    s3.name = "유관순";
    s3.kor = 80;
    s3.eng = 70;
    s3.math = 65;
    s3.sum = s3.kor + s3.eng + s3.math;
    s3.aver = (float) s3.sum / 3;
    s3.compute();
    printScore(s3);
  }
    static void printScore(Score s) {
      System.out.printf("%s: %d, %d, %d, %d, %.1f\n",
          s.name, s.kor, s.eng, s.math, s.sum, s.aver);
    }
}
