/**
 * 
 */
angular.module('ex').controller('buildingCtrl', function($scope, $http){
	console.log("buildingCtrl 인입");
	$scope.address = '123';
	var headers = {"content-type" : "application/x-www-form-urlencoded; charset=UTF-8"};
	
	$scope.send = function(){
		$http({
			method : "POST",
			url : "building",
			data : $scope.address
		})
		.then(function(response){
			var data = response.data;
			console.log("building Data 확인: ", data);
		});
	};
});