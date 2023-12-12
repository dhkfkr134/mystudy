package bitcamp.myapp.handler.board;

import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

// 게시글의 '등록'메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 Menuhandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardViewHandler implements MenuHandler {

  BoardRepository boardRepository;
  Prompt prompt;
  public BoardViewHandler(BoardRepository boardRepository, Prompt prompt){
    this.boardRepository = boardRepository;
    this.prompt = prompt;
  }

  @Override
  public void action() {
    System.out.println("게시글 조회:");

    int index = this.prompt.inputInt("번호? ");
    if (index < 0 || index >= this.boardRepository.length) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    Board board = this.boardRepository.boards[index];
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("작성일: %s\n", board.createdDate);
  }

}