package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import bitcamp.util.List;
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class MemberViewHandler extends AbstractMenuHandler {

  private List<Member> objectRepository;

  public MemberViewHandler(List<Member> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  public void action() {

    int index = this.prompt.inputInt("번호? ");
    Member member = this.objectRepository.get(index);
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("가입일: %s\n", member.getCreatedDate());
  }
}
