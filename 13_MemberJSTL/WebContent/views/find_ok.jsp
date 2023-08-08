<%@page import="servlet.model.vo.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
  
  <c:if test="${dto ne null}">
  
     <h2>회원 검색 결과</h2>
    <ul>
      <li>아이디 : ${dto.id} </li>
      <li>이름 :${dto.name} </li>
      <li>주소 : ${dto.address}</li>
    </ul>
    
  </c:if>
    
  
       
  </body>
</html>
