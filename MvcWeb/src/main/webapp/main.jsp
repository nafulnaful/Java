<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/top.jsp"  />

  <div class="py-5">
    <div class="container"> 
      <div class="row">
        <div class="col-md-12">
        	<h1 class="text-center">Main Page</h1>
        <%-- 	<h2>${msg} : ${count }</h2> --%>
        </div>
      </div>
      <!-- HIT상품 진열 --------------------------------->
      <div class="row m-4">
      <div class="col-md-12">
     	<jsp:include page="/shop/mallHit.jsp"/>
     </div>		
      </div>
      
      <!-- NEW상품 진열------------------------------ -->
      <div class="row m-4">
      <div class="col-md-12">
     	<jsp:include page="/shop/mallNew.jsp"/>
     </div>		
      </div>
      
    </div>
  </div>
    
<jsp:include page="/foot.jsp"  />     