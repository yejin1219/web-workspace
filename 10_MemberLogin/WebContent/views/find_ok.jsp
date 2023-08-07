<%@page import="servlet.model.vo.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
  <%
  
  MemberDTO dto = (MemberDTO)session.getAttribute("dto");
  if(dto!=null){
  
  %>
    <h2>회원 검색</h2>
    <ul>
      <li>아이디 : <%=dto.getId()%></li>
      <li>이름 : <%=dto.getName()%></li>
      <li>주소 : <%=dto.getAddress()%></li>
    </ul>
    <%}else{ %>
       <h3>검색 실패..! 다시 입력하세요</h3>
    <%} %>
  </body>
</html>
