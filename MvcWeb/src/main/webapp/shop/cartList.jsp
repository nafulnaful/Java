<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/top.jsp"  />

   <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
           <h1 class="text-center">${loginUser.name}[${loginUser.userid}]님의 장바구니</h1>
           <!-- ${cartArr} -->
        </div>
      </div>
      
      <div class="row">
        <div class="col-md-12">
        <!-- 주문 폼 시작-------------------------- -->
       <form name="orderF" id="orderF" action="order.do">
          
          <table class="table table-striped">
             <thead>
                <tr class="info text-center">
                   <th>상품번호</th>
                   <th>상품명</th>
                   <th>수량</th>
                   <th>단가</th>
                   <th>금액</th>
                   <th>삭제</th>
                </tr>
             </thead>
             <tbody>
                <!-- -------------------- -->
                <c:foreach var="cvo" items="${cartArr}">
                
                <tr>
                   <td>
                      <label>
                      <input type="checkbox" name="pnum" id="pnum"
                       value="${cvo.pnum}">
                      ${cvo.pnum}
                      </label>
                      
                   </td>
                   <td>
                   상품명<br>
                   <a><img src="../product_images/a"
                    class="img-thumbnail" style="width:140px"></a>
                   </td>
                   <td>
                   <input type="number" name="oqty" id="oqty"
                    value="1"  min="1" max="50" size="3">
                    <button type="button" class="btn btn-success"
                     onclick="cartEdit('1' , '1')">
                     수정</button>
                   </td>
                   <td>
                   <fmt:formatNumber value="1"
                    pattern="###,###"/>
                   원<br>
                   <span class="badge badge-danger">a</span>POINT
                   </td>
                   <td>
                   <fmt:formatNumber value="1"
                    pattern="###,###"/>
                   원<br>
                   <span class="badge badge-danger">a</span>POINT
                   </td>
                   <td>
                   <a  href="#" onclick="cartDel('a')">삭제</a>
                   </td>
                </tr>             
                </c:foreach>
                <!-- -------------------- -->
             </tbody>
             <tr>
                <td colspan="3">
                   <h5>장바구니 총   액: <span class="text-danger">
                   <fmt:formatNumber value="1"
                    pattern="###,###"/>
                   원</span>
                   </h5>
                   
                   <h5>장바구니 총포인트: <span class="text-success">
                   a
                   POINT</span>
                   </h5>
                </td>
                <td colspan="3">
                   <button class="btn btn-outline-info">주문하기</button>
                   <button type="button"
                    class="btn btn-outline-warning"
                     onclick="location.href='../index.me'">계속쇼핑</button>
                </td>
             </tr>
          </table>
       </form>
       <!-- ----------------------------------- -->
        </div>
      </div>
      
      
    </div>
  </div>
    
<jsp:include page="/foot.jsp"  />    