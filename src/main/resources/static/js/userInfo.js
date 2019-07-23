/**
 * 
 */
angular.module('ex').controller('userInfoCtrl', function($http, $rootScope){
	
	$(document).ready(function(){
		var id = $rootScope.greeting;
		location.href="/userInfo?id="+id;
	});
});