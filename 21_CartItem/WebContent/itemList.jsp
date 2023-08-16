<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <style></style>
  <body>
    <h1>Fruit Total List</h1>

    <a href=""><img src="../WebContent/img/berry.jpg" /></a>

    <div>
      <p>상품명 : ${item.itemName}</p>
      <p>가격 : ${item.price}</p>
    </div>

    <a href=""><img src="../WebContent/img/grape.jpg" /></a>
    <div>
      <p>상품명 : 포도</p>
      <p>가격 : 5000원</p>
    </div>

    <a href=""><img src="../WebContent/img/gual.jpg" /></a>
    <div>
      <p>상품명 : 귤</p>
      <p>가격 : 4000원</p>
    </div>

    <a href=""><img src="../WebContent/img/kiwi.jpg" /></a>
    <div>
      <p>상품명 : 키위</p>
      <p>가격 : 8000원</p>
    </div>

    <a href=""><img src="../WebContent/img/lemon.jpg" /></a>
    <div>
      <p>상품명 : 레몬</p>
      <p>가격 : 3000원</p>
    </div>
  </body>
</html>
