<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/front.do" method=post>

<h2>회원 정보 수정</h2>
 <input type="hidden" name="command" value="update">
ID : <input type = "text" name="id" value="${vo.id}" readonly><br><br>
PASSWORD : <input type="text" name="password" value="${vo.password}" /><br><br>
NAME : <input type="text" name="name" value="${vo.name}"  /><br><br>
ADDRESS : <input type="text" name="address" value="${vo.address}"  /><br><br>
<input type="submit" value="등록">


</form>
</body>
</html>