/**
 * get방식 url parameter 가져오기
 */
var getUrlParameter = function getUrlParameter(sParam){
	var  sPageUrl = decodeURIComponent(window.location.search.substring(1)),
		 sURLVariables = sPageUrl.split('&'),
		 sParameterName,
		 i;
	for(i=0; i<sURLVariables.length; i++){
		sParameterName = sURLVariables[i].split('=');
		
		if(sParameterName[0]===sParam){
			return sParameterName[1] === undefined ? true : sParameterName[1];
		}
	}
};