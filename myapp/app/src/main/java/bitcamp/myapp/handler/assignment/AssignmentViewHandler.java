package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;

public class AssignmentViewHandler {


  AssignmentRepository assignmentRepository;
  Prompt prompt;

  public AssignmentViewHandler(AssignmentRepository assignmentRepository, Prompt prompt) {
    this.assignmentRepository = assignmentRepository;
    this.prompt = prompt;
  }


  public void action() {
    System.out.println("조회: ");

    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.assignmentRepository.length) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }

    Assignment assignment = this.assignmentRepository.assignments[index];
    System.out.printf("과제명: %s\n", assignment.title);
    System.out.printf("내용: %s\n", assignment.content);
    System.out.printf("제출 마감일: %s\n", assignment.deadline);

  }
}
