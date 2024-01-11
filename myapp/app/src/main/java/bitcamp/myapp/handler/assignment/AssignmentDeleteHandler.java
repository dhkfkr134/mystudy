package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;
import java.util.List;

public class AssignmentDeleteHandler extends AbstractMenuHandler {

  private AssignmentDao assignmentDao;


  public AssignmentDeleteHandler(AssignmentDao assignmentDao, Prompt prompt) {
    super(prompt);
    this.assignmentDao = assignmentDao;
  }

  @Override
  public void action() {

      int index = this.prompt.inputInt("번호? ");
      if (this.assignmentDao.delete(index) == 0){
        System.out.println("과제글 번호가 유효하지 않습니다.");
      } else {
        System.out.println("삭제했습니다!");
      }
  }
}
