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
   
   <c:choose>     
     <c:when test="${! empty dto}">
       <h2>로그인 정보</h2>
        <ul>
           <li>아이디 : ${dto.id}</li>
           <li>이름 : ${dto.name}</li>
           <li>주소 : ${dto.address}</li>
         </ul>
         <a href="/index.jsp">첫 페이지로 이동 </a>
    </c:when>
     <c:otherwise>
       <h3>로그인 실패! 로그인을 해주세요</h3>
       <a href="login.html">login.html </a>
     </c:otherwise>
    </c:choose>

  </body>
</html>
