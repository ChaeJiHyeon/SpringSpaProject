<%@page import="com.project1.book.GuestBookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/guestbook.css"/>
<title>방명록 목록</title>
</head>
<body>
	<div id="guestbook_list">
	<h3>방명록 목록</h3>
		<div class="guestbook_items">
			<c:forEach var='vo' items='${list}'>
	         <div class='item'>
	           [${vo.id }] <div class="doc">${vo.doc }</div><br/>
	         </div>
	      </c:forEach>
		</div>
	</div>	
</body>
</html>