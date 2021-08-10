<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container" style="padding-bottom:240px;">
	<div class="page-util" style>
		<div class="inner-wrap">
			<div class="location">
				<span>Home</span>
					<a href="/movie" title="영화 페이지로 이동">
					</a>
			</div>
		</div>
	</div>
</div>
<body class="body-iframe">
	<div class="inner-wrap" style="padding-top:40px; padding-bottom:100px;">
		<div class="quick-reserve">
			<div class="tit-util">
				<h2 class="tit">빠른예매</h2>
			</div>
		</div>
	</div>
</body>
<div class="gaga-quick-reserve-inculde">
	<div class="time-schedule quick">
		<div class="wrap">
			<button>
				<em style="pointer-evnets:none;">
				"11"
				</em>
				<span class="day-kr" style="pointer-events:none; display:inline-block">
				수</span>
			</button>
			
			<button>
				<em style="pointer-evnets:none;">
				"12"
				</em>
				<span class="day-kr" style="pointer-events:none; display:inline-block">
				목</span>
			</button>
			
			<button>
				<em style="pointer-evnets:none;">
				"13"
				</em>
				<span class="day-kr" style="pointer-events:none; display:inline-block">
				금</span>
			</button>
			
			<button>
				<em style="pointer-evnets:none;">
				"14"
				</em>
				<span class="day-kr" style="pointer-events:none; display:inline-block">
				토</span>
			</button>
			
			<button>
				<em style="pointer-evnets:none;">
				"15"
				</em>
				<span class="day-kr" style="pointer-events:none; display:inline-block">
				일</span>
			</button>
			
			<button>
				<em style="pointer-evnets:none;">
				"11"
				</em>
				<span class="day-kr" style="pointer-events:none; display:inline-block">
				수</span>
			</button>
		</div>
	</div>
</div>

<div class="movie-choice">
	<p class="tit">영화</p>
	<div class="list-area">
		<div class="all-list">
			<div class="list" style="display: block;">
				<div class="scroll m-scroll mCustomScrollbar _mCS_1" id="movieLsit">
					<div id="mCSB_1_container" class="mCSB_container" style="position:relative; top:0px; left:0px;" dir="ltr">
						<ul>
							<li>
								<button type="button" class="btn on" movie-name="싱크홀">영화1</button>
							</li>
							
							<li>
								<button type="button" class="btn on" movie-name="싱크홀">영화2</button>
							</li>
							
							<li>
								<button type="button" class="btn on" movie-name="싱크홀">영화3</button>
							</li>
							
							<li>
								<button type="button" class="btn on" movie-name="싱크홀">영화4</button>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	
<div class="theater-choice">
	<div class-"tit-area">
		<p class="tit">극장</p>
			<div class="list-area" id="brchTab">
				<div class="all-list">
					<div class="list">
						<div class="scroll" id="brchList">
							<ul>
								<li>
									<button type="button" class="btn on">
										<span class="txt">강남(18)</span>
									</button>
								</li>
								
								<li>
									<button type="button" class="btn on">
										<span class="txt">판교(18)</span>
									</button>
								</li>
								
								<li>
									<button type="button" class="btn on">
										<span class="txt">강서구(18)</span>
									</button>
								</li>
								
								<li>
									<button type="button" class="btn on">
										<span class="txt">동대문(18)</span>
									</button>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
	</div>
</div>
</body>
</html>