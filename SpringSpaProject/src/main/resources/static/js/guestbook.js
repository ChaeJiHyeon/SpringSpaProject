/**
 * 
 */
 var delForm;
 var i;
  
 (gb = function(){
 $('.btnSearch').on('click', function(){
 	let frm=$('.frm_gb_search')[0];
 	frm.nowPage.value=1;
 	let param = $(frm).serialize();
 	$('#section').load('/book/book_select', param);
 });
 $('.btnPrev').on('click', function(){
 	let frm=$('.frm_gb_search')[0];
 	frm.nowPage.value=Number(frm.nowPage.value)-1;
 	console.log("a");
 	let param = $(frm).serialize();
 	$('#section').load('/book/book_select', param);
 });
 $('.btnNext').on('click', function(){
console.log("a");
 	let frm=$('.frm_gb_search')[0];
 	frm.nowPage.value=Number(frm.nowPage.value)+1;
 	let param = $(frm).serialize();
 	$('#section').load('/book/book_select', param);
 });
 $('.btnGuestbookSave').on('click', function(){
 	let frm=$('.frm_guestbook_insert')[0];
 	let param = $(frm).serialize();
 	$.post('/book/book_insert', param, function(){
 		frm=$('.frm_gb_search')[0];
 		param = $(frm).serialize();
 		$('#section').load('/book/book_select', param);
 	});
 });
 
 gb.modifyView=function(frm){
 
	let div = frm.querySelector(".updateZone");
	div.style.visibility = "visible";
	let id = frm.querySelector(".id");
	id.disabled = false;
	let textarea = frm.querySelector(".textarea");
	textarea.disabled = false;
	let updatebtn  = frm.querySelector(".btnUpdate");
	updatebtn.style.visibility = "hidden";
 }
 gb.modifyCancel=function(frm){
	let div = frm.querySelector(".updateZone");
	div.style.visibility = "hidden";
	let id = frm.querySelector(".id");
	id.disabled = true;
	let textarea = frm.querySelector(".textarea");
	textarea.disabled = true;
	let updatebtn  = frm.querySelector(".btnUpdate");
	updatebtn.style.visibility = "visible";
 }
  //modal box control 
  
 gb.modalView=function(frm, index){
 	delForm=frm;
 	i=index;
	console.log(delForm.doc.value);
	console.log(i);
 	
	$('#modal').css('display', 'block');
 }
$('#btnClose').on('click', function(){
	console.log(delForm.doc.value);
	console.log(i);
 	
	$('#modal').css('display', 'none');
});

//방명록 삭제
$('#btnCheck').on('click', function(){
if(i==1){
	delForm.pwd.value=$('#pwd').val();
 	console.log("삭제"+delForm.sno.value);
	let frm=delForm;
	let param = $(frm).serialize();
	$.post('/book/book_delete', param, function(){
 		frm=$('.frm_gb_search')[0];
 		param = $(frm).serialize();
 		$('#section').load('/book/book_select', param);
 	});
 }
 else{
	delForm.pwd.value=$('#pwd').val();
 	let frm=delForm;
 	console.log("수정"+frm.sno.value);
 let param = $(frm).serialize();
	$.post('/book/book_update', param, function(){
 		frm=$('.frm_gb_search')[0];
 		param = $(frm).serialize();
 		$('#section').load('/book/book_select', param);
 	});
 }
});

 })();