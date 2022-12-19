<%@page import="com.project1.board.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
게시판조회
<c:forEach var='vo' items='${list}'>
	         <div class='item'>
	           [${vo.id }] <div class="doc">${vo.doc }</div><br/>
	         </div>
	   </c:forEach>
</body>
</html>