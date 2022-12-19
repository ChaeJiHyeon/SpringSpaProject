<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script defer src="js/guestbook.js"></script>
<link rel='stylesheet' href='css/guestbook.css'/>
<title>guestbook/guestbook_select.jsp</title>
</head>
<body>
<div id='guestbook_list'>
   <%@include file="book_insert.jsp" %>
	<form name="frm_gb_search" class="frm_gb_search" method="post">
		<input type="search" name="findStr" value="${gVo.findStr }">
		<input type="button" value="검색" class="btnSearch">
		<input type="text" name="nowPage" value="${gVo.nowPage }">
		<input type="text" name="serial" value="${gVo.sno }">
		
	</form>
   <div class='guestbook_btn'>
   	<c:if test="${gVo.startNo>1 }">
      <input type='button' value='&lt;' class='btnPrev'>
   	</c:if>
   	
   	<c:if test="${gVo.totSize>gVo.endNo }">
      <input type='button' value='&gt;' class='btnNext'>
     </c:if>
   </div>
   
   <div class='guestbook_items'>
      <c:forEach var='vo' items='${list}'>
         <div class='item'>
            <form name='frm_guestbook' class='frm_guestbook' method='post'>
               <input type="button" class="btnUpdate" value="수정" onclick="gb.modifyView(this.form)">
               <br/>
               <input type="text" name="sno" value="${vo.sno} "/>
               <label>작성자</label>
               <input type='text' class="id" name='id' value='${vo.id }' disabled/><br/>
               <label>작성일</label>
               <output>${vo.nal }</output><br/>
               <textarea class="textarea" rows="7" cols="55" name='doc' disabled>${vo.doc }</textarea>
               <input type="hidden" name="pwd">
               <br/>
               <div class="updateZone">
               <input type='button' value='수정' class='btnGuestbookUpdate' onclick="gb.modalView(this.form, 0)"/>
               <input type="button" class="btnGuestbookDelete" value="삭제" onclick='gb.modalView(this.form, 1)'>
               <input type='button' value='취소' class='btnGuestbookCancel' onclick="gb.modifyCancel(this.form)"/>
            	</div>
            </form>
         </div>
      </c:forEach>
   </div>
</div>
   
   <div id="modal">
   	<div id="content">
   		<input type="button" id="btnClose" value="X"/>
   		<span>암호 입력</span>
   		<input type="password" id="pwd"/>
   		<input type="button" value="확인" id="btnCheck"/>
   		
   	</div>
   </div>
</body>
</html>