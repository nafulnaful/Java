<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<jsp:include page="/top.jsp"  />

<script>
   let selectDCate=function(upCode){
      //상위 카테고리코드에 해당하는 하위 카테고리 목록 가져오기
      $.ajax({
         type:'get',
         url:'../downCate.me?upCode='+upCode,
         dataType:'xml',
         cache:false,
         success:function(res){            
           let dcate=$(res).find('category');//category element collection
           let str="<select name='downCg_code' id='downCg_code'>";
           $.each(dcate, function(i, item){ //item=> category element
              let dcode=$(item).find('downCg_code').text();
              let dname=$(item).find('downCg_name').text();
              //alert(dcode+"/"+dname);
              str+="<option value='"+dcode+"'>"+dname+"</option>";
           })
           str+="</select>";
           $('#selectDcg').html(str);
         },
         error:function(err){
            alert('error: '+err.status);
         }
      });
   }
   
   
   let check=function(){
      if(! $('#upCg_code').val()){
         alert('상위 카테고리를 선택하세요');
         return false;
      }
      if(!$('#downCg_code').val()){
         alert('하위 카테고리를 선택하세요');
         return false;
      }
      
      return true;
   }
   
</script>

   <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
           <h1 class="text-center">상품 정보 수정[Admin Page]</h1>
          <%--  ${prod} --%>
           <form name="prodF" id="prodF" action="prodEdit.me" method="POST"
            enctype="multipart/form-data" onsubmit="return check()">
            <!-- 파일업로드시: enctype="multipart/form-data"-->
            <table class="table table-condensed table-bordered mt-4">
               <thead>
                  <tr>
                     <th colspan="2" class="text-center">
                        <h3>:::Product Edit Form:::</h3>
                     </th>
                  </tr>
               </thead>
               <tbody>
                  <tr>
                     <td width="20%"><b>카테고리</b></td>
                     <td width="80%">
                     <b class="text-primary">${prod.allCategory}</b>
                     
                     <select name="upCg_code" id="upCg_code"
                        onchange="selectDCate(this.value)">
                           <option value="">::상위 카테고리::</option>
                           <c:forEach var="up" items="${upCgList }">
                              <option value="${up.upCg_code}">${up.upCg_name}</option>
                           </c:forEach>
                          <!-- <option value="9" selected>
                        전자제품
                           </option>
                           <option value="10">
                                 생활용품
                           </option> -->
                     </select> 
                     <span id="selectDcg"> 
                     
                     
                         <!-- <select name="downCg_code">
                           <option value="1">컴퓨터</option>
                           <option value="2">가전(냉장고)</option>
                        </select> -->
                     </span></td>
                  </tr>
                  <tr>
                     <td width="20%"><b>상품번호</b></td>
                     <td width="80%"><input type="text" name="pnum" id="pnum" value="${prod.pnum}" readonly>
                     <span style="color: red"> 
                     </span>
                  </td>
                  <tr>
                     <td width="20%"><b>상품명</b></td>
                     <td width="80%"><input type="text" name="pname" id="pname"  value="${prod.pname}">
                     <span style="color: red"> 
                     </span>
                  </td> 
                  </tr>
                  <tr>
                     <td width="20%"><b>제조사</b></td>
                     <td width="80%"><input type="text" name="pcompany" value="${prod.pcompany}"
                        id="pcompany"></td>
                  </tr>
                  <tr>
                     <td width="20%"><b>상품스펙</b></td>
                     <td width="80%">
                     <span class="badge badge-success">${prod.pspec}</span>
                     <select name="pspec" id="pspec">
                           <option value="NEW" selected>NEW</option>
                           <option value="HIT">HIT</option>
                           <option value="BEST">BEST</option>
                     </select></td>
                  </tr>
                  <tr>
                     <td rowspan="2">상품이미지</td>
                     <td>
                        <img src="../product_images/${prod.pimage1}" class="img-thumbnail"
                         style="width:20%" alt="상품이미지1">
                         
                        <img src="../product_images/${prod.pimage2}" class="img-thumbnail"
                         style="width:20%" alt="상품이미지2">
                         
                        <img src="../product_images/${prod.pimage3}" class="img-thumbnail"
                         style="width:20%" alt="상품이미지3">  
                     </td>
                  </tr>
                  <tr>
                     <td>
                     <!-- hidden data(기존에 첨부했던 이미지파일명을 hidden data로) -->
                     <input type="hidden" name="old_pimage1" value="${prod.pimage1}">
                     <input type="hidden" name="old_pimage2" value="${prod.pimage2}">
                     <input type="hidden" name="old_pimage3" value="${prod.pimage3}">
                     <!-- ----------------------------------------------- -->
                        <input type="file" name="pimage1"><br> 
                        <input type="file" name="pimage2"><br> 
                        <input type="file" name="pimage3"><br>
                      </td>
                  </tr>

                  <tr>
                     <td width="20%"><b>상품수량</b></td>
                     <td width="80%"><input type="number" name="pqty" value="${prod.pqty}" id="pqty">
                        개
               <span style="color: red"> 
               </span></td>
                        
                  </tr>
                  <tr>
                     <td width="20%"><b>상품정가</b></td>
                     <td width="80%">
                     <input type="text" name="price" id="price" value="${prod.price}">
      
                        원
                     <span style="color: red"> 
                     
               </span>         
                        </td>
                  </tr>
                  <tr>
                     <td width="20%"><b>상품판매가</b></td>
                     <td width="80%"><input type="text" name="saleprice"  value="${prod.saleprice}"
                        id="saleprice"> 원
                        <span style="color: red"> 
                     
               </span>   
                        
                        </td>
                  </tr>
                  <tr>
                     <td width="20%"><b>상품설명</b></td>
                     <td width="80%"><textarea name="pcontents" id="pcontents"
                           rows="5" cols="60">${prod.pcontents}</textarea></td>
                  </tr>
                  <tr>
                     <td width="20%"><b>포인트</b></td>
                     <td width="80%"><input type="number" name="point" value="${prod.point}" id="point">
                        POINT</td>
                  </tr>
                  <tr>
                     <td colspan="2">
                        <button class="btn btn-success">상품수정</button>
                     </td>
                  </tr>
               </tbody>
            </table>
         </form>
           
        </div>
      </div>
    </div>
  </div>
    
<jsp:include page="/foot.jsp"  />    