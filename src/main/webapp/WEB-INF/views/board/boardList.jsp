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
			        <h1 class="page-header">Board List</h1>
			    </div>
			</div>
		    <div class="row">
		        <div class="col-lg-12">
		            <div class="panel panel-default">
		                <div class="panel-heading">
		                    Basic Table
		                </div>
		                <div class="panel-body">
		                	<div class="low">
		                		<div class="col-sm-6">
		                		</div>
		                		<div class="col-sm-6">
		                			<input type="text" id="searchTxt">
		                			<button type="button" id="btnSearch">검색</button>
		                		</div>
		                	</div>
		                	<div class="low">
		                		<div class="col-sm-12">
				                    <div class="table table-striped table-bordered table-hover" >
				                        <table class="table">
				                            <thead>
				                                <tr>
				                                    <th>게시물 번호</th>
				                                    <th>게시물 제목</th>
				                                    <th>등록자 ID</th>
				                                    <th>등록일</th>
				                                    <th>수정일</th>
				                                </tr>
				                            </thead>
				                            <tbody id="boardList">
				                                <tr>
				                                    <td colspan="5" align="center">조회 결과가 없습니다.</td>
				                                </tr>
				                            </tbody>
				                        </table> 
				                    </div>		                		
		                		</div>
		                	</div>
                            <form role="form" >
                                <button type="submit" class="btn btn-primary" id="btnReg">등록</button>
                            </form>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
	</div>
	
	<%@include file="../include/plugin_js.jsp"%>
</body>
<script type="text/javascript">
var formObj = null;

$(function(){
	
	formObj = $("form[role='form']");
	
	$("#btnReg").on('click', function(){
		console.log("등록");
		goRegPage();
		
		return false;
	});
	
	$("#btnSearch").on("click", function(){
		console.log("검색");
		getList();
		
		return false;
	});

	$("#boardList").on( 'click', 'a.board-detail', function(){
		var $a = $(this);
		var board_no = $a.data("board_no");
		var data = {};
		data.board_no = board_no;
		goModPage(data);
		
		return false;
	});
	
});

function getList(){
	var url = "/board/list";
	var searchKeyword = "";
	var param = {};
	param.searchKeyword = searchKeyword;
	
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
			createTable(res);
		}
	});
}

function createTable(res){
	var resultList = res.boardList;
	if(resultList.length > 0){
		var $boardList = $("#boardList");
		$boardList.html("");
		var html = "";
		for(i in resultList){
			html += "<tr>";
			html +=  "	<td><a href='' class='board-detail' data-board_no="+  resultList[i].board_no +">"+ resultList[i].board_no+"<a/></td>";
			//html +=  "	<td>"+ resultList[i].board_no +"</td>";
			html +=  "	<td>"+ resultList[i].board_title +"</td>";
			html +=  "	<td>"+ resultList[i].reg_id +"</td>";
			html +=  "	<td>"+ resultList[i].reg_date +"</td>";
			html +=  "	<td>"+ resultList[i].update_date +"</td>";
			html +=  "</tr>";
		}
		$boardList.append(html);
	}
}

function goRegPage(){
	var url = "";
	var param = "";
	
	formObj.attr("action", "/board/boardReg/page");
	formObj.attr("method", "get");
	formObj.submit();
}

function goModPage(data){
	var url = "/board/boardMod/page";
	var param = "";
	param += "?board_no=" +data.board_no 
	
	formObj.attr("action", url+param);
	formObj.attr("method", "get");
	formObj.submit();
}

</script>

</html>