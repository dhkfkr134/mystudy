# JSP-2

# JSP 예제

## JSP 빌트인 객체

jsp파일이 java파일로 변환되면 자동으로 생성되는 객체들이 있다.

![Untitled](JSP-2%20ee1f165aa3ca43b1ae6b0e7ad54f29fb/Untitled.png)

위 사진은 jsp를 jsp엔진이 java파일로 변환한 코드이다. 이 클래스를 보면 빌트인 객체

- request
- response
- pageContext
    - JSP단위로 데이터를 저장하는 객체
- session
    - 하나의 클라이언트가 공유하는 데이터
- apllication
    - ServletContext로 웹앱시작시부터 종료까지 모두 공유하는 데이터
- config
    - ServletConfig
- out
    - JspWriter
- page
    - 서블릿 객체 자체 = this
- exception 들이 존재함을 알 수 있다.
    - <%@ page isErrorPage=”true”%>일 경우 존재
    
    ![Untitled](JSP-2%20ee1f165aa3ca43b1ae6b0e7ad54f29fb/Untitled%201.png)
    

⚠️ pageContext의 생명주기가 가장 짧지만 ServletContext부터 모든 데이터를 얻을 수 있다.

pageContext.getXXX()로 모든 빌트인 객체를 얻을 수 있다.

## 액션 태그

### jsp:useBean

`<jsp:useBean id="b1" class="com.eomcs.web.vo.Board" scope="page"/>`

위 태그는 아래 자바코드로 변환된다.

```java
com.eomcs.web.vo.Board b1 = (com.eomcs.web.vo.Board) pageContext.getAttribute("b1");
if (b1 == null) {
  b1 = new com.eomcs.web.vo.Board();
  pageContext.setAttribute("b1", b1);
}
```

<jsp:useBean scope=”보관소명 id=”객체명” class=”클래스명”\>

- scope
    
    pageContext만 page라고 명칭되어있다. 나머지 빌트인 객체는 동일
    
- id
    
    객체를 구분할 이름
    
- class or type
    - class
        - 패키지이름을 포함하는 클래스명(FQName)을 지정해야한다.
        - 없는 객체에 접근하면 새로 생성한다.
            - 생성할 때 생성자를 사용하므로, 인터페이스나 추상클래스를 지정하면 안된다.
    - type
        - 타입에 지정된 타입으로 사용해야 한다.
            - 제네릭 사용가능하다.
        - 없는 객체에 접근하면 에러던진다.

### jsp:include

<%@include=””>와 다르다.

jsp:include는 getRequestDispatcher()를 호출하는 코드를 삽입한다.

## ErrorPage속성과 isErrorPage 속성

- <%@ ErrorPage=”url”%>
    
    현재의 페이지에서 에러가 발생하면 url로 넘긴다.
    
- <%@ isErrorPage=”true%>
    
    본 페이지는 에러를 처리하는 페이지이다.
    
    exception객체를 넘겨 받는다.