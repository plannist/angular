angular.module("park-calendar", []).directive("parkCalendar", function($timeout){
    return{
        restrict : 'E',
        scope:{
            holiday : "=?",
            schedule : "=?",
            option : "=?"
        },
        templateUrl : 'lib/calendarTemplate.html',
        controller : ['$scope', function($scope){
            var MONTHS = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'];
            var WEEKDAYS = ['일', '월', '화', '수', '목', '금', '토'];
            
            var calculateWeeks = function(){
            	$scope.weeks = new Array();
            	console.log("selectedYear: "+$scope.selectedYear+", selectedMonth: "+$scope.selectedMonth);
            	$timeout(function(){
            		var week = null;
                	
                	var daysInCurrentMonth = new Date($scope.selectedYear, MONTHS.indexOf($scope.selectedMonth)+1, 0).getDate();
                	for (var day = 1; day < daysInCurrentMonth+1; day+=1){
                		var dayNumber = new Date($scope.selectedYear, MONTHS.indexOf($scope.selectedMonth), day).getDay();
                		week = week || [null, null, null, null, null, null, null];
                		week[dayNumber] = {
                			year : $scope.selectedYear,
                			month : MONTHS.indexOf($scope.selectedMonth),
                			day : day
                		};
                		if(day === 6 || day === daysInCurrentMonth){
                			  $scope.weeks.push(week);
                			  week = undefined;
                		}
                	}
            	}, 1);
            	
            };
            
            var calculateSelectedDate = function(){
            	if($scope.option.defaultDate){
            		$scope.option.defaultDate = new Date($scope.option.defaultDate);
            	}else{
            		$scope.option.defaultDate = new Date();
            	}
            	$scope.selectedYear = $scope.option.defaultDate.getFullYear();
            	$scope.selectedMonth = MONTHS[$scope.option.defaultDate.getMonth()];
            	$scope.selectedDay = $scope.option.defaultDate.getDate();
            };
            
            $scope.weekDays = function(size){
            	//return WEEKDAYS.map(function(name){return name.slice(0, size)});
            	return WEEKDAYS;
            };
            
            console.log("do something!!@@");
            calculateWeeks();
            calculateSelectedDate();
            
        }]
    }
});