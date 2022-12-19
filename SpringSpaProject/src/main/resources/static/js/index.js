/**
 * controller한테 감
 */

 $(".btnBoard").on("click",function(){
 	$("#section").load("/board/board_select");
 });
 
 $(".btnGuestBook").on("click",function(){
 	$("#section").load("/book/book_select");
 });
 
 $("#section>#book_list").load("/book/book_select10");
 $("#section>#board_list").load("/board/board_select10");