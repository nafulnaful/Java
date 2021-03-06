<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    
    <script>
    	function check(){
    		if(! frm.name.value){
    			alert('작성자를 입력하세요');
    			frm.name.focus();
    			return false;
    		}
    		if(!frm.msg.value){
    			alert('메시지를 입력하세요');
    			frm.msg.focus();
    			return false;
    		}
    		//메시지 100자 이내 길이 체크
    		if(frm.msg.value.length>100){
    			alert('메모내용은 100자 이내여야 해요');
    			frm.msg.select();
    			return false;
    		}
    		return true;
    	}
    </script>  
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12 p-3">
			
				<h1 class="text-center text-primary m-3">:::한줄 메모장:::</h1>
			
			</div>
		</div>
		<!--.row------------------  -->
		<div class="row">
			<div class="col-md-12 p-3">
		
			<form name="frm" action="memoAdd.me" method="get" onsubmit="return check()">
				<table class="table">
					<tr>
						<td><b>작성자</b></td>
						<td>
						<input type="text" name="name"
						 placeholder="Name" class="form-control" required>
						</td>
					</tr>
					
					<tr>
						<td><b>메모내용</b></td>
						<td>
						<input type="text" name="msg" maxlength="100"
						 placeholder="Message" class="form-control">
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<button class="btn btn-info">글 쓰 기</button>
							<button type="reset" class="btn btn-warning">다시 쓰기</button>
						</td>
					</tr>
					
				</table>
			</form>
			</div>
		</div>
		
	
	</div>
	<!-- .container -->
	

</body>
</html>