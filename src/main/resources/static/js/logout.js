/**
 * 
 */

angular.module('ex').controller('logoutCtrl', function(){
	$(document).ready(function($http){
		
		if(confirm("로그아웃 하시겠습니까?")){
			console.log("logoutConfirm 인입");
			$.ajax({
				type : 'get',
				url : 'logout',
				//async: false,
				success: function(){
					console.log("success 인입");
					location.href="/";
				}
			});			
		}
	});
})
