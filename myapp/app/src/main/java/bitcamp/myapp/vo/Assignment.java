package bitcamp.myapp.vo;

import java.sql.Date;

public class Assignment {

  private String title;
  private String content;
  private Date deadline;

  public void setTitle(String title) {
    this.title = title;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public Date getDeadline() {
    return deadline;
  }
}
