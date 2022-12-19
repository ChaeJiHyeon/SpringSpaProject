<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script defer src="js/guestbook.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="book_insert_wrapper">
		<form name="frm_guestbook" class="frm_guestbook_insert" method="post">
			<span>작성자</span>
			<input type="search" name="id"></input><br/>
			<span>작성일</span>
			<input type="date" name="nal"/><br/>
			<textarea name="doc"></textarea><br/>
			<span>암호</span>
			<input type="password" name="pwd"/><br/>
			<input type="button" name="btnGuestbookSave" class="btnGuestbookSave" value="작성"></input>
		</form>
	</div>
</body>
</html>