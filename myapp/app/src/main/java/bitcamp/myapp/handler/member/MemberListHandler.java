package bitcamp.myapp.handler.member;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;
import java.util.ArrayList;

public class MemberListHandler implements MenuHandler {

  ArrayList<Member> memberRepository;

  public MemberListHandler(ArrayList<Member> objectRepository) {
    this.memberRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    System.out.printf("%-10s\t%30s\t%s\n", "이름", "이메일", "가입일");

    Member[] members = new Member[this.memberRepository.size()];
    this.memberRepository.toArray(members);
    for (Member member : members) {
      System.out.printf("%-10s\t%30s\t%s\n", member.name, member.email, member.createdDate);
    }
  }
}
