package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class MemberModifyHandler extends AbstractMenuHandler {

  private ArrayList<Member> objectRepository;

  public MemberModifyHandler(ArrayList<Member> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  public void action() {

    int index = this.prompt.inputInt("번호? ");
    Member old = this.objectRepository.get(index);

    Member member = new Member();
    member.setEmail(this.prompt.input("이메일(%s)? ", old.getEmail()));
    member.setName(this.prompt.input("이름(%s)? ", old.getName()));
    member.setPassword(this.prompt.input("새 암호? "));
    member.setCreatedDate(this.prompt.input("가입일(%s)? ", old.getCreatedDate()));

    this.objectRepository.set(index, member);
  }
}
