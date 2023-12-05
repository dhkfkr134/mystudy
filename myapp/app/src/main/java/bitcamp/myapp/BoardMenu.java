package bitcamp.myapp;

public class BoardMenu {

  static String title;
  static String content;
  static String name;
  static String dateCreated;

  static void printMenu() {
    System.out.println("[게시글]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("0. 이전");
  }

  static void execute() {
    printMenu();
    while (true) {
      String input = Prompt.input("메인/게시글> ");

      switch (input) {
        case "1":
          add();
          break;
        case "2":
          view();
          break;
        case "3":
          modify();
          break;
        case "4":
          delete();
          break;
        case "0":
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }
  static void add(){
    System.out.println("게시글 등록:");
    title = Prompt.input("제목? ");
    content = Prompt.input("내용? ");
    name = Prompt.input("작성자? ");
    dateCreated = Prompt.input("작성일? ");
  }
  static void view(){
    System.out.println("게시글 조회:");
    System.out.printf("제목: %s\n",title);
    System.out.printf("내용: %s\n",content);
    System.out.printf("작성자: %s\n",name);
    System.out.printf("작성일: %s\n",dateCreated);

  }
  static void modify(){
    System.out.println("게시글 변경:");
    title = Prompt.input("제목(%s)? ",title);
    content = Prompt.input("내용(%s)? ",content);
    name = Prompt.input("작성자(%s)? ",name);
    dateCreated = Prompt.input("작성일(%s)? ",dateCreated);
  }
  static void delete(){
    System.out.println("과제 삭제:");
    title = "";
    content = "";
    name = "";
    dateCreated = "";
  }
}
