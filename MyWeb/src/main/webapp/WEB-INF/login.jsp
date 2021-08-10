<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html lang="ko">
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<link rel="stylesheet" href="css/default.css">
		<link rel="stylesheet" href="css/style.css">
	</head>
	<style>
	/**로그인 화면 위치 설정*/
	.login {width: 410px; position: absolute; left: 50%; top: 50%; transform:translate(-50%, -50%); text-align: center;}
	/**로그인 h2 설정*/
	.login h1 { padding:0 0 20px; font-size: 32px; color: #111; border-bottom: 2px solid #111; text-align: center; line-height:1;}
	/**로그인 li 설정*/
	.login > ul { padding:40px 0 33px;}
	.login > ul li {padding:0 0 12px; text-align: left; list-style: none;}
	.login > ul li input { width: 100%; height:46px; box-sizing: border-box; text-indent: 16px;}
	.login > ul li input::-webkit-input-placeholder { font-size:16px; color:#9fa19f;}
	.login > li input[type="checkbox"] {position:absolute; left: -3000%;}
	.login > li input[type="checkbox"] + label {height: 36px; line-height: 36px; }
	.login > li input[type="checkbox"] + label:before { content: ""; display:inline-block; margin:0 10px 0 0; width: 18px; height: 18px; border:1px solid #666; background: #fff; vertical-align: -5px;}
	.login > li input[type="checkbox"]:checked + label:before { background: url(images/icon_check_on.png) no-repeat center #333; border-color:#333;}
	.login button {width: 100%; height: 56px; background:#ed1c24; font-size: 18px; color:#fff;}
	.login div ul {display: flex; justify-content: center; list-style: none;}
	.login div ul li {position: relative; padding: 0 18px;}
	.login div ul li ~ li:after {content: ""; position: absolute; left: 0; top: 4px; height: 14px; width: 1px; background: #111; transform: rotate(25deg);}
	.login > a {font-size: 14px; color:#666; border-bottomL:1px solid #666;}
	</style>
	<body>
		<section class="login">
			<h1 class="text-center m-4 text-secondary">로그인</h1>
			<ul>
				<li><input type="text" placeholder="아이디" title="아이디 입력"></li>
				<li><input type="password" placeholder="비밀번호" title="비밀번호 입력"></li>
				<li><input type="checkbox" id="id_for"><label for="id_for">아이디저장</label></li>
				<li><button>로그인</button></li>
			</ul>
			<div> 
				<ul>
					<li><a href="#">PW 찾기</a></li>
					<li><a href="#">회원가입</a></li>
					<li><a href="#">ID 찾기</a></li>
				</ul>
			</div>
			<a href="#">비회원 예매확인</a>
		</section>
	</body>
</html>