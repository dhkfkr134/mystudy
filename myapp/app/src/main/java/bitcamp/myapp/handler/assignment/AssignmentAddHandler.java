package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenu;
import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;
import bitcamp.util.List;
import bitcamp.util.Prompt;
import java.sql.Date;
import java.util.ArrayList;

public class AssignmentAddHandler extends AbstractMenuHandler {

  private List<Assignment> objectRepository;


  public AssignmentAddHandler(List<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  public void action() {

    try {
      Assignment assignment = new Assignment();
      assignment.setTitle(this.prompt.input("과제명? "));
      assignment.setContent(this.prompt.input("내용? "));
      assignment.setDeadline(this.prompt.inputDate("제출 마감일?(yyyy-mm-dd) "));

      this.objectRepository.add(assignment);

    } catch (Exception e){
      System.out.println("과제 입력 중 오류 방생");
      System.out.println("다시 시도하시기 바랍니다");
    }

  }
}
