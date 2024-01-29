package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

  Connection con;

  public MemberDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Member member) {
    try {
      con.createStatement().executeUpdate(String.format(
          "insert into Members(email, name, password) values('%s','%s',sha2('%s',256))",
          member.getEmail(), member.getName(),member.getPassword() ));
    } catch (Exception e){
      throw new DaoException("데이터 처리 오류",e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      return con.createStatement().executeUpdate(String.format(
          "delete from Members where member_no=%d",no));
    } catch (Exception e){
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public List<Member> findAll() {
    try {
      ResultSet rs = con.createStatement().executeQuery("select * from members");

      ArrayList<Member> list = new ArrayList<>();
      while(rs.next()) {
        Member member = new Member();

        member.setNo(rs.getInt("member_no"));
        member.setEmail(rs.getString("email"));
        member.setName(rs.getString("name"));
        member.setPassword(rs.getString("password"));
        member.setCreatedDate(rs.getDate("created_date"));

        list.add(member);
      }
      return list;
    } catch (Exception e){
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public Member findBy(int no) {
    try {
      ResultSet rs = con.createStatement().executeQuery(String.format("select * from members where member_no=%d",no));

      if(rs.next()) {
        Member member = new Member();

        member.setNo(rs.getInt("member_no"));
        member.setEmail(rs.getString("email"));
        member.setName(rs.getString("name"));
        member.setPassword(rs.getString("password"));
        member.setCreatedDate(rs.getDate("created_date"));

        return member;
      }
      return null;
    } catch (Exception e){
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int update(Member member) {
    try {
      return con.createStatement().executeUpdate(String.format(
          "update members set email='%s', name='%s', password='%s' where member_no = %d",
          member.getEmail(),member.getName(), member.getPassword(),member.getNo()));
    } catch (Exception e){
      throw new DaoException("데이터 입력 오류", e);
    }
  }
}
