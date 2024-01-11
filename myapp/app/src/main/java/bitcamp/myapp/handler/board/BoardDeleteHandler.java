package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.List;

public class BoardDeleteHandler extends AbstractMenuHandler {

  private BoardDao boardDao;

  public BoardDeleteHandler(BoardDao boardDao, Prompt prompt) {
    super(prompt);
    this.boardDao = boardDao;
  }

  @Override
  public void action() {

    int no = this.prompt.inputInt("번호? ");
    if (this.boardDao.delete(no) == 0){
      System.out.println("게시글 번호가 유효하지 않습니다.");
    }
    else {
      System.out.println("삭제했습니다!");
    }
  }
}
