/**
 * JQuery.validate / .extends 사용 (extends 는 개발자 직접 구현한 addMethod묶음)
 */

angular.module('ex').controller('joinCtrl', function($scope, $http){
	console.log("join page 인입:", $scope.id);
	var headers = {"content-type" : "application/x-www-form-urlencoded; charset=UTF-8"};
	
	 $.validator.addMethod("passwordCheck", function(value, element){
	 	 return /^[A-Za-z0-9\d=!\-@._*]*$/.test(value) // consists of only these
	 	       && /[a-z]/.test(value) // has a lowercase letter
	 	       && /\d/.test(value); // has a digit
	 });
	
	$('form.join').validate({
		rules: {
			phone : {
				required : true,
				valueTrim : true,
				minlength : 10,
				maxlength : 11,
				digits : true
			},
			id : {
				required : true,
				valueTrim : true,
				minlength : 4,
				maxlength : 15
			},
			pwd : {
				required : true,
				valueTrim : true,
				minlength : 9,
				maxlength : 15,
				passwordCheck : true
			}
		},
		messages : {
			phone : {
				required : "필수 입력 항목입니다.",
				minlength : "최소 {0}글자로 입력하세요",
				maxlength : "최대 {0}글자로 입력하세요",
				digits : "숫자만 입력하세요"
			},
			id : {
				required : "필수 입력 항목입니다.",
				minlength : "최소 {0}글자로 입력하세요",
				maxlength : "최대 {0}글자로 입력하세요"
			},
			pwd : {
				required :"필수 입력 항목입니다.",
				minlength : "최소 {0}글자로 입력하세요",
				maxlength : "최대 {0}글자로 입력하세요",
				passwordCheck: "패스워드 유효성 부적합"
			}
		},
		submitHandler : function(frm){
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
	
//	$scope.submit = function(){
//		var list = new Array();
//		var phone = {
//				phoneNumber : $scope.phoneNumber
//		};
//		
//		list.push(phone);
//		
//		$scope.formData = {
//			id : $scope.formData.id,
//			pwd : $scope.formData.pwd,
//			phone : list
//		};
//		
//		var data = JSON.stringify($scope.formData);
//		console.log("joinPage data 확인: ", data);
//		$http({
//			method : "POST",
//			url : 'joinProcess',
//			dataType : 'application/json',
//			data: data
//		}).then(function(res){
//			console.log("res:", res);
//			if(!res.data.id){
//				alert("이미 사용중인 아이디입니다.");
//			}else{
//				location.href = "/";
//			}
//			
//		});
//	}
});