package bitcamp.myapp.handler;

import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class AssignmentAddHandler implements MenuHandler {

  AssignmentRepository assignmentRepository;
  Prompt prompt;

  public AssignmentAddHandler(AssignmentRepository assignmentRepository, Prompt prompt){
    this.assignmentRepository = assignmentRepository;
    this.prompt = prompt;
  }
  @Override
  public void action(){
    System.out.println("과제: ");

    if(this.assignmentRepository.length == this.assignmentRepository.assignments.length){
      int oldSize = this.assignmentRepository.assignments.length;
      int newSize = oldSize + (oldSize >> 1);

      Assignment[] arr = new Assignment[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.assignmentRepository.assignments[i];
      }

      this.assignmentRepository.assignments = arr;
    }

    Assignment assignment = new Assignment();
    assignment.title = this.prompt.input("과제명? ");
    assignment.content = this.prompt.input("내용? ");
    assignment.deadline = this.prompt.input("제출 마감일? ");

    assignmentRepository.assignments[assignmentRepository.length++] = assignment;
    }

}
