package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;
import java.util.Iterator;
import java.util.List;

public class AssignmentListHandler extends AbstractMenuHandler {

  private AssignmentDao assignmentDao;


  public AssignmentListHandler(AssignmentDao assignmentDao, Prompt prompt) {
    super(prompt);
    this.assignmentDao = assignmentDao;
  }

  @Override
  public void action() {
    System.out.printf("%-4s\t%-20s\t%s\n","번호", "과제", "제출마감일");

    List<Assignment> assignments = this.assignmentDao.findAll();

    for (Assignment assignment : assignments){
      System.out.printf("%-4d\t%-10s\t%20s\t%4$tY-%4$tm-%4$td\n",
          assignment.getNo(),
          assignment.getTitle(),
          assignment.getContent(),
          assignment.getDeadline());
    }
  }
}
