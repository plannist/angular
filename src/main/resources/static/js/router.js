
 angular.module("ex", ["ngRoute", "park-calendar", 'ui.router'])
 	.run(function($rootScope, $timeout, $state){
 		console.log('run 인입');
 		$rootScope.locationPage = function(state){
 			console.log("응?: ", state);
 			$timeout(function(){
 				$state.go(state);
 			}, 100);
 		}
 	})
    .config(function($stateProvider, $urlRouterProvider, $httpProvider, $locationProvider){
    	//url 에 #!를 없애주는 역할 html head에서 <base href="/"> 지정 필요
 		if(window.history && window.history.pushState){
 			$locationProvider.html5Mode(true);
 		}
 		
        $stateProvider

        .state("home", {
        	url : "/home"
        	,templateUrl : 'home.html'
        	,controller : 'homeCtrl'
        })
        .state("userList", {
        	url : "/userList", 
        	templateUrl : "userList.html",
        	controller : "userList"
		})
		.state('login', {
			url : '/login',
			templateUrl : 'login.html',
			controller : 'loginCtrl'
			
		})
		.state('promise', {
			url : '/promise',
			templateUrl : 'promise.html',
			controller : 'promiseCtrl'
		})
		.state('calendar', {
			url : '/calendar',
			templateUrl : 'calendar.html',
			controller : 'calendarCtrl'
		})
		.state('admin', {
			url : '/admin',
			templateUrl : 'admin.html',
			controller : 'adminCtrl'
		})
		.state('hibernateLogin', {
			url : '/hivernateLogin',
			templateUrl : 'hibernateLogin.html',
			controller : 'hibernateLoginCtrl'
		})
		.state('building', {
			url : '/building',
			templateUrl : 'building.html',
			controller : 'buildingCtrl'
		})
		.state('join', {
			url : '/join',
			templateUrl : 'join.html',
			controller : 'joinCtrl'
		})
		$urlRouterProvider.otherwise('/');
//        .when("/login", {templateUrl : "../login.html", controller : "loginPage"})
//        .when("/promise", {templateUrl : "../promise.html", controller : "promiseCtrl"})
//        .when("/calendar", {templateUrl : "../calendar.html", controller : "calendarCtrl"})
//        .otherwise({redirectTo : "/"});
        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    })
    .controller("userList", function($scope, $http){

        var http =  $http.get("json");
        http.then(function(response){
           console.log("data: "+response.data.length);
           $scope.userList =  response.data;
        });

       
    })
    .controller("loginPage", function($scope){
        console.log("loginPage 인입");
       

    })
   
      .controller("promiseCtrl", function($scope, $timeout){
          console.log("$scope.answer: "+$scope.answer);
        var promise = $timeout(function(){
            return $scope.answer;
        }, 5000); 

        promise.then(function(val){
            console.log("value: "+val);
            if($scope.answer == 39){
                $scope.result = "정답";
            }else{
                $scope.result = "틀렸음";
            } 
        }, function () {
            $scope.result = "너무 어렵나?";
        });

        promise.finally(function(){
            $scope.info = "retry button!";
        });

        $scope.giveUp = function(){
            $timeout.cancel(promise);
        };

    });

    