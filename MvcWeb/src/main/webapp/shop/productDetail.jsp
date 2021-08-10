<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
    
<jsp:include page="/top.jsp"  />

<script>
	function goCart(){
		frm.action="user/cartAdd.me";
		//frm.method="get";
		frm.submit();
	}
	
	function goOrder(){
		//frm: form id => jQuery로 접근할 경우
		$('#frm').attr('action','user/order.me')
				//.attr('method','get')
				.submit();
	}
	funcyion goWish(){
		frm.action="user/wish.me";
		frm.submit();
	}

	function openWin(fname){
		//alert(fname);
		let url="product_images/"+fname;
		
		let obj=new Image();
		obj.src=url;
		
		let w=obj.width+50;
		let h=obj.height+50;
		
		window.open(url,'magnify',"width="+w+", height="+h+", left=100, top=100");
		
	}
</script>

	<div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
        	<table class="table">
	<thead>
	<tr>
		<th colspan="2"><h3 class="text-center">상품 정보</h3></th>
	</tr>
	</thead>
	<tbody>
		<tr>
			<td align="center" width="50%">
		<a href="javascript:openWin('${item.pimage1}')">
		<img src="product_images/${item.pimage1}"
				class="img-fluid" style="width: 70%;">
		</a>	
			</td>
			<td align="left"  width="50%" style="padding-left:40px">
	<h4><span class="badge badge-danger">
	${item.pspec}
	</span></h4>
	
			
			상품번호: ${item.pnum}  <br>
			상품이름: ${item.pname} <br>
			정가:<del>
				<fmt:formatNumber value="${item.price}"
				 pattern="###,###" />
				</del>원<br>
			판매가:<span style="color:red;font-weight:bold">
				<fmt:formatNumber value="${item.saleprice}"
				 pattern="###,###" />
			</span>원<br>
	할인율:<span style="color:red">${item.percent}%</span><br>
			POINT:<b style="color:green">[${item.point}]</b>POINT<br>
			<!-- form시작---------- -->
         <form name="frm" id="frm" method="POST">
         <!-- 상품번호를 hidden으로 넘기자------ -->
         <input type="hidden" name="pnum" value="${item.pnum}">
         <!-- -------------------------------- -->            
         <label for="oqty">상품갯수</label>
         <input type="number"
         name="oqty" id="oqty" min="1" max="50" size="2" value="1">
         
         </form>            
         <!-- form end------------ --> 
			<button type="button" onclick="goCart()"
			 class="btn btn-primary">장바구니</button>
			<button type="button" onclick="goOrder()" 
			class="btn btn-warning">주문하기</button>
			<button type="button" onclick="goWish()" 
			class="btn btn-danger">위시리시트</button>
			</td>
		</tr>
		<tr style="border:0">
			<td align="center">
				<img src="product_images/${item.pimage2}"
				 class="img-fluid img-thumbnail"  style="width: 70%;">
			</td>
			<td align="center">
				<img src="product_images/${item.pimage3}"
				class="img-fluid img-thumbnail"  style="width: 70%;">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<p>상품설명</p>
				<pre>${item.pcontents}</pre>
			</td>
		</tr>
	</tbody>
</table>
        </div>
      </div>
    </div>
  </div>
    
<jsp:include page="/foot.jsp"  />    