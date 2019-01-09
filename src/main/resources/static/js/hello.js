/**
 * 
 */

angular.module("hello", ["ngRoute"])
	.config(function($routeProvider, $httpProvider){
		$routeProvider.when("/", {
			templateUrl : "home.html" ,
			controller : "home",
			controllerAs : "controller"
		}).when("/login", {
			templateUrl : "login.html" ,
			controller : "navigation",
			controllerAs : "controller"
		}).otherwise("/");
		
		//%httpProvider.defaults.headers.common["X-Requested-With"] = "XMLHttpRequest";
		
	})
	.controller("home", function($http){
		var self = this;
		console.log("{}{}{}this: "+this);
		
		$http.get("/resource/").then(function (response){
			self.greeting = response.data;
		})
		
	})
	.controller("navigation", function($rootScope, $http, $location){
		console.log("{}{}{}$rootScope: "+$rootScope);
		//console.log("{}{}{}$http: "+$http);
		console.log("{}{}{}$location: "+$location);
		
	});
	