package com.eomcs.lang.ex99;

public class Test {
  public static void main(String[] args) {

    java.util.Scanner scanner = new java.util.Scanner(System.in);
    int all = Integer.parseInt(scanner.nextLine());
    int num = Integer.parseInt(scanner.nextLine());
    int sum = 0;
    int price = 0;
    int count = 0;
    for (int i = 0; i < num; i++) {
      price = scanner.nextInt();
      count = scanner.nextInt();
      scanner.nextLine();
      sum += price * count;
    }
    scanner.close();
    if (all == sum) {
      System.out.print("yes");
    } else
      System.out.print("no");
  }
}
