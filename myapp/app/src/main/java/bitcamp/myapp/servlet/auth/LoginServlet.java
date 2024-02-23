package bitcamp.myapp.servlet.auth;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {

  MemberDao memberDao;

  @Override
  public void init() {
    this.memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>\n"
        + "<html lang=\"en\">\n"
        + "<head>\n"
        + "  <meta charset=\"UTF-8\">\n"
        + "  <title>비트캠프 데브옵스 5기</title>\n"
        + "</head>\n"
        + "<body>\n");
    request.getRequestDispatcher("/header").include(request,response);
    out.println("<h2>로그인</h2>\n"
        + "\n"
        + "<form action=\"/auth/login\" method=\"post\">\n"
        + "  <div>\n"
        + "    이메일: <input name=\"email\" type=\"text\">\n"
        + "  </div>\n"
        + "  <div>\n"
        + "    암호: <input name=\"password\" type=\"password\">\n"
        + "  </div>\n"
        + "  <button>로그인</button>\n"
        + "</form>\n"
        + "\n");
    request.getRequestDispatcher("/footer").include(request,response);
    out.println("</body>\n</html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    request.getRequestDispatcher("/header").include(request,response);
    out.println("<h1>과제 관리 시스템</h1>");
    out.println("<h2>로그인</h2>");

    try {
      Member member = memberDao.findByEmailAndPassword(email, password);
      if (member != null) {
        request.getSession().setAttribute("loginUser", member);
        out.printf("<p>%s 님 환영합니다.</p>\n", member.getName());
        response.setHeader("Refresh", "1;url=/");
      } else {
        out.println("<p>이메일 또는 암호가 맞지 않습니다.</p>");
        response.setHeader("Refresh", "1;url=/auth/login");
      }
    } catch (Exception e) {
      out.println("<p>로그인 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    request.getRequestDispatcher("/footer").include(request,response);

    out.println("</body>");
    out.println("</html>");
  }
}
