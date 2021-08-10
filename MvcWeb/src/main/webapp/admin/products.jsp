<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<jsp:include page="/top.jsp"  />

	<div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
        	<h1 class="text-center m-4">::Product List [Admin Page]:::</h1>
        	
        <%-- 	${prodList} --%>
        	
        	<table class="table table-striped" id="products">
        		<thead>
        			<tr>
	        			<th>상품번호</th>
	        			<th>카테고리</th>
	        			<th>상품명</th>
	        			<th>이미지</th>
	        			<th>가격</th>
	        			<th>수정|삭제</th>
        			</tr>
        		</thead>
        		<tbody>
        		<!-- ------------------------ -->
        		
        		<c:forEach var="item" items="${prodList}">
        			<tr>	
        				<td>${item.pnum}</td>
        				<td>${item.allCategory} 
        				</td>
        				<td>${item.pname}</td>
        				<td width="15%">
        				<c:if test="${item.pimage1 != null}">
	        				<img src="../product_images/${item.pimage1}" class="img-fluid" 
	        				style="width:90%;margin:auto">
        				</c:if>
        				<c:if test="${item.pimage1 == null}">
        					<img src="../product_images/noimage.png" class="img-fluid" 
	        				style="width:90%;margin:auto">
        				</c:if>
        				
        				</td>
        				<td>
        				<del>정  가: 
        				<fmt:formatNumber value="${item.price}" pattern="###,###"/>
        				원</del> 
        				<br>
        				<b class="text-primary">판매가 :
        				<fmt:formatNumber value="${item.saleprice}" pattern="###,###"/>
        				원</b><br>
        				<span class="badge badge-danger">${item.percent}%할인</span>
        				</td>
        				<td>
        				<a href="javascript:edit('${item.pnum}')">수정</a>|
        				<a href="#" onclick="remove('${item.pnum}')">삭제</a>
        				</td>
        			</tr>
        		</c:forEach>
        			
				<!-- ------------------------ -->        			
        		</tbody>
        		
        	</table>
        </div>
      </div>
    </div>
  </div>
  <!-- 삭제 또는 수정 form ---------------------- -->
	<form name="pf" method="post">
		<input type="hidden" name="pnum" id="pnum">
	</form>  
  <!-- -------------------------------------- -->
  
  <script>
  	function edit(num){
  		//alert(num);
  		$('#pnum').val(num);
  		pf.action="prodEditForm.me";
  		pf.submit();
  	}
  	function remove(num){
  		var yn=confirm(num+"번 상품정보를 삭제할까요?");
  		if(yn){
  			$('#pnum').val(num);
  			pf.action="prodDel.me";
  			pf.submit();
  		}
  	}
  </script>
    
<jsp:include page="/foot.jsp"  />    







