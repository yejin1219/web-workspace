<%@page import="servlet.model.vo.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 MemberDTO dto = (MemberDTO)session.getAttribute("dto");
if(dto!=null){
	session.invalidate();
	<a href="/index.jsp"> </a>
} %>
</body>
</html>