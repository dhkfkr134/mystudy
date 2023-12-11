package bitcamp.myapp;

import bitcamp.myapp.Menu.AssignmentMenu;
import bitcamp.myapp.Menu.BoardMenu;
import bitcamp.myapp.Menu.MemberMenu;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public class MainMenu {

  Prompt prompt;


  static final String APP_TITLE = AnsiEscape.ANSI_BOLD_RED + "[과제관리 시스템]" + AnsiEscape.ANSI_CLEAR;
  static final String[] MENUS = {
      "1. 과제",
      "2. 게시글",
      "3. 회원",
      "4. 가입 인사",
      "5. 도움말",
      AnsiEscape.ANSI_RED + "0. 종료" + AnsiEscape.ANSI_CLEAR
  };
  public MainMenu(Prompt prompt){
    this.prompt = prompt;
  }

  static void printMenu() {
    System.out.println(APP_TITLE);
    System.out.println();
    for (String menu : MENUS) {
      System.out.println(menu);
    }
  }

  void execute() {

    AssignmentMenu assignmentMenu = new AssignmentMenu("과제",this.prompt);
    BoardMenu boardMenu = new BoardMenu("게시글",this.prompt);
    BoardMenu greedingMenu = new BoardMenu("가입 인사",this.prompt);
    MemberMenu memberMenu = new MemberMenu("회원",this.prompt);
    printMenu();

    while (true) {
      String input = this.prompt.input("메인> ");

      switch (input) {
        case "1":
          assignmentMenu.execute();
          break;
        case "2":
          boardMenu.execute();
          break;
        case "3":
          memberMenu.execute();
          break;
        case "4":
          greedingMenu.execute();
          break;
        case "5":
          System.out.println("도움말입니다.");
          break;
        case "0":
          System.out.println("종료합니다.");
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }
}
