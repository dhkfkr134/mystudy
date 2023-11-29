/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.myapp;

public class App {

  public static void main(String[] args) throws InterruptedException {

//    String ANSI_RED = "\003[0;31m";
//    String ANSI_BOLD_RED = "\033[1;31m";
//    String ANSI_CLEAR = "\033[0m";
//    String appTitle = "[과제관리 시스템]";
//    String menu1 = "1. 과제",
//        menu2 = "2. 게시글",
//        menu3 = "3. 도움말",
//        menu4 = "4. 종료";
//    System.out.println(ANSI_BOLD_RED + "[과제관리 프로젝트]" + ANSI_CLEAR);
//    System.out.print("\u001B[38;2;255;180;255m" + menu1 + "\n\u001B[0;22m");
//    System.out.println("\u001B[30;48;2;107;102;255m" + menu2 + "\u001B[0;22m");
//    System.out.printf("\u001B[30;47m" + "3. %s", menu3 + "\n\u001B[0;22m");
//    System.out.println("\u001B[90;47m" + menu4 + "\n\u001B[0;22m");

    String ANSI_RED = "\003[0;31m";
    String ANSI_BOLD_RED = "\033[1;31m";
    String ANSI_CLEAR = "\033[0m";
    String appTitle = "[과제관리 시스템]";
    String menu1 = "1. 과제",
        menu2 = "2. 게시글",
        menu3 = "3. 도움말",
        menu4 = "4. 종료";
    String menu = """
        %s
        %s
        %s
        %s
        %s""".formatted(appTitle, menu1, menu2, menu3, menu4);
    java.io.InputStream inputStream = System.in;
    java.util.Scanner scanner = new java.util.Scanner(inputStream);
    String input = "";

    System.out.println(menu);
    while (true) {
      System.out.print("> ");

      try {
        input = scanner.nextLine();

        switch (input) {
          case "1":
            System.out.println("과제입니다.");
            break;
          case "2":
            System.out.println("게시글입니다.");
            break;
          case "3":
            System.out.println("도움말입니다.");
            break;
          case "4":
            System.out.println("종료합니다.");
            break;
          case "menu":
            System.out.println(menu);
            break;
          default:
            System.out.println("1~4까지의 정수를 입력하세요");
        }
        if (input.equals("4")) {
          break;
        }
      } catch (Exception e) {
        System.out.println("[ERROR]");
        scanner.nextLine();
      }


    }
    scanner.close();
  }
}
