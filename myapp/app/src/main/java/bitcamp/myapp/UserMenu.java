package bitcamp.myapp;

import bitcamp.myapp.vo.User;

public class UserMenu {

  static User[] users = new User[3];
  static int length = 0;


  static void execute(){

    printMenu();


    while(true) {
      String input = Prompt.input("메인/회원> ");
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
        case "5":
          list();
          break;
        case "menu":
          printMenu();
          break;
        case "0":
          return;
        default:
          System.out.println("번호가 옳지 않습니다.");
      }
    }

  }
  static void printMenu(){
    System.out.println("[회원]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }
  static void add(){
    if(length >= users.length){
      int oldSize = users.length;
      int newSize = oldSize + (oldSize >> 1);
      User[] arr = new User[newSize];
      for(int i = 0; i < oldSize; i++){
        arr[i] = users[i];
      }
      users = arr;
    }
    User user = new User();
    user.email = Prompt.input("이메일? ");
    user.name = Prompt.input("이름? ");
    user.password = Prompt.input("암호? ");
    user.createdDate = Prompt.input("가입일? ");

    users[length++] = user;

  }
  static void view(){
    int index = Integer.parseInt(Prompt.input("회원 번호? "));
    if(index < 0 || index >= length){
      System.out.println("유효하지 않은 값");
      return;
    }
    User user = users[index];

    System.out.printf("이메일: %s\n",user.email);
    System.out.printf("이름: %s\n",user.name);
    System.out.printf("암호: %s\n",user.password);
    System.out.printf("가입일: %s\n",user.createdDate);
  }
  static void modify(){
    int index = Integer.parseInt(Prompt.input("회원 번호? "));
    if(index < 0 || index >= length){
      System.out.println("유효하지 않은 값");
      return;
    }

    User user = users[index];

    user.email = Prompt.input("이메일(%s): ",user.email);
    user.name = Prompt.input("이름(%s): ",user.name);
    user.password = Prompt.input("암호(%s): ",user.password);
    user.createdDate = Prompt.input("가입일(%s): ",user.createdDate);
  }
  static void delete(){
    int index = Integer.parseInt(Prompt.input("회원 번호? "));
    if(index < 0 || index >= length){
      System.out.println("유효하지 않은 값");
      return;
    }
    for (int i = index; i < length-1; i++){
      users[i] = users[i+1];
    }
    users[--length] = null;
  }
  static void list(){
    System.out.printf("%-20s\t%-8s\t%s\n","이메일","이름","가입일");
    for (int i = 0 ; i < length; i++){
      User user = users[i];
      System.out.printf("%-20s\t%-8s\t%s\n",user.email,user.name,user.createdDate);
      System.out.println("--------------------------------------------------------------");
    }
  }

}
