package bitcamp.menu;

import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public abstract class AbstractMenuHandler implements MenuHandler{

  protected Prompt prompt;
  protected Menu menu;

  public AbstractMenuHandler(Prompt prompt) {
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
  printMenuTitle(menu.getTitle());
  this.menu = menu;

  // Menu를 실행할 때 이 메서드가 호출되면
    // 즉시 서브 클래스의 다음 메서드를 호출한다.
  this.action();
  }
  private void printMenuTitle(String title){
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, title);
  }
  // AbstractMenuHandler를 상속하는 클래스에서 action()을 구현하게 강제한다.
  // 외부에서 호출할 메서드가 아니라 접근 범위를 protected로 제한한다.
  protected abstract void action();
}
