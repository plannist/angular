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
			if(!res.data.id){
				alert("이미 사용중인 아이디입니다.");
			}else{
				location.href = "/";
			}
			
		});
	}
});