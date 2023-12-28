package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;
import bitcamp.util.List;
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class AssignmentModifyHandler extends AbstractMenuHandler {

  private List<Assignment> objectRepository;


  public AssignmentModifyHandler(List<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  public void action() {
    try {
      int index = 0;
      Assignment old = null;
      index = this.prompt.inputInt("번호? ");
      old = this.objectRepository.get(index);

      Assignment assignment = new Assignment();
      assignment.setTitle(this.prompt.input("과제명(%s)? ", old.getTitle()));
      assignment.setContent(this.prompt.input("내용(%s)? ", old.getContent()));
      assignment.setDeadline(this.prompt.inputDate("제출 마감일(%s)? ", old.getDeadline()));

      this.objectRepository.set(index, assignment);

    } catch (NumberFormatException e){
      System.out.println("숫자를 입력하세요!");
    } catch (IndexOutOfBoundsException e){
      System.out.println("과제 번호가 유효하지 않습니다.");
    } catch (IllegalArgumentException e) {
      System.out.println("과제 변경 오류!");
      System.out.println("다시 실행 하세요");
    } catch (Exception e) {
      System.out.println("실행오류"+e);
    }
  }
}
