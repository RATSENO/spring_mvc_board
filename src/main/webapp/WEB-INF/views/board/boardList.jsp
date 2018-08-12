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
		                    <div class="table table-striped table-bordered table-hover" id="dataTables-example">
		                        <table class="table">
		                            <thead>
		                                <tr>
		                                    <th>#</th>
		                                    <th>First Name</th>
		                                    <th>Last Name</th>
		                                    <th>Username</th>
		                                </tr>
		                            </thead>
		                            <tbody>
		                                <tr>
		                                    <td></td>
		                                    <td></td>
		                                    <td></td>
		                                    <td></td>
		                                </tr>
		                            </tbody>
		                        </table>
		                    </div>
                            <form role="form">
                                <button class="btn btn-primary" id="btnReg">등록</button>
                                <button class="btn btn-info" id="btnMod">수정(임시)</button>
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
$(function(){
	
	$("#btnReg").on('click', function(){
		console.log("등록");
		goRegPage();
	});
	
	$("#btnMod").on('click', function(){
		console.log("수정");
		goModPage();
	});
	
	
	function goRegPage(){
		var url = "";
		var param = "";
		
		$(location).attr("href", "/board/boardReg/page");
	}
	
	function goModPage(){
		var url = "";
		var param = "";
		
		$(location).attr("href", "/board/boardMod/page");
	}
	
});

</script>

</html>