package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import bitcamp.util.TransactionManager;
import java.sql.Connection;

public class BoardAddHandler extends AbstractMenuHandler {

  private BoardDao boardDao;
  private TransactionManager txManager;

  public BoardAddHandler(TransactionManager txManager, BoardDao boardDao) {
    this.boardDao = boardDao;
    this.txManager = txManager;
  }

  @Override
  protected void action(Prompt prompt) {
    Board board = new Board();
    board.setTitle(prompt.input("제목? "));
    board.setContent(prompt.input("내용? "));
    board.setWriter(prompt.input("작성자? "));

    Connection con = null;
    try {
      txManager.startTransaction();
      boardDao.add(board);
      boardDao.add(board);
      Thread.sleep(10000);
      boardDao.add(board);
      txManager.rollback();
    } catch (Exception e){
      try {con.rollback();} catch (Exception e2){}
    }
  }
}
