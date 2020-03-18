/**
 * 
 */

angular.module('ex').controller('logoutCtrl', function(){
	$(document).ready(function($http, $rootScope){
		
		if(confirm("로그아웃 하시겠습니까?")){
			console.log("logoutConfirm 인입");
			$.ajax({
				type : 'get',
				url : 'logout',
				//async: false,
				success: function(){
					console.log("success 인입");
					location.href="/";
					sessionStorage.removeItem("userId");
					$rootScope.greeting = null;
				}
			});			
		}
	});
})
