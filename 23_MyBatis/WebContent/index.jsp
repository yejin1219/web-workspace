<%@page import="model.service.StudentService"%>
<%@page import="model.vo.StudentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 
첫 페이지 리스트 뿌려주기 자바 문법쓰려면 <%%>
service 호출해서 list에 담아 request.setAttribute로 바인딩!
 -->    
    
    <% List<StudentVO> list = new StudentService().showStudent("");
      request.setAttribute("list", list);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<style>
   #search{
     background-color: crimson;
     color: aliceblue;
     border-radius: 5px;
     border-color: crimson;

   }

   #word{
    margin-left: 15px;
    width: 450px;
   }

   form{
    margin-top: 15px;
   }

   thead tr {
    text-align: center;
   }
   tbody tr{
    text-align: center;
    font-size:small;
   }



</style>




</head>
<body>



  <form  id="find">


    <div class="container">
        <div class="row">
            <div class="col">
                <input type="text" name="word" id="word" class="form-control">
            </div>
            <div class="col">
                <input type="button" value="검색"  id="search" class="btn btn-danger">
            </div>
        </div>

    </div>
    </div>
    
    
    <table class="table table-striped  table table-hover" >

        <thead>
            <tr>
                <th>학번</th>
                <th>이름</th>
                <th>주소</th>
                <th>학과</th>
                <th>계열</th>
            </tr>

        </thead>
         <tbody>
           <c:forEach items="${list}" var="student">
            <tr>
              <td>${student.studentNo}</td>
              <td>${student.studentName}</td>
              <td>${student.studentAddress}</td>
              <td>${student.department.departmentName}</td>
              <td>${student.department.category}</td>
             </tr>

           </c:forEach>
           
         </tbody>

    </table>

  </form>
  <script>
        $("#search").click(function(){
            const word = $("#word").val();

           $.ajax({
              type: "get",
              url: "find.do",
              data:'word=' +word,
              dataType:'json',

              success: function(data){
            	  const result = eval(data.result);
            	  let resultHtml = "";
            	  for(let item of result){ 
            		  resultHtml += "<tr>" +
            		                 "<td>" + item.studentNo +"</td>"+
            		                 "<td>" + item.studentName + "</td>"+
            		                 "<td>" + item.studentAddress + "</td>"+
            		                 "<td>" + item.department.departmentName+"</td>"+
            		                 "<td>" + item.department.category + "</td>"+ 
            		                 "</tr>";
            	  }
                    $('tbody').html(resultHtml);
              }


           });


        });

    </script>  

 
</body>
</html>