package bitcamp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ThreadConnection {

  private String jdbcUrl;
  private String username;
  private String password;

  // 개별스레드용 DB 커넥션 저장소
  private static final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

  public ThreadConnection(String jdbcUrl, String username, String password){
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }

  public Connection get() throws Exception{
    Connection con = connectionThreadLocal.get();
    if(con == null){

      con = DriverManager.getConnection(this.jdbcUrl,this.username,this.password);
      connectionThreadLocal.set(con);
      System.out.printf("%s: DB 커넥션 생성\n",Thread.currentThread().getName());
    } else {
      System.out.printf("%s: 기존에 보관했던 DB 커넥션 사용\n", Thread.currentThread().getName());
    }
    return con;
  }

  public void remove(){
    Connection con = connectionThreadLocal.get();
    if(con != null){
      try{con.close();} catch (Exception e){}
      connectionThreadLocal.remove();
      System.out.printf("%s: DB 커넥션 제거\n",Thread.currentThread().getName());
    }
  }
}
