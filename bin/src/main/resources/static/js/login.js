/**
 * 
 */

angular.module('ex').controller('loginCtrl', function($scope, $http){
	console.log("loginCtrl 인입@@");

    var headers = {"content-type" : "application/x-www-form-urlencoded; charset=UTF-8"};
    //var headers = {"content-type" : "application/json"}
    
    $scope.submit = function(){
        // var data = {
        //     id : $scope.user,
        //     pwd : $scope.password
        // };
        // var obj = JSON.stringify(data);

        console.log("id="+$scope.formData.id+", pwd="+$scope.formData.pwd);
        console.log("submit === 인입 formApp data: "+$scope.formData);
        $http({
            method : "POST",
            url : "loginProcess",
            //data : obj,
            data : $.param($scope.formData),
            //data : $scope.formData,
            //paramSerializer : $httpParamSerializerJQLike,
            headers : headers
        });
        // http.then(function(response){
        //     var data = response.data;
        // });
    };
    // ***** 중 요 : formData.id 와 UserVO 의 id  가 매 핑

});