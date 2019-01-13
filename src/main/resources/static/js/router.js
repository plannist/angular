
 angular.module("ex", ["ngRoute"])
    .config(function($routeProvider, $httpProvider){
        $routeProvider
        .when("/home", {templateUrl : "../home.html"})
        .when("/userList", {templateUrl : "../userList.html", controller : "userList"})
        .when("/login", {templateUrl : "../login.html", controller : "loginPage"})
        .otherwise({redirectTo : "/"});
        //$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
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
    .controller("login", function($scope, $http){
        // $scope.list = [];
        // $scope.list.push(this.user);
        // $scope.list.push(this.password);
  
        //var headers = {"content-type" : "application/x-www-form-urlencoded; charset=UTF-8"};
        var headers = {"content-type" : "application/json"}
        $scope.submit = function(){
            var data = {
                id : $scope.user,
                pwd : $scope.password
            };
            var obj = JSON.stringify(data);
            console.log("id="+$scope.user+", pwd="+$scope.password);
            console.log("submit === 인입");
            $http({
                method : "POST",
                url : "login1",
                data : obj,
                headers : headers
            });
            // http.then(function(response){
            //     var data = response.data;
            // });
        };
        

    });

    