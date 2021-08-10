<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ContextPath를 core태그 이용해서 변수에 할당하자 -->
<c:set var="myctx" value="${pageContext.request.contextPath}"/>
<%-- String myctx=request.getContextPath()와 동일 --%>
    
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/fo.nt-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"  crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <pingendo onclick="window.open('https://pingendo.com/', '_blank')" style="cursor:pointer;position: fixed;bottom: 20px;right:20px;padding:4px;background-color: #00b0eb;border-radius: 8px; width:220px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:14px;color:white">Made with Pingendo Free&nbsp;&nbsp;<img src="https://pingendo.com/site-assets/Pingendo_logo_big.png" class="d-block" alt="Pingendo logo" height="16"></pingendo>
	
</head>

<body>
  <nav class="navbar navbar-expand-md navbar-dark bg-primary">
    <div class="container"> <a class="navbar-brand" href="#">
        <i class="fa d-inline fa-lg fa-stop-circle"></i>
        <b>TIS_SHOP</b>
      </a> <button class="navbar-toggler navbar-toggler-right border-0" type="button" data-toggle="collapse" data-target="#navbar16">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbar16">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item"> <a class="nav-link" href="${myctx}/index.me">Home</a> </li>
          
          <c:if test="${loginUser eq null }">   
          <li class="nav-item"> <a class="nav-link" href="#loginModal"  data-toggle="modal">Login</a> </li>
          </c:if>
          <c:if test="${loginUser ne null }">
          	 <li class="nav-item bg-danger text-white"> 
          	 	<a class="nav-link" href="#">${loginUser.userid}님 로그인 중...</a> 
          	 </li>
          	  <li class="nav-item"> <a class="nav-link" href="${myctx}/logout.me">Logout</a> </li>
          </c:if>
          
          <li class="nav-item"> <a class="nav-link" href="${myctx}/admin/prodForm.me">상품등록</a> </li>
          <li class="nav-item"> <a class="nav-link" href="${myctx}/admin/prodList.me">상품목록</a> </li>
          
          <li class="nav-item"> <a class="nav-link" href="${myctx}/user/cartList.me">Cart</a> </li>
          
          <li class="nav-item"> <a class="nav-link" href="#">FAQ</a> </li>
        </ul> <a class="btn navbar-btn ml-md-2 btn-light text-dark">Contact us</a>
      </div>
    </div>
  </nav>
  <!-- loginModal.jsp의 소스를 include 한다--------------------------------- -->
  <%@ include file="/login/loginModal.jsp" %>
  <!-- ------------------------------------------------------------------ -->
  
  
  
  
  