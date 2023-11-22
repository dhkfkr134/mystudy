import java.util.InputMismatchException;
import java.util.Scanner;

public class Hello {
  private int num1;
  private int num2;
  private char oper;
  private Scanner scanner;

  public Hello() {
    this.scanner = new Scanner(System.in);
  }

  public int getNum() {
    int input;
    while (true) {
      try {
        input = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리
        break;
      } catch (InputMismatchException e) {
        System.out.println("Please enter a valid number:");
        scanner.nextLine(); // 잘못된 입력을 처리하기 위해 버퍼를 비움
      }
    }
    return input;
  }

  public char getOper() {
    char operation;
    while (true) {
      try {
        operation = scanner.next().charAt(0);
        scanner.nextLine(); // 개행 문자 처리
        break;
      } catch (StringIndexOutOfBoundsException e) {
        System.out.println("Please enter a valid operator:");
        scanner.nextLine(); // 잘못된 입력을 처리하기 위해 버퍼를 비움
      }
    }
    return operation;
  }

  public void calculate() {
    System.out.println("Enter the first number:");
    num1 = getNum();

    System.out.println("Enter the second number:");
    num2 = getNum();

    System.out.println("Enter the operator (+, -, *, /):");
    oper = getOper();

    System.out.print("Result: ");
    switch (oper) {
      case '+':
        System.out.print(num1 + num2);
        break;
      case '-':
        System.out.print(num1 - num2);
        break;
      case '*':
        System.out.print(num1 * num2);
        break;
      case '/':
        if (num2 != 0) {
          System.out.print(num1 / num2);
        } else {
          System.out.print("Cannot divide by zero");
        }
        break;
      default:
        System.out.print("Invalid operator");
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello, World 안녕 세계");
    System.out.println("Hello, World 안녕 세계222222");
    Hello h1 = new Hello();
    h1.calculate();
    h1.scanner.close(); // 프로그램 종료 시 Scanner 닫기
  }
}
