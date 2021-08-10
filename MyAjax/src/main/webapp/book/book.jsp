<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	response.setHeader("Pragma","No-cache"); //HTTP 1.0 
	response.setDateHeader ("Expires", 0); 
	response.setHeader("Cache-Control","no-cache");
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BOOK</title>
<!-- CDN 참조-------------------------------------- -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- ------------------------------------------------- -->
<style type="text/css">


</style>


<script type="text/javascript">
//jquery 에서 ajax통신을 수행하는 함수 : $.ajax({옵션}) 
	
	$(function(){
		getAllBook();
	})

	function goEditEnd(){
		//수정폼 데이터를 파라미터화 해서 전송
		let params=$('#editF').serialize();
		//alert(params);
		$.ajax({
			type:'post',
			url:'bookUpdate.jsp',
			data:params,
			dataType:'xml',
			cache:false
		}).done(function(res){//success일 때 수행되는 함수
			//alert('성공'+res);
			let str=$(res).find('result').text();
			if(parseInt(str)>0){
				getAllBook();
			}else{
				alert('수정 실패');
			}
		})
		.fail(function(err){//error날때 수행되는 함수
			alert('에러: '+err.status);
		})
		
	}
	
	function goDel(visbn){
		$.ajax({
			type:'get',
			url:'bookDelete.jsp?isbn='+visbn,
			dataType:'json',
			cache:false,
			success:function(res){
				//alert(res);//object Object
				let str=res.result;
				//alert(str);
				if(parseInt(str)>0){
					getAllBook();
				}else{
					alert('삭제 실패');
				}
			},
			error:function(err){
				alert('error: '+err.status);
			}
		})
	}
	
	function goEdit(visbn){
		//alert(visbn);
		$.ajax({
			type:'post',
			url:'bookInfo.jsp',
			data:'isbn='+visbn, //post방식일 때는 data속성에 파라미터 데이터를 포함시켜 보낸다.
			dataType:'xml',
			success:function(res){
				//alert(res);//XMLDocument
				let misbn=$(res).find('isbn').text();
				let mtitle=$(res).find('title').text();
				let mpublish=$(res).find('publish').text();
				let mpublished=$(res).find('published').text();
				let mprice=$(res).find('price').text();
				let mbimage=$(res).find('bimage').text();
				
				$('#isbn').val(misbn);
				$('#title').val(mtitle);
				$('#price').val(mprice);
				$('#publish').val(mpublish);
				$('#published').val(mpublished);
				
				let str="<img src='../images/"+mbimage+"' class='img img-thumbnail'>";
				$('#bimage').html(str);
			},
			error:function(err){
				alert('error: '+err.status);
			}
		})
		
	}//goEdit()-------------------

	function getAllBook(){
		$.ajax({
			type:'GET', //요청방식
			url:'bookAll.jsp',//요청보낼 서버페이지 url
			cache:false, //캐시 사용 안함
			dataType:'html', //응답유형
			success:function(res){//성공적으로 수행될 경우 실행되는 함수
				//alert(res);
				$('#book_data').html(res);
			},
			error:function(err){//에러가 발생할 경우 실행되는 함수
				alert('error: '+err.status);
			}
		})	
	}//----------------------------

</script>
</head>
<!--onload시 출판사 목록 가져오기  -->
<body onload="getPublish()">
   <div class="container">
	<h2 id="msg">서적 정보 페이지</h2>
<form name="findF" id="findF" role="form"
 action="" method="POST">
<div class="form-group">
<label for="sel" class="control-label col-sm-2">출판사</label>
<span id="sel"></span><span id="sel2"></span>
</div>
<p>
<div class='form-group'>
	<label for="books" class="control-label col-sm-2" id="msg1">도서검색</label>
	<div class="col-sm-6">
	<input type="text" name="books" id="books"
	 onkeyup="autoComp(this.value)"
	 class="form-control" >
	 <!-- ---------------------------- -->
	 <div id="lst1" class="listbox"
	  style="display:none">
	 	<div id="lst2" class="blist"
	 	 style="display:none">
	 	</div>
	 </div>
	 <!-- ---------------------------- -->
	</div>
</div>
</form>
<div>
 
 <button type="button"
  onclick="getBook()"
  class="btn btn-primary">검색</button>
 
 <button type="button" onclick="getAllBook()" class="btn btn-success">모두보기</button>
 <button type="button" id="openBtn"
  class="btn btn-info">OPEN API에서 검색</button><br><br>
</div>
<div id="localBook">

<table class="table table-bordered" border="1">
	<tr class="info">
		<td style="width:20%;">서명</td>
		<td style="width:20%;">출판사</td>
		<td style="width:20%;">가격</td>
		<td style="width:20%;">출판일</td>
		<td style="width:20%;">편집</td>
	</tr>
</table>
<!-- ----------------------- -->
<div id="book_data"></div>
<!-- ----------------------- -->
<form id="editF" name="editF">
<table id="book_info" class="table table-hover" border="2">
	<tr>
		<td width="20%">ISBN코드</td>
		<td>
		<input type="text" name="isbn" id="isbn"
		class="form-control" readonly>
		</td>
		<td rowspan="6" width="30%" id="bimage" class="text-center"></td>
	</tr>
	<tr>
		<td>서명</td>
		<td>
		<input type="text" name="title" id="title"
		class="form-control">
		</td>
		
	</tr>
	<tr>
		
		<td>출판사</td>
		<td>
		<input type="text" name="publish" id="publish"
		class="form-control">
		</td>
		
	
	</tr>
	<tr>
	
		<td>가격</td>
		<td>
		<input type="text" name="price" id="price"
		class="form-control">
		</td>
		
	</tr>
	<tr>
	
		<td>출판일</td>
		<td>
		<input type="text" name="published"
		 id="published"  disabled
		class="form-control">
		</td>
		
	</tr>
	<tr>
		<td colspan="2">
		<button type="button"
		onclick="goEditEnd()" class="btn btn-danger">수정처리</button></td>
	</tr>
</table>
</form>
	</div>
</div><!-- #localBook end -->

<!-- ------------------------------- -->
<div id="openApiBook">

</div>
	
</body>
</html>

<!-- https://apis.daum.net/search/book -->
<!-- 53c73f32f6c4150ca5aa184ba6250d8e -->

<!-- https://apis.daum.net/search/book?apikey=53c73f32f6c4150ca5aa184ba6250d8e&q=다음카카오&output=json -->




