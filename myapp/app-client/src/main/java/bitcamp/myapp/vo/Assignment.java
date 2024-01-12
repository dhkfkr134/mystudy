package bitcamp.myapp.vo;

import java.io.Serializable;
import java.sql.Date;

public class Assignment implements Serializable{

  public static final long serialVersionUID = 200L;

  private int no;
  private String title;
  private String content;
  private Date deadline;

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getDeadline() {
    return deadline;
  }

  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }
}
