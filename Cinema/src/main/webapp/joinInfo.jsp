<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOININFO</title>
</head>
<style>
body.bg-member {
	background-color: #f5f5f5;
}

body {
	overflow: auto;
	overflow-y: scroll;
	letter-spacing: 0;
	line-height: 1.5;
	font-size: 15px;
	color: #444;
	font-weight: 400;
	font-family: NanumBarunGothic, Dotum, '돋움', sans-serif;
}

.body-wrap {
	width: 100%;
	height: 100%;
	padding: 0;
}

* {
	box-sizing: border-box;
}

user agent stylesheet
div {
	display: block;
}

.member-wrap {
	width: 710px;
	min-height: 100%;
	margin: 0 auto;
	padding: 80px 100px;
	background-color: #fff;
}

.member-wrap .ci {
	overflow: hidden;
	display: block;
	margin: 0;
	padding: 0 0 70px 0;
}

.member-wrap .ci a {
	display: block;
	width: 140px;
	height: 47px;
	margin: 0 auto;
	padding: 0;
	font-size: 0;
	line-height: 0;
	background:
		url(https://img.megabox.co.kr/static/pc/images/common/ci/logo.png)
		center no-repeat;
}

.member-wrap .col-wrap {
	overflow: hidden;
}

div {
	display: block;
}

.member-wrap .step-member {
	overflow: hidden;
	position: relative;
	margin: 0 0 40px 0;
	padding: 0;
}

.member-wrap .step-member ol {
	overflow: hidden;
}

ol, ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

.member-wrap .step-member ol li .step {
	display: inline-block;
	position: relative;
	z-index: 2;
	margin: 0;
	padding: 0 0 15px 0;
	font-size: .9333em;
	letter-spacing: 0;
}

.input-text {
    display: inline-block;
    height: 32px;
    padding: 0 10px;
    line-height: 30px;
    color: #444;
    border: 1px solid #d8d9db;
    vertical-align: middle;
    font-family: NanumBarunGothic,Dotum,'돋움',sans-serif;
}

 #joinInfoLoginPhone .input-text{
 	height:60px;
 }

.member-wrap .step-member ol li:first-child {
	margin-left: 0;
}

.member-wrap .step-member ol li {
	float: left;
	margin: 0 0 0 46px;
	padding: 0;
	text-align: center;
	font-size: .9333em;
}

.member-wrap .page-info-txt {
	padding: 0 0 20px 0;
	line-height: 1.1;
}

.member-wrap p {
	margin: 0;
	padding: 0;
}

.member-wrap .page-info-txt strong {
	display: block;
	padding: 0 0 10px 0;
	font-size: 1.4666em;
	color: #222;
	font-weight: 400;
}

.member-wrap .page-info-txt span {
	display: block;
}

</style>

<body class="bg-member">
	<div class="body-wrap">
		<div class="member-wrap">
			<h1 class="ci">
				<a href="#" title="메인 페이지로 이동">GAGABOX : Life Theater</a>
			</h1>
			<div class="col-wrap">
				<div class="col">
					<div class="step-member"
						title="step1 약관동의, step2 정보입력 step3 가입완료 단계 중 step2 약관동의 단계">
						<ol>
							<li>
								<p class="step">
									<em>STEP1.</em> <span>"약관동의"</span>
								</p>
							</li>
							<li>
								<p class="step">
									<em>STEP2.</em> <span>"정보입력"</span>
								</p>
							</li>
							<li>
								<p class="step">
									<em>STEP3.</em> <span>"가입완료"</span>
								</p>
							</li>
						</ol>
					</div>

					<p class="page-info-txt">
						<strong>안녕하세요! 가가박스입니다!</strong> <span>회원정보를 입력해주세요. </span>
					</p>
					<div class="table-wrap">
						<table class="board-form">
							<colgroup>
								<col style="width: 130px;">
								<col>
							</colgroup>
							<tbody>
								<tr>
									<th scope="row"><label for="joinInfoLoginId">
											아이디 </label></th>
									<td><input maxlength="12" id="joinInfoLoginId" type="text"
										placeholder="영문,숫자 조합(7~12자)" class="input-text w260px">
										<button id="btnIDDupCNfm" type="button"
											class="button btn-primary">중복확인</button></td>
								</tr>

								<tr>
									<th scope="row"><label for="joinInfoLoginPwd">
											비밀번호 </label></th>
									<td><input maxlength="16" id="joinInfoLoginPwd"
										type="password" placeholder="영문,숫자,특수기호 중 2가지 이상 조합"
										class="input-text"></td>
								</tr>

								<tr>
									<th scope="row"><label for="joinInfoLoginPwdConfirm">
											비밀번호확인 </label></th>
									<td><input maxlength="16" id="joinInfoLoginPwdConfirm"
										type="password" placeholder="영문,숫자,특수기호 중 2가지 이상 조합"
										class="input-text"></td>
								</tr>

								<tr>
									<th scope="row"><label for="joinInfoLoginName">
											이름 </label></th>
									<td><input maxlength="10" id="joinInfoLoginName"
										type="text" placeholder="이름" class="input-text"></td>
								</tr>

								<tr>
									<th scope="row"><label for="joinInfoLoginBirthDay">
											생년월일 </label></th>
									<td><input maxlength="20" id="joinInfoLoginBirthDay"
										type="text" placeholder="생년월일" class="input-text"></td>
								</tr>

								<tr>
									<th scope="row"><label for="joinInfoLoginEmail">
											이메일 </label></th>
									<td><input maxlength="30" id="joinInfoLoginEmail"
										type="text" placeholder="E-mail" class="input-text"></td>
								</tr>

								<tr>
									<th scope="row"><label for="joinInfoLoginSex">
											성별 </label></th>
									<td><input type="radio" id="joinInfoLoginSexX"
										name="joinInfoLoginSex"> <label
										for="joinInfoLoginSexX"> "남자" </label> <input type="radio"
										id="joinInfoLoginSexY" name="joinInfoLoginSex"> <label
										for="joinInfoLoginSexY"> "여자" </label></td>
								</tr>

								<tr>
									<th scope="row"><label for="joinInfoLoginPhone">
											휴대폰 번호 </label></th>
									<td><input maxlength="3" id="joinInfoLoginPhone"
										type="text" placeholder="010" class="input-text"> <label>"-"</label>
										<input maxlength="4" id="joinInfoLoginPhone" type="text"
										placeholder="1111" class="input-text"> <label>"-"</label>
										<input maxlength="4" id="joinInfoLoginPhone" type="text"
										placeholder="1111" class="input-text"></td>
								</tr>

								<tr>
									<th scope="row"><label for="user_zipcode"> 우편번호
									</label></th>
									<td><input maxlength="30" id="user_addr1" type="text"
										placeholder="주소" class="input-text">
										<button id="btnfind_addr" type="button"
											class="button btn-addr">주소 찾기</button> <input
										maxlength="30" id="user_addr2" type="text" placeholder="상세주소"
										class="input-text"></td>
								</tr>
								
								<tr>
									<th scope="row"><label for="joinInfoLoginLikeMovie">
											선호장르 </label></th>
									<td><input type="radio" id="joinInfoLoginLikeMovie"
										name="joinInfoLoginLikeMovie1"> 
										<label for="joinInfoLoginLikeMovie1"> 호러 </label>
									<td><input type="radio" id="joinInfoLoginLikeMovie"
										name="joinInfoLoginLikeMovie2"> 
										<label for="joinInfoLoginLikeMovie2"> 로멘스 </label>
									<td><input type="radio" id="joinInfoLoginLikeMovie"
										name="joinInfoLoginLikeMovie3"> 
										<label for="joinInfoLoginLikeMovie3"> 스릴러 </label>
									<td><input type="radio" id="joinInfoLoginLikeMovie"
										name="joinInfoLoginLikeMovie4"> 
										<label for="joinInfoLoginLikeMovie4"> 액션 </label>
									<td><input type="radio" id="joinInfoLoginLikeMovie"
										name="joinInfoLoginLikeMovie5"> 
										<label for="joinInfoLoginLikeMovie5"> SF </label>
										<td><input type="radio" id="joinInfoLoginLikeMovie"
										name="joinInfoLoginLikeMovie6"> 
										<label for="joinInfoLoginLikeMovie6"> 코미디 </label>
								</tr>


							</tbody>

						</table>
						<!-- board-form -->
					</div>
					<!-- table-wrap -->

					<div class="btn-member-bottom">
						<button id="btnclauAgree" type="button"
							class="button purple large">"회원가입"</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- body-warp -->
</body>
</html>