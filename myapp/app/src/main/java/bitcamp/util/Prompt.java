package bitcamp.util;

import java.util.Scanner;

public class Prompt {

  Scanner keyIn = new Scanner(System.in);

  public String input(String title, Object... args) {
    System.out.print(String.format(title, args));
    return keyIn.nextLine();
  }

  int inputInt(String title, Object... args) {
    return Integer.parseInt(this.input(title,args));
  }
  Float inputFloat(String title, Object... args) {
    return Float.parseFloat(this.input(title,args));
  }
  Boolean inputBoolean(String title, Object... args) {
    return Boolean.parseBoolean(this.input(title,args));
  }

  public void close() {
    keyIn.close();
  }
}
