package com.eomcs.oop.ex02.step15;

// ## 사용자 정의 데이터 타입 만들기
//

public class Score {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
  
  void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3;
  }

}

