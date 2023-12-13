package bitcamp.myapp.handler;

import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;

public class AssignmentListHandler implements MenuHandler {
  AssignmentRepository assignmentRepository;

  public AssignmentListHandler(AssignmentRepository assignmentRepository) {
    this.prompt = prompt;
  }
  @Override
  public void action() {
    System.out.println("과제 목록");
    System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

    for (int i = 0; i < this.assignmentRepository.length; i++) {
      Assignment assignment = this.assignmentRepository.assignments[i];
      System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
    }
  }
}
