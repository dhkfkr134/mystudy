package bitcamp.myapp.vo;

public class Member {

  private String email;
  private String name;
  private String password;
  private String createdDate;

  public void setEmail(String email) {
    this.email = email;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public String getCreatedDate() {
    return createdDate;
  }
}
