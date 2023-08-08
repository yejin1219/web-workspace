<%@page import="servlet.model.vo.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
</head>
<body>

     <h2>전체 회원 보기</h2>
     <table class="table">
        <tr>
            <th></th>
            <th>아이디</th>
            <th>이름</th>
            <th>주소</th>
        </tr>


        
  <%
     ArrayList<MemberDTO>list = (ArrayList)request.getAttribute("list");
     if(list!=null){
    	 for(int i=0; i<list.size();i++){
  %>
     <tr>
        <td><%=i+1 %></td>
       <td><%=list.get(i).getId() %></td>
       <td><%=list.get(i).getName() %></td>
       <td><%=list.get(i).getAddress() %></td>
     </tr>
    <%}}%>
     </table>






</body>
</html>