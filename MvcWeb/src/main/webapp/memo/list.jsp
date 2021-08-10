<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- core 태그 라이브러리에는 핵심 제어문(if, forEach, choose...)을 태그로 제공한다. -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::한줄 메모장::</title>
	<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div class="row m-5">
		<div class="col-md-12 text-center">
			<table class="table table-striped table-condensed">
				<thead>
					<tr class="table-primary">
						<th colspan="4">
							<h1>:::한줄 메모장:::</h1>
						</th>
					</tr>
					<tr>
						<th>글번호</th>
						<th>메모내용</th>
						<th>작성자</th>
						<th>수정|삭제</th>
					</tr>
				</thead>
				
				<tbody>
				<!-- -------------------------------- -->
				<c:if test="${memoArr == null || empty memoArr }">
									<%-- empty memoArr 은 memoArr.size()==0 과 동일한 것 --%>
					<tr>
						<td colspan="4">
						<b>데이터가 없습니다.</b>
						</td>
					</tr>	
				</c:if>
				<c:if test="${memoArr !=null && not empty memoArr }">
					<c:forEach var="memo" items="${memoArr}">
					<!--var : 변수  memo ==> MemoVO객체
						begin: 시작값, end: 끝값, step: 증가치
						items : 자료구조(collection, arraylist, map....)
					 -->
					<tr>
						<td><%-- ${memo.getIdx()} / --%> ${memo.idx }</td>
						<td class="text-left pl-3">${memo.msg} 
						<span class="badge badge-success float-right">${memo.wdate}</span> </td>
						<td>${memo.name}</td>
						<td>
						<a href="memoEdit.me?idx=${memo.idx}">수정</a>|
						<a href="memoDel.me?idx=${memo.idx}">삭제</a>
						</td>
					</tr>
					</c:forEach>
				</c:if>	
				<!-- -------------------------------- -->					
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>