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
		                		<div class="col-sm-12">
			                		<div class="col-sm-4">
			                			조회 결과 : <span id="resultCnt">0</span>개
			                		</div>
			                		<div class="col-sm-4">
			                			<input type="text" id="searchTxt">
			                			<button type="button" id="btnSearch">검색</button>
			                		</div>
	                                <div class="col-sm-4">
	                                    <select class="form-control" id="pageSize">
	                                        <option>10</option>
	                                        <option>20</option>
	                                        <option>30</option>
	                                        <option>40</option>
	                                        <option>50</option>
	                                    </select>
	                                </div>
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
		                	<div id="pageList">
		                	</div>
                            <form role="form" >
                                <button type="submit" class="btn btn-primary" id="btnReg">등록</button>
                                <button type="submit" class="btn btn-danger" id="btnTestReg">TEST등록</button>
                                <button type="submit" class="btn btn-danger" id="btnTestDel">TEST삭제</button>
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

var urlParam = {
		list : ""
}

$(function(){
	
	urlParam.list 	  = getUrlParameter("list");
	
	if(urlParam.list != "N"){
		init();
	}
	
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
		goDetailPage(data);
		
		return false;
	});

	$("#btnTestReg").on('click', function(){
		$.ajax({
			type:'post',
			url : "/board/testBoardRegist",
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType:'json',
			data : JSON.stringify({}),
			success : function(res){
				
			}
		});
		return false;
	});
	
	$("#btnTestDel").on('click', function(){
		$.ajax({
			type:'post',
			url : "/board/testBoardDelete",
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType:'json',
			data : JSON.stringify({}),
			success : function(res){
				
			}
		});
		
		return false;
	});
});

function init(){
	getList();
}

function getList(page_no){
	var url = "/board/list";
	var searchKeyword = "";
	var param = {};
	param.searchKeyword = searchKeyword;
	if(page_no){
		param.page_no = page_no;
	}else{
		param.page_no = 1;
	}
	param.page_size = $("#pageSize option:selected").val()*1;
	
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
	var pageInfo   = res.pageInfo;
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
		$("#resultCnt").text(pageInfo.total_count);
		drawPageNavigation(pageInfo.total_count, pageInfo.page_no, pageInfo.page_size, 10, "getList", "pageList");
	}
}

function goRegPage(){
	var url = "";
	var param = "";
	
	formObj.attr("action", "/board/boardReg/page");
	formObj.attr("method", "get");
	formObj.submit();
}

function goDetailPage(data){
	var url = "/board/boardDetail/page";
	var param = "";
	
	var list = $("#resultCnt").text() == "0" ? "N" : "Y"; 
	param += "?board_no=" +data.board_no;
	param += "&list=" + list;
	
	location.href=url+param;
}

</script>

</html>