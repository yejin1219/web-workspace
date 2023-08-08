<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/UpdateServlet" method=post>
<h2>회원 정보 수정</h2>
PASSWORD : <input type="text" name="password" /><br><br>
NAME : <input type="text" name="name" /><br><br>
ADDRESS : <input type="text" name="address" /><br><br>
<input type="submit" value="등록">

${param.password}
${param.name}
${param.address}
</form>
</body>
</html>