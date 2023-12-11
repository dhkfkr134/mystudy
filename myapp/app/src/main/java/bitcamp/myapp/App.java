package bitcamp.myapp;

import bitcamp.myapp.Menu.BoardAddHandler;
import bitcamp.myapp.Menu.BoardDeleteHandler;
import bitcamp.myapp.Menu.BoardListHandler;
import bitcamp.myapp.Menu.BoardModifyHandler;
import bitcamp.myapp.Menu.BoardRepository;
import bitcamp.myapp.Menu.BoardViewHandler;
import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.MenuItem;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {
    Prompt prompt = new Prompt();
    //new MainMenu(prompt).execute();
    BoardRepository boardRepository = new BoardRepository();
    MenuGroup mainMenu = new MenuGroup("메인");



    MenuGroup assignmentMenu = new MenuGroup("과제");
    assignmentMenu.add(new MenuItem("등록"));
    assignmentMenu.add(new MenuItem("조회"));
    assignmentMenu.add(new MenuItem("변경"));
    assignmentMenu.add(new MenuItem("삭제"));
    assignmentMenu.add(new MenuItem("목록"));
    mainMenu.add(assignmentMenu);




    MenuGroup boardMenu = new MenuGroup("게시글");
    // 사용자로부터 게시글을 입력 받아서 배열에 저장하는 일을 한다.
    MenuHandler boardAddHandler = new BoardAddHandler(boardRepository,prompt);

    // "등록" 이라는 메뉴를 선택했을 때 BoardAddHandler를 실행시키는 일을 한다.
    MenuItem boardAddMenu =new MenuItem("등록", boardAddHandler);
    //
    boardMenu.add(boardAddMenu);
    boardMenu.add(new MenuItem("조회", new BoardViewHandler()));
    boardMenu.add(new MenuItem("변경", new BoardModifyHandler()));
    boardMenu.add(new MenuItem("삭제", new BoardDeleteHandler()));
    boardMenu.add(new MenuItem("목록", new BoardListHandler(boardRepository,prompt)));
    mainMenu.add(boardMenu);

    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new MenuItem("등록"));
    memberMenu.add(new MenuItem("조회"));
    memberMenu.add(new MenuItem("변경"));
    memberMenu.add(new MenuItem("삭제"));
    memberMenu.add(new MenuItem("목록"));
    mainMenu.add(memberMenu);

    MenuGroup greetingMenu = new MenuGroup("가입인사");
    greetingMenu.add(new MenuItem("등록"));
    greetingMenu.add(new MenuItem("조회"));
    greetingMenu.add(new MenuItem("변경"));
    greetingMenu.add(new MenuItem("삭제"));
    greetingMenu.add(new MenuItem("목록"));
    mainMenu.add(greetingMenu);

    MenuGroup helpMenu = new MenuGroup("도움말");
    mainMenu.add(helpMenu);

    mainMenu.execute(prompt);

    prompt.close();
  }
}
