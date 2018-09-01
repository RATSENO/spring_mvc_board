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
			        <h1 class="page-header">게시물 상세</h1>
			    </div>
			</div>
		    <div class="row">
		        <div class="col-lg-12">
		            <div class="panel panel-default">
		                <div class="panel-heading">
		                    게시물 상세
		                </div>
		                <div class="panel-body">
		                	<div class="row">
		                		<div class="col-lg-6">
		                			<form role="form">
		                				<div class="form-group">
		                					<label>게시물 번호</label>
		                					<input class="form-control" id="boardNo" disabled>
		                				</div>		                			
		                				<div class="form-group">
		                					<label>게시물 제목</label>
		                					<input class="form-control" id="boardTitle" readonly>
		                				</div>
                                        <div class="form-group">
                                            <label>게시물 내용</label>
                                            <textarea class="form-control" id="boardContent" rows="4" readonly></textarea>
                                        </div>
		                				<div class="form-group">
		                					<label>게시물 등록자</label>
		                					<input class="form-control" id="regId" disabled>
		                				</div>	      
		                				<div class="form-group">
		                					<label>게시물 등록일</label>
		                					<input class="form-control" id="regDate" disabled>
		                				</div>	
		                				<div class="form-group">
		                					<label>게시물 수정일</label>
		                					<input class="form-control" id="updateDate" disabled>
		                				</div>			                						                				                                  		                				
		                			</form>
		                		</div>
		                	</div>
		                </div>
		            </div>
		        </div>
		    </div>
		    <div class="row">
				<button type="button" class="btn btn-info" id="btnList">목록</button>
			</div> 
		</div>
	</div>
	
	<%@include file="../include/plugin_js.jsp"%>
</body>
<script type="text/javascript">
var formObj = null;

var urlParam = {
		board_no : "",
		list : "N"
}

$(function(){
	
	urlParam.board_no = getUrlParameter("board_no") || "";
	urlParam.list 	  = getUrlParameter("list") || "N";
	
	formObj = $("form[role='form']");
	
	$("#btnList").on('click', function(){
		goList();
	});
	
	init();
});

function init(){
	if(urlParam.board_no){
		getDetail();
	}
	
}

function getDetail(){
	var url = "/board/detail";
	var param = {};
	param.board_no = urlParam.board_no;
	
	$.ajax({
		type:'post',
		url : url,
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		dataType:'json',
		data : JSON.stringify(param),
		success : function(res){
			console.log(res);
			setDetailData(res);
		}
	});
}

function setDetailData(res){
	var detailData = res.boardList[0];
	
	$("#boardNo").val(detailData.board_no);
	$("#boardTitle").val(detailData.board_title);
	$("#boardContent").val(detailData.board_content);
	$("#regId").val(detailData.reg_id);
	$("#regDate").val(detailData.reg_date);
	$("#updateDate").val(detailData.update_date);
	
}

function goList(){
	formObj.attr("action", "/board/boardList/page");
	formObj.attr("method", "get");
	formObj.submit();
}

</script>
</html>