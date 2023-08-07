<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ page import = "servlet.model.vo.MemberDTO" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <% MemberDTO dto = (MemberDTO)session.getAttribute("dto");
      if(dto!=null){   
    %>

    <h2>로그인 정보</h2>
    <ul>
      <li>아이디 : <%=dto.getId()%></li>
      <li>이름 : <%=dto.getName()%></li>
      <li>주소 : <%=dto.getAddress()%></li>
    </ul>
    <a href="/index.jsp">첫 페이지로 이동 </a>
    <%}else { %>
    <h3>로그인 실패..! 로그인을 다시 해주세요. </h3>
    <%} %>
  </body>
</html>
