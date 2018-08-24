/**
 *페이징 모듈
 *@totalCount : 총 리스트 갯수
 *@curruntPage : 현재 페이지
 *@pageSize : 한 페이지에 보여줄 목록 갯수
 *@listSize : 한 번에 보여줄 페이징 갯수
 *@linkFunction : 클릭 function
 *@targetDiv : 만들어질	페이징이 적용될 div id 
 * 
 */
function drawPageNavigation(totalCount, currentPage, pageSize, listSize, linkFunction, targetDiv){
	var DEFAULT_LIST_SIZE = 10;
	var DEFAULT_PAGE_SIZE = 10;
	var DFFAULT_CURRENT_PAGE = 1;
	var linkFunctionName = "javascript:"+linkFunction;
	
	if(totalCount <1) {
		targetDiv = typeof targetDiv == "string" ? $("#"+targetDiv) : targetDiv;
		if(targetDiv){
			targetDiv.html('');
			return true;
		}else{
			return '';
		}
	}
	
	if(!pageSize){pageSize = DEFAULT_PAGE_SIZE;}
	if(!listSize){listSize = DEFAULT_LIST_SIZE;}
	if(!currentPage){currentPage = DFFAULT_CURRENT_PAGE;}
	var totalPageCount = 0;
	if(pageSize >= totalCount){
		totalPageCount = 1;
	}else{
		totalPageCount = Math.ceil(totalCount/pageSize);
	}
	
	var startPage = currentPage - Math.floor((currentPage-1)%listSize);
	var endPage = startPage + listSize -1;
	if(endPage > totalPageCount){
		endPage = totalPageCount;
	}
	
	console.log("startpage:",startPage);
	console.log("endPage:", endPage);
	console.log("totalPageCount:", totalPageCount);
	
	var tagStr = '';
	if(totalPageCount>0){
		tagStr += '<nav><ul class="pagination">';
		if(currentPage >1){
			tagStr += '<li><a href="#" onclick="'+linkFunction+'(1)" class="first" aria-label="First"><span aria-hidden="true"><i class="fa fa-angle-double-left"></i></span></a></li>';
		}else{
			tagStr += '<li class="disabled"><a href="#" class="first" aria-label="First"><span aria-hidden="true"><i class="fa fa-angle-double-left"></i></span></a></li>';
		}
		
		if(currentPage > 10){
			var newPage = 1;
			if(currentPage*1 > 10){
				newPage = currentPage*1 - 10;
			}else{
				newPage = 1;
			}
			tagStr += '<li><a href="javascript:void(0);" class="prev" aria-label="Previous" onclick="'+linkFunction+'('+newPage*1+')"><span aria-hidden="true"><i class="fa fa-angle-left"></i></span></a></li>';                              
		}else{
			tagStr += '<li class="disabled"><a href="#" class="prev" aria-label="Previous"><span aria-hidden="true"><i class="fa fa-angle-left"></i></span></a></li>';
		}
		
		for(var i=startPage; i<= endPage; i++){
			if(i== currentPage){
				tagStr += '<li class="active"><a href="#">'+i+'</a></li>';
			}else{
				tagStr += '<li><a href="#" onclick="'+ linkFunction+'('+ i +')">'+ i +'</a></li>';
			}
		}
		
		if(currentPage*1+10 <= totalPageCount*1){
			var newPage = 1;
			if(totalPageCount > currentPage*1 + 10){
				newPage = currentPage*1 + 10;
			}else{
				newPage = totalPageCount;
			}
			tagStr += '<li><a href="javascript:void(0)" class="next" aria-label="Next" onclick="'+linkFunction+'('+ newPage*1 +')"<span aria-hidden="true"><i class="fa fa-angle-right"></i></span></a></li>';
		}else{
			tagStr += '<li class="disabled"><a href="#" class="next" aria-label="Next"><span aria-hidden="true"><i class="fa fa-angle-right"></i></span></a></li>';
		}
		
		if(currentPage < totalPageCount){
			tagStr += '<li><a href="#" class="end" aria-label="End" onclick="'+linkFunction+'('+(totalPageCount)+')"><span aria-hidden="true"><i class="fa fa-angle-double-right"></i></span></a></li>';
		}else{
			tagStr += '<li class="disabled"><a href="#" class="end" aria-label="End"><span aria-hidden="true"><i class="fa fa-angle-double-right"></i></span></a></li>';
		}
		tagStr += '</ul></nav>';
	}
	targetDiv = typeof targetDiv == "string" ? $("#"+targetDiv) : targetDiv;
	
	if(targetDiv){
		targetDiv.html(tagStr);
		return true;
	}
	else{
		return tagStr;
	}
}