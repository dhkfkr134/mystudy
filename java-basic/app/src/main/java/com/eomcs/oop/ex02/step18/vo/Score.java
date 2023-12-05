package com.eomcs.oop.ex02.step18.vo;

// ## 사용자 정의 데이터 타입 만들기
//

public class Score {
  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;
  
  //생성자

  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    
    this.compute();
  }
  
  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3;
  }

}

