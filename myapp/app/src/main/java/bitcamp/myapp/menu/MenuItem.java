package bitcamp.myapp.Menu;

import bitcamp.util.Prompt;

// Composite 패턴에서 leaf 역할을 수행한는 클래스
// Lea?
// 하위 항ㅁ공ㄹ 포함하지 않는 말단 객체
// - 예를 들어 파일시스템에서 '파일에 해당한다.
public class MenuItem implements Menu{
  String title;

  public MenuItem(String title) {
    this.title = title;
  }
  public void execute(Prompt prompt){
    System.out.printf("[%s]\n",this.title);
  }

  @Override
  public String getTitle() {
    return this.title;
  }
}
