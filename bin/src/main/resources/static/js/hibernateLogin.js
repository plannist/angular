/**
 * 
 */
angular.module('ex')
.controller('hibernateLoginCtrl', function($scope, $http){
	console.log("hibernateLogin 인입123");
	//var headers = {"content-type" : "application/x-www-form-urlencoded; charset=UTF-8"};
	var headers = {"content-type" : "application/json; charset=UTF-8"};
	$scope.submit = function(){
        console.log("id="+$scope.formData.id+", pwd="+$scope.formData.pwd);
        console.log("submit === 인입 formApp data: ", $scope.formData);
        var data = JSON.stringify($scope.formData);
		$http({
			method : "POST",
			url : "loginEntity",
			data : {'id':$scope.formData.id, 'pwd' : $scope.formData.pwd}
//			data : data,
//			headers : headers
		}).then(function(response){
			console.log("response: ", response);
		});
	}
});