package bitcamp.myapp.vo;

public class Board {

  private String title;
  private String content;
  private String writer;
  private String createdDate;


  public void setTitle(String title) {
    this.title = title;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public String getWriter() {
    return writer;
  }

  public String getCreatedDate() {
    return createdDate;
  }
}
