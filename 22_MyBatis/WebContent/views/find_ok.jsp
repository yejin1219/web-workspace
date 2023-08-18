<%@page import="member.model.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
  
  <c:if test="${vo ne null}">
  
     <h2>회원 검색 결과</h2>
    <ul>
      <li>아이디 : ${vo.id} </li>
      <li>이름 :${vo.name} </li>
      <li>주소 : ${vo.address}</li>
    </ul>
    
  </c:if>
    
  
       
  </body>
</html>
