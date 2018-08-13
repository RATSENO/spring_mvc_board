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
		                					<input class="form-control" placeholder="게시물 제목을 입력하세요.">
		                				</div>
                                        <div class="form-group">
                                            <label>게시물 내용</label>
                                            <textarea class="form-control" rows="4"></textarea>
                                        </div>		                				
		                			</form>
		                		</div>
		                	</div>
		                </div>
		            </div>
		        </div>
		    </div>
			<form role="form" >
				<button type="submit" class="btn btn-primary" id="btnReg">등록</button>
				<button type="submit" class="btn btn-info" id="btnList">목록</button>
			</form>
		</div>
	</div>
	
	<%@include file="../include/plugin_js.jsp"%>
</body>
<script type="text/javascript">
var formObj = null;

$(function(){
	
	formObj = $("form[role='form']");
	
	$("#btnReg").on('click', function(){
		goRegProcess();
	});
	
	$("#btnList").on('click', function(){
		goList();
	});
});


function goRegProcess(){
	
}

function goList(){
	formObj.attr("action", "/board/boardList/page");
	formObj.attr("method", "get");
	formObj.submit();	
}





</script>
</html>