<<<<<<< HEAD
/**
 * 
 */

angular.module('ex').controller('joinCtrl', function($scope, $http){
	console.log("join page 인입:", $scope.id);
	var headers = {"content-type" : "application/x-www-form-urlencoded; charset=UTF-8"};

	$scope.submit = function(){
		var list = new Array();
		var phone = {
				phoneNumber : $scope.phoneNumber
		};
		
		list.push(phone);
		
		$scope.formData = {
			id : $scope.formData.id,
			pwd : $scope.formData.pwd,
			phone : list
		};
		
		var data = JSON.stringify($scope.formData);
		console.log("joinPage data 확인: ", data);
		$http({
			method : "POST",
			url : 'joinProcess',
			dataType : 'application/json',
			data: data
		}).then(function(res){
			console.log("res:", res);
		});
	}
=======
/**
 * 
 */

angular.module('ex').controller('joinCtrl', function($scope, $http){
	console.log("join page 인입:", $scope.id);
	var headers = {"content-type" : "application/x-www-form-urlencoded; charset=UTF-8"};

	$scope.submit = function(){
		var list = new Array();
		var phone = {
				phoneNumber : $scope.phoneNumber
		};
		
		list.push(phone);
		
		$scope.formData = {
			id : $scope.formData.id,
			pwd : $scope.formData.pwd,
			phone : list
		};
		
		var data = JSON.stringify($scope.formData);
		console.log("joinPage data 확인: ", data);
		$http({
			method : "POST",
			url : 'joinProcess',
			dataType : 'application/json',
			data: data
		}).then(function(res){
			console.log("res:", res);
		});
	}
>>>>>>> branch 'master' of https://github.com/plannist/angular.git
});