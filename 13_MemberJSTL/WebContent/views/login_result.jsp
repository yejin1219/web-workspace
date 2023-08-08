<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ page import = "servlet.model.vo.MemberDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
   
     <c:if test="${dto ne null}">
       <h2>로그인 정보</h2>
        <ul>
           <li>아이디 : ${dto.id}</li>
           <li>이름 : ${dto.name}</li>
           <li>주소 : ${dto.address}</li>
         </ul>
         <a href="/index.jsp">첫 페이지로 이동 </a>
    
     </c:if>

  </body>
</html>
