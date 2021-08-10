<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>JSON형태로 데이터를 받아봅시다.</h1>
<h2>JSON이란? - JavaScript Object Notation</h2>
<h2>자바스크립트에서 이용하는 객체형태로 데이터를 표현하는 방식</h2>
<h3>JSON객체에는 문자열,배열,숫자,boolean, null값만 들어갈 수 있다.</h3>
<hr>
<button id="bt1" >JSON형태로 받기1</button>
   <button id="bt2">JSON형태로 받기2</button>
   <button id="bt3">JSON형태로 받기3</button>
   <button id="bt4">JSON형태로 받기4-DB에서 가져오기</button>
   <button id="bt5">JSON형태로 받기5-라이브러리 사용하기</button>
   <button id="bt6">JSON형태로 받기6-라이브러리 사용하기</button>
   <button id="bt7">Naver OpenApi에서 도서정보 받아오기</button>
   <hr>
<div id="msg" style="margin-top:20px"></div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
   function showData(data){
      var str="<h1>도서명: "+data.title+"</h1>";
         str+="<h1>출판사: "+data.publish+"</h1>";
         str+="<h1>가 격: "+data.price+"</h1>";
         str+="<h1>출판일: "+data.published+"</h1>";
         str+="<img src='../images/"+data.bimage+"'>"
         $('#msg').html(str);
   }
   //2)응답이 배열로 올 경우----------->반복문 이용해야 함
   //$.each(배열, function(index, item){....})
   function showList(data){
   //alert(data.length);
   var str="<table border='1'>";
   $.each(data,function(i, book){
      //alert(book.title);
      str+="<tr>";
      str+="<td>"+book.title+"["+book.isbn+"]</td>";
      str+="<td><img src='../images/"+book.bimage+"'></td>";
      str+="<td>가격: "+book.price+"원</td>";
      str+="<td>출판사: "+book.publish+"</td>";
      str+="<td>출판dlf: "+book.published+"</td>";
      str+="<tr>";
      
   })
   str+="</table>";
   $('#msg').html(str);
}
   //제일 중요함////
   /* 자바스크립트 보안 정책
         : 자바스크립트는 같은 도메인일 경우만 통신 가능함
         - Ajax통신은 같은 도메인일 경우만 통신할 수 있기 때문에
            Java를 이용해 통신해보자.
           아래 코드는 수행이 안됨
   
   */
   /*$('#bt7').click(function(){
      
      var keyword=prompt('검색어를 입력하세요');       
         if(!keyword) return;
         
       let url="https://openapi.naver.com/v1/search/book.json?query="+keyword;
         $.ajax({
            type:'get',
            url:url,
            headers:{
               'X-Naver-Client-Id':'1sCDSZz35O3VmB2yNt0M',
               'X-Naver-Client-Secret':'7JAIY84Dps'
            },
            dataType:'json',
            cache:false,
            success:function(res){
               alert(res);
            },
            error:function(err){
               alert('error: '+err.status);
            }
         })
            
   })
   */
   
   $('#bt7').click(function(){
      var keyword=prompt('검색어를 입력하세요','Ajax');       
        if(!keyword) return;
        let url="jsonData7.jsp?query="+encodeURIComponent(keyword);
        $.ajax({
           type:'get',
           url:url,
           dataType:'json',
           cache:false,
           success:function(res){
               //alert(res);
               let arr=res.items;//도서 정보 => 배열
               let str="<h1>네이버 도서정보 검색 결과</h1>";
               $.each(arr, function(i, book){
                  str+="<div><a href='"+book.link+"' target='_blank'>";
                  str+="<img src='"+book.image+"'></a>";
                  str+="<h3>"+book.title+"</h3></div>";
               })
               
               $('#msg').html(str);
            },
            error:function(err){
               alert('error: '+err.status);
            }
        })
   });
   
   $('#bt6').click(function(){
       $.ajax({
          type:'get',
          url:'jsonData6.jsp',
          dataType:'json',
          cache:false,
          success:function(res){
             //alert(JSON.stringify(res));
             showList(res);   
          },
          error:function(err){
             alert('error: '+err.status);
          }
       })
    })
   
   $('#bt5').click(function(){
       $.ajax({
          type:'get',
          url:'jsonData5.jsp',
          dataType:'json',
          cache:false,
          success:function(res){
             //alert(JSON.stringify(res));
             showData(res);   
          },
          error:function(err){
             alert('error: '+err.status);
          }
       })
    })
   
   $('#bt4').click(function(){
       $.ajax({
          type:'get',
          url:'jsonData4.jsp',
          dataType:'json',
          cache:false,
          success:function(res){
             //alert(JSON.stringify(res));
             showList(res.books);   
          },
          error:function(err){
             alert('error: '+err.status);
          }
       })
    })
   
   $('#bt3').click(function(){
      $.ajax({
           type:'get',
           url:'jsonData3.jsp',
           dataType:'json',
           cache:false,
           success:function(res){
             //alert(JSON.stringify(res));
            showList(res.books);
           },
           error:function(err){
              alert('error: '+err.status);
           }
        })
   })

   $('#bt2').click(function(){
        $.ajax({
           type:'get',
           url:'jsonData2.jsp',
           dataType:'json',
           cache:false,
           success:function(res){
         //         alert(JSON.stringify(res));
         showList(res);
           },
           error:function(err){
              alert('error: '+err.status);
           }
        })
     })
   $('#bt1').click(function(){
      $.ajax({
         type:'get',
         url:'jsonData.jsp',
         dataType:'json',//응답유형:json
         cache:false,
         success:function(res){
            //alert(JSON.stringify(res));//[object Object]
            //JSON.stringify(객체)=> 객체를 직렬화해서 문자열로 반환하는 함수
            //JSON.parse(문자열)=> json형태의 문자열을 파싱하여 JSON객체로 만들고자 할 때 사용
            showData(res);
            
         },
         error:function(err){
            alert('error: '+err.status);
         }
      })
   })
</script>
</body>
</html>