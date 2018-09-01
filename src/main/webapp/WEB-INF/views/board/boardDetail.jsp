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
								    <p>
										<button type="button" class="btn btn-primary" id="btnList">목록</button>
									</p>		                			
		                		</div>
		                	</div>
		                </div>

		            </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-clock-o fa-fw"></i>댓글 : <span id="currentReplyCnt">0</span>/<span id="totalReplyCnt">0</span>
                        </div>
                        
                        <div class="panel-body">
                            <ul class="timeline" id="replyList">
                            
                                <li class="timeline">
                                    <div class="timeline-badge"><i class="fa fa-check"></i>
                                    </div>
                                    <div class="timeline-panel">
                                        <div class="timeline-heading">
                                            <h4 class="timeline-title">댓글 작성자</h4>
                                            <p><small class="text-muted"><i class="fa fa-clock-o"></i>작성 시간</small>
                                            </p>
                                        </div>
                                        <div class="timeline-body">
                                            <p>댓글내용 더럽게 어렵네</p>
                                            <hr>
                                            <!-- 내가 작성한것 일때
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-primary btn-sm dropdown-toggle" data-toggle="dropdown">
                                                    <i class="fa fa-gear"></i> <span class="caret"></span>
                                                </button>
                                                <ul class="dropdown-menu" role="menu">
                                                    <li><a href="#">수정</a>
                                                    </li>
                                                    <li><a href="#">삭제</a>
                                                    </li>
                                                </ul>
                                            </div>    
                                              -->                                   
                                        </div>
                                    </div>
                                </li>

                                <li class="timeline-inverted">
                                    <div class="timeline-badge"><i class="fa fa-check"></i>
                                    </div>
                                    <div class="timeline-panel">
                                        <div class="timeline-heading">
                                            <h4 class="timeline-title">댓글 작성자</h4>
                                            <p><small class="text-muted"><i class="fa fa-clock-o"></i>작성 시간</small>
                                            </p>
                                        </div>
                                        <div class="timeline-body">
                                            <p>댓글 내용 더럽게 어렵네</p>
                                            <hr>
                                            <!-- 
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-primary btn-sm dropdown-toggle" data-toggle="dropdown">
                                                    <i class="fa fa-gear"></i> <span class="caret"></span>
                                                </button>
                                                <ul class="dropdown-menu" role="menu">
                                                    <li><a href="#">수정</a>
                                                    </li>
                                                    <li><a href="#">삭제</a>
                                                    </li>
                                                </ul>
                                            </div> 
                                             -->                                       
                                        </div>
                                    </div>
                                </li>                                
                            </ul>
                        </div>
                        <div id="divReplyMore" style="display: none">
                        	<button type="button" class="btn btn-primary btn-lg btn-block" id="btnReplyMore">더 보기</button>
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
		board_no : "",
		list : "N"
}

var gDetailData = {
		
};
var replyPageInfo = {
		
};

$(function(){
	
	urlParam.board_no = getUrlParameter("board_no") || "";
	urlParam.list 	  = getUrlParameter("list") || "N";
	
	formObj = $("form[role='form']");
	
	$("#btnList").on('click', function(){
		goList();
	});
	
	$("#btnReplyMore").on('click', function(){
		getReplyList();
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
			getReplyList();
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
	
	gDetailData.board_no = detailData.board_no;
}

function getReplyList(){
	
	var url = "/reply/list";
	var param = {};
	
	param.board_no = gDetailData.board_no;
	if(replyPageInfo.page_no){
		param.page_no = replyPageInfo.page_no +1;
	}else{
		param.page_no = 1;
	}
	param.page_size =  10;
	
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
			createReplyList(res);
		}
	});
}

function createReplyList(res){
	var resultList = res.replyList;
	replyPageInfo = res.pageInfo; 
	
	var $replyList = $("#replyList");
	
	if(replyPageInfo.page_no === 1){
		$replyList.html('');
	}
	if(resultList.length > 0){
		var html = '';
		for(i in resultList){
			if(i%2 == 1){
				html +='<li class="timeline">';
			}else{
				html +='<li class="timeline-inverted">';
			}
			html +='<div class="timeline-badge"><i class="fa fa-check"></i>';
			html +='</div>';
			html +='<div class="timeline-panel">';
			html +='    <div class="timeline-heading">';
			html +='        <h4 class="timeline-title">'+ resultList[i].replyer +'</h4>';
			html +='        <p><small class="text-muted"><i class="fa fa-clock-o"></i>'+ resultList[i].reg_date +'</small>';
			html +='        </p>';
			html +='    </div>';
			html +='    <div class="timeline-body">';
			html +='        <p>'+ resultList[i].reply_text +'</p>';
			html +='        <hr>';
			/* 
			html +='        <div class="btn-group">';
			html +='            <button type="button" class="btn btn-primary btn-sm dropdown-toggle" data-toggle="dropdown">';
			html +='                <i class="fa fa-gear"></i> <span class="caret"></span>';
			html +='            </button>';
			html +='            <ul class="dropdown-menu" role="menu">';
			html +='                <li><a href="#">수정</a>';
			html +='               </li>';
			html +='                <li><a href="#">삭제</a>';
			html +='                </li>';
			html +='            </ul>';
			html +='        </div>' ;
			 */
			html +='    </div>';
			html +='</div>';
			html +='</li>';
		}
		
		$replyList.append(html);
		
		var replyListLength = $replyList.find("li").length;
		$("#currentReplyCnt").html(replyListLength || 0);
		$("#totalReplyCnt").html(replyPageInfo.total_count || 0);
		
		if(replyListLength <replyPageInfo.total_count){
			$("#divReplyMore").show();
		}else{
			$("#divReplyMore").hide();
		}
	}
}

function goList(){
	var url = "/board/boardList/page";
	var param = "";
	param += "?list=" + urlParam.list || "N";
	
	location.href=url+param;
}

</script>
</html>