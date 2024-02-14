package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import bitcamp.util.TransactionManager;
import java.sql.Connection;
import java.util.ArrayList;
import org.checkerframework.checker.units.qual.A;

public class BoardAddHandler extends AbstractMenuHandler {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;
  private TransactionManager txManager;

  public BoardAddHandler(TransactionManager txManager, BoardDao boardDao, AttachedFileDao attachedFileDao) {
    this.boardDao = boardDao;
    this.attachedFileDao = attachedFileDao;
    this.txManager = txManager;
  }

  @Override
  protected void action(Prompt prompt) {
    Board board = new Board();
    board.setTitle(prompt.input("제목? "));
    board.setContent(prompt.input("내용? "));
    board.setWriter(prompt.input("작성자? "));

    ArrayList<AttachedFile> files = new ArrayList<>();
    while (true) {
      String filepath = prompt.input("파일?(종료: 그냥 엔터)");
      if (filepath.isEmpty()){
        break;
      }
      files.add(new AttachedFile().filePath(filepath));
      System.out.println("boardAddHandler-파일입력");
    }

    try {
      txManager.startTransaction();
      boardDao.add(board);
      if(!files.isEmpty()){
        for(AttachedFile file : files){
          file.setBoardNo((board.getNo()));
        }
        attachedFileDao.addAll(files);
      }
      txManager.commit();
    } catch (Exception e){
      e.printStackTrace();
      try {
        txManager.rollback();
      } catch (Exception e2){}
    }
  }
}
