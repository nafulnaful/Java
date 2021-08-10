<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class = "row">
   <div class = "col-md-12">
      <h1 class = "badge badge-warning"> ${pspec2}</h1>
   </div>
</div>
<!-- eq : == 와 동일 (equals)
     ne : != 와 동일 (not equals)
 -->
<div class = "row">
	<c:if test="${newList eq null or empty newList }">
		<div class="col-md-3">
			<h4>상품 준비 중</h4>
		</div>
	</c:if>
   <c:if test="${newList ne null and not empty newList}">
	   <c:forEach var = "item" items = "${newList}" varStatus="state" begin="0" end="3">
	   <!-- varStatus 속성을 이용하면 반복문의 상태 정보를 활용할 수 있다. 
	   		state.index : 인덱스 번호 반환
	   		state.count : 반복문 횟수를 반환 
	   -->
	      <div class = "col-md-3">
	         <a href="prodDetail.me?pnum=${item.pnum}">
	         <c:if test="${item.pimage1 ne null}">
	         <img src = "product_images/${item.pimage1}" class = "img-fluid"
	         style = "height:220px">
	         </c:if> 
	         <c:if test="${item.pimage1 eq null}">
	         <img src = "product_images/noimage.png" class = "img-fluid"
	         style = "height:220px">
	         </c:if>
	         </a>
	         <br><br>
	         <h4> ${item.pname} </h4>
	         <del> 
	         <fmt:formatNumber value="${item.price}" pattern="###,###"/> 
	         </del> 원 <br>
	         <span> 
	          <fmt:formatNumber value="${item.saleprice}" pattern="###,###"/>
	         </span> 원 <br>
	         <span class = "badge badge-danger"> ${item.percent} </span> <br>
	         <span class = "badge badge-success">${item.point}</span> POINT <br>
	      </div> <!--  col-md-3 end -->
	      <c:if test="${state.count mod 4 ==0 }">
	      	</div> <!--  row end 
	      	행을 닫고 새로운 행을 시작시킨다.
	      	하나의 행에 상품 4개 컬럼을 진열하기 위해
	      	-->
	      	<div class="row m-3">
	      </c:if>
	   </c:forEach>
   </c:if>
   
</div>