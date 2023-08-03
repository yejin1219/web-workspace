<%-- 이 주석 이용하면 나중에 화면에 보이지 않음 
JSP Element
1) 지시어 %@ % : 컨테이너에 알려줄 내용 지정
2) 스클릿틀릿 % % : 자바코드는 이 안에 지정
3) 출력문 %= % : 출력하려는 내용 지정
 --%>
 
 <!--MemberVO파일 먼저 임포트 하기 -->
<%@ page import="servlet.model.MemberVO" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%-- % % ::Scriptlet Element --%>
 <%
   MemberVO vo = (MemberVO)application.getAttribute("vo"); 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%-- %= % ::Eapression Element --%>
   <h2>회원님의 정보를 출력합니다</h2>
    <P>이름은 : <%= vo.getName()%></P>
    <P>나이는 : <%= vo.getAge()%></P>
    <P>이름은 : <%= vo.getAddr()%></P>
</body>
</html>