<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>


<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <h1>장바구니</h1>
    <a href="itemList.do">쇼핑 계속하기</a>

    <table border="1">
      <thead>
        <tr>
          <th>번호</th>
          <th>상품이미지</th>
          <th>상품명</th>
          <th>상품가격</th>
          <th>수량</th>
          <th><button onclick="deleteStorage()">삭제</button></th>
        </tr>
      </thead>

      <tbody></tbody>
      <tfoot>
        <tr>
          <td colspan="6">총 결제금액 : <span id="resultTotal"></span></td>
        </tr>
      </tfoot>
    </table>
    <script>
        let amount = 1;   
        let totalPrice = 0;
        refreshPage();
        
        $('.up').on('click', function(){
        	//console.log($(this).next().html()); -> 숫자에 접근 (문자열)
        	$(this).next().html(eval($(this).next().html())+1); //eval함수 써서 숫자로 인식 한 다음 넣어줌 
        	amount = $(this).next().html();
        	//console.log($(this).parent().prev().html());  this의 부모 태그 -> 이전 태그-> 가격에 접근 
        	totalPrice += eval($(this).parent().prev().html());
        	$('#resultTotal').html(totalPrice);
        	
        });
        
        $('.down').on('click', function(){
        
        	if(amount>1){
        		$(this).prev().html(eval($(this).prev().html())-1);
        		amount = $(this).prev().html();
            	totalPrice -= eval($(this).parent().prev().html());
            	$('#resultTotal').html(totalPrice);
        	}
        	
  	
        });
      function refreshPage() {
        let html = '';
        let count = 0;
        for (let key in localStorage) {
          if (key === "length") break;
          console.log(key); //cart-? 만 출력됨
          const data = localStorage.getItem(key).split(",");
          console.log(data); //['키위', ' 8000', 'img/kiwi.jpg'] 키 값이 배열로 담아짐
          html +=
            '<tr>' +
            '<td>' + ++count + '</td>' +
            '<td><img src=' +  data[2] + ' width=150 height=150></td>' +
            '<td>' +data[0] + '</td>' +
            '<td>' + data[1] + '</td>' +
            '<td>'+'<img src =img/up.jpg width=10 height=10 style=cursor:pointer; class=up>' +
            '<div>' + amount + '</div>' +
            '<img src =img/down.jpg width=10 height=10 style=cursor:pointer; class=down>'+ '</td>' +
            '<td>' + '<input value= ' +key+ ' type= checkbox class=deleteItem>'  +'</td>' +
            
            '</tr>';
            
            totalPrice += eval(data[1]); //data[1]은 문자열 -> eval함수 써서 숫자로 인식 
        }
        $('tbody').append(html);
        $('#resultTotal').html(totalPrice);
      }
      
      function deleteStorage(){
    	  const check = document.querySelectorAll(".deleteItem");
    	  console.log(check);
    	  for(let i=0; i<check.length; i++){
    		  if(check[i].checked === true){
    			  localStorage.removeItem(check[i].value);
    			  location.reload(); // 새로고침
    		  }
    	  }
    	  
      }
    </script>
  </body>
</html>
