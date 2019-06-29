/**
 * 
 */

angular.module('ex').controller('joinCtrl', function($scope, $http){
	console.log("join page 인입:", $scope.id);
	var headers = {"content-type" : "application/x-www-form-urlencoded; charset=UTF-8"};
	$scope.submit = function(){
		$http({
			method : 'POST',
			url : 'joinProcess',
			data: $.param($scope.formData),
			headers : headers
		}).then(function(res){
			console.log("res:", res);
		});
	}
});