package com.eomcs.oop.ex02.step14;

// ## 사용자 정의 데이터 타입 만들기
//

public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
  
  static void compute(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = (float) s.sum / 3;
  }

}

