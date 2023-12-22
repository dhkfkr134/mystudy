package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class MemberDeleteHandler extends AbstractMenuHandler {

  private ArrayList<Member> objectRepository;

  public MemberDeleteHandler(ArrayList<Member> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  public void action() {

    int index = this.prompt.inputInt("번호? ");
    this.objectRepository.remove(index);
  }
}
