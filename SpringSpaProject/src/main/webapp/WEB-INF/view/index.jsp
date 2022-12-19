<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script defer src="js/guestbook.js"></script>
<style>
	*{
		margin:0;
		padding:0;
		box-sizing:border-box;
	}
	header{
		background-color:black;
		min-height: 40px;
		color:white;
		position: relative;
	}
	header>h1{
		margin-left:10px;
	}
	nav {
	  position: absolute;
	  top: 0;
	  right: 0;
	  padding: 20px;
	}
	header li{
		margin-right:10px;
		display:inline-block;
	}
	header a{
	  	text-decoration: none;
		color:white;
	}
	
	article>.list{
		display:inline-block;
		margin:11%;
		border:1px solid black;
		min-height:500px;
		min-width:400px;
	}
	footer{
		background-color:black;
		color:white;
		min-height:100px;
	}
	footer>div{
		margin:0 auto;
	}
</style>
<link rel="icon" href="images/favicon.png">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script defer src="js/index.js"></script>
<meta charset="UTF-8">
<title>mybatis springboot</title>
</head>
<body>
	<header>
		<h1>Mybatis SpringBoot</h1>
		<nav>
			<ul>
				<li><a href="/">HOME</a>
				<li><a href="#" class="btnGuestBook">방명록</a>
				<li><a href="#" class="btnBoard">게시판</a>
			</ul>
		</nav>
	</header>
	<article id="section">
		<div class="list" id="book_list">
	      
		</div>
		<div class="list" id="board_list">
		</div>
	</article>
	<footer>
	<div>
		알로감자
		
	</div>
	</footer>
</body>
</html>