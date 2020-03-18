/**
 * 
 */
angular.module('ex').controller('homeCtrl', function($rootScope, $scope, $http){
	console.log('homeController 인입');
	$(document).ready(function(){
		console.log('homeController - documentReady 인입');
		var id = sessionStorage.getItem("userId");
		if(!id){
		 $http({
				method : "POST",
				url : "users"
			}).then(function(response){
				console.log("response : ", response);
				if(response.data){
					console.log("greeting setting 인입");
					$rootScope.greeting = response.data.id;
					sessionStorage.setItem("userId", response.data.id);
				}			
			});	
		}else{
			$rootScope.greeting = id;
		}
	});

});