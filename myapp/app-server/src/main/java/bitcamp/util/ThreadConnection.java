package bitcamp.util;

import java.sql.Connection;

public class ThreadConnection {

  String jdbcUrl;
  String username;
  String password;

  // 개별스레드용 DB 커넥션 저장소
  ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

  public ThreadConnection(String jdbcUrl, String username, String password){
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }

  public Connection get(){
    Connection con = connectionThreadLocal.get();
  }
}
