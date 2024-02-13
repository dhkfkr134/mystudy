package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.ThreadConnection;
import java.io.PipedReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

  ThreadConnection threadConnection;
  public MemberDaoImpl(ThreadConnection threadConnection) {
  this.threadConnection = threadConnection;
  }

  @Override
  public void add(Member member) {
    Connection con = null;
    try {
      con =threadConnection.get();
      try (PreparedStatement pstmt = con.prepareStatement(
        "insert into members(email, name, password) values(?,?,sha2(?,256))")) {
      pstmt.setString(1,member.getEmail());
      pstmt.setString(2,member.getName());
      pstmt.setString(3,member.getPassword());
    }} catch (Exception e){
      throw new DaoException("데이터 처리 오류",e);
    }
  }

  @Override
  public int delete(int no) {
    Connection con = null;
    try {
      con =threadConnection.get();    try (PreparedStatement pstmt = con.prepareStatement("delete from Members where member_no=?")) {
      pstmt.setInt(1,no);
      return pstmt.executeUpdate();
    }} catch (Exception e){
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public List<Member> findAll() {
      Connection con = null;
    try {
      con =threadConnection.get();  try (PreparedStatement pstmt = con.prepareStatement("select * from members");
        ResultSet rs = pstmt.executeQuery()) {

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
    } }catch (Exception e){
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public Member findBy(int no) {
      Connection con = null;
    try {
      con =threadConnection.get();    try (PreparedStatement pstmt = con.prepareStatement("select * from members where member_no=")) {
      pstmt.setInt(1,no);
      try(ResultSet rs = pstmt.executeQuery()){


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
    }}} catch (Exception e){
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int update(Member member) {
      Connection con = null;
    try {
      con =threadConnection.get();
      try (PreparedStatement pstmt = con.prepareStatement(
        "update members set email=?, name=?, password=? where member_no = ?")){
      pstmt.setString(1,member.getEmail());
      pstmt.setString(2,member.getName());
      pstmt.setString(3,member.getPassword());
      pstmt.setInt(4,member.getNo());
      return pstmt.executeUpdate();
    }}catch (Exception e){
      throw new DaoException("데이터 입력 오류", e);
    }
  }
}
