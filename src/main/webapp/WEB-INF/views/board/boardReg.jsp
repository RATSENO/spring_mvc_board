<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="../include/header.jsp"%>

<body>
	<div id="wrapper">

		<!-- Navigation -->
		<%@include file="../include/leftNav.jsp"%>		
		
		<div id="page-wrapper">
			<div class="row">
			    <div class="col-lg-12">
			        <h1 class="page-header">게시물 등록</h1>
			    </div>
			</div>
		    <div class="row">
		        <div class="col-lg-12">
		            <div class="panel panel-default">
		                <div class="panel-heading">
		                    게시물 작성
		                </div>
		                <div class="panel-body">
		                	<div class="row">
		                		<div class="col-lg-6">
		                			<form role="form">
		                				<div class="form-group">
		                					<label>게시물 제목</label>
		                					<input class="form-control" placeholder="게시물 제목을 입력하세요." id="board_title">
		                				</div>
                                        <div class="form-group">
                                            <label>게시물 내용</label>
                                            <textarea class="form-control" rows="4" id="board_content"></textarea>
                                        </div>                                     		                				
		                			</form>
		                		</div>
		                	</div>
		                </div>
		            </div>
		        </div>
		    </div>
			<button type="submit" class="btn btn-primary" id="btnReg">등록</button>
			<button type="submit" class="btn btn-info" id="btnList">목록</button>
		</div>
	</div>
	
	<%@include file="../include/plugin_js.jsp"%>
</body>
<script type="text/javascript">
var formObj = null;

$(function(){
	
	formObj = $("form[role='form']");
	
	$("#btnReg").on('click', function(){
		var data = checkValid();
		if(data != null){
			goRegProcess(data);
		}
		return false;
	});
	
	$("#btnList").on('click', function(){
		goList();
	});

});

function checkValid(){
	var param = {};
	
	var board_title = ""
	var board_content = "";

	board_title = $("#board_title").val().trim() || "";
	board_content = $("#board_content").val().trim() || "";
	
	if(board_title === "")
	{
		alert("게시물 제목을 입력해주세요.");
		return null;
	}

	if(board_content === "")
	{
		alert("게시물 내용을 입력해주세요.");
		return null;
	}
	
	param.board_title = board_title;
	param.board_content = board_content;
	
	return param;
}

function goRegProcess(data){
	var param = data;
	
	$.ajax({
		type : 'post',
		url  : '/board/regist',
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		dataType : 'json',
		data : JSON.stringify({
			board_no : "",
			board_title : data.board_title,
			board_content : data.board_content,
			reg_no : ""
		}),
		success : function(res){
			console.log(res);
			alert('등록되었습니다.');
			setTimeout(goList, 100);
		}
	});
	
}

function goList(){
	formObj.attr("action", "/board/boardList/page");
	formObj.attr("method", "get");
	formObj.submit();	
}





</script>
</html>