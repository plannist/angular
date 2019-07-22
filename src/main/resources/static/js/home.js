/**
 * 
 */
angular.module('ex').controller('homeCtrl', function($rootScope, $scope, $http){
	console.log('homeController 인입');
	$(document).ready(function(){
		console.log('homeController - documentReady 인입');
		 $http({
				method : "POST",
				url : "users"
			}).then(function(response){
				console.log("response : ", response);
				if(response.data){
					console.log("greeting setting 인입");
					$rootScope.greeting = response.data.id;
				}			
			});	
	});

});