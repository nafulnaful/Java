<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CDN 참조-------------------------------------- -->
<link rel="stylesheet"
   href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
   src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- ------------------------------------------------- -->
<script>
   $(function(){
      $('#btnSearch').click(function(e){
    	  e.preventDefault();//submit하려는 기본 동작을 막자.
         var keyword=$('#title').val();
         if(!keyword){
            alert('검색어를 입력하세요');
            $('#title').focus();
            return;            
         }
         var url="naverOpenApi.jsp?query="+encodeURIComponent(keyword)+"&display=20&start=1";
         send(url, keyword, 1);
      })
   })
   
   function send(url, keyword, cpage){
      $.ajax({
         type:'get',
         url:url,
         dataType:'json',
         cache:false
      })
      .done(function(res){
    	  let total=parseInt(res.total);
    	  showList(res.items, total, keyword);
		/*alert("검색한 결과:"+total+"개");
         alert('디스플레이 개수: '+res.items.length); */
      })
      .fail(function(err){
         alert('error: '+err.status);
      })
   }//send()--------------
   
   function showList(items, total, query){
	   let str="<h2> "+query+"검색 결과: "+total+"개</h2>";
	   str+="<table class='table'>";
	   str+="<tr>"
	   $.each(items, function(i, book){
		   str+="<td width='20%'>";
		   str+="<a href='"+book.link+"' target='_blank''>";
		   str+="<img src='"+book.image+"'>";
		   str+="</a>";
		   str+="<h4>"+book.title+"</h4>";
		   //저자(author), 정가(price), 할인가(discount), 출판사(publisher), 출판일()
		   str+="</td>";
		   if(i%5==4){//한개의 행에 5개 단위로 보여주기 위해
			   str+="</tr><tr>";//줄바꿈
		   }
	   })
	   str+="</tr>";
	   str+="</table>";
	   
	   $('#openApiBook').html(str);
   }
</script>

</head>
<body>
<div class="container">
   <div class="row">
      <div class="col-md-12">
         <form>
            <h1 class="text-center">Naver 도서 검색</h1>
            
            <input type="text" name="title" id="title" placeholder="도서명을 입력하세요" class="form-control">
            
            <button class="btn btn-info" id="btnSearch">검   색</button>
         </form>
      </div>
      <hr>
      <div id="openApiBook">
      
      </div>   
   </div>
   
</div>
</body>
</html>