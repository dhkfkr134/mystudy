package bitcamp.myapp.Menu;

import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

// 게시글의 '목록'메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 Menuhandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardListHandler implements MenuHandler {

  Prompt prompt;
  BoardRepository boardRepository;

  public BoardListHandler(BoardRepository boardRepository, Prompt prompt) {
    this.boardRepository = boardRepository;
    this.prompt = prompt;
  }
    @Override
    public void action() {
      System.out.println("게시글 목록:");
      System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

      for (int i = 0; i < this.boardRepository.length; i++) {
        Board board = this.boardRepository.boards[i];
        System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
      }
    }
  }
