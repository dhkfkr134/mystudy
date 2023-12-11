package bitcamp.myapp;

import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {
    Prompt prompt = new Prompt();
    new MainMenu(prompt).execute();
    prompt.close();
  }
}
