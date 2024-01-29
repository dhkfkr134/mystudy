package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.vo.Assignment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.units.qual.A;

public class AssignmentDaoImpl implements AssignmentDao {

  Connection con;

  public AssignmentDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Assignment assignment) {
    try {
      Statement stmt = con.createStatement();
      con.createStatement().executeUpdate(String.format(
          "insert into assignments(title, content, deadline) values('%s','%s','%s')",
          assignment.getTitle(),assignment.getContent(), assignment.getDeadline()));
    } catch (Exception e){
      throw new DaoException("데이터 가져오기 오류",e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return con.createStatement().executeUpdate(String.format(
          "delete from assignments where assignment_no=%d",no));
    } catch (Exception e){
      throw new DaoException("데이터 가져오기 오류",e);
    }
  }

  @Override
  public List<Assignment> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = con.createStatement().executeQuery("select * from assignments");

      ArrayList<Assignment> list = new ArrayList<>();
      while (rs.next()) {
        Assignment assignment = new Assignment();

        assignment.setNo(rs.getInt("assignment_no"));
        assignment.setTitle(rs.getString("title"));
        assignment.setContent(rs.getString("content"));
        assignment.setDeadline(rs.getDate("deadline"));

        list.add(assignment);
      }
      return list;
    } catch (Exception e){
      throw new DaoException("데이터 가져오기 오류",e);
    }
  }

  @Override
  public Assignment findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = con.createStatement().executeQuery(String.format(
          "select * from assignments where assignment_no = %d", no));

      if (rs.next()) {
        Assignment assignment = new Assignment();

        assignment.setNo(rs.getInt("assignment_no"));
        assignment.setTitle(rs.getString("title"));
        assignment.setContent(rs.getString("content"));
        assignment.setDeadline(rs.getDate("deadline"));

        return assignment;
      }
      return null;
    } catch (Exception e){
      throw new DaoException("데이터 가져오기 오류",e);
    }
  }

  @Override
  public int update(Assignment assignment) {
    try {
      return con.createStatement().executeUpdate(String.format(
          "update assignments set title='%s', content='%s', deadline='%s' where assignment_no=%d",
          assignment.getTitle(),assignment.getContent(), assignment.getDeadline(),assignment.getNo()));
    } catch (Exception e){
      throw new DaoException("데이터 가져오기 오류",e);
    }
  }
}
