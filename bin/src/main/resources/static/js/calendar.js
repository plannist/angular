   angular.module('ex')
   .controller("calendarCtrl", function($scope){
        //선택된 날짜 기억
        $scope.selectedDate = {
            year : '',
            month : '',
            day : ''
        }
        console.log("calendar insert !!@@!!");




        eventClick = function(date){
            
        };

        monthClick = function(year, month){

        };

        var today = new Date();
        $scope.option = {
            defaultDate : '',
            toDate : '',
            eventClick : eventClick,
            monthClick : monthClick,
            goToday : function(){
                $scope.currDateUpdate(today.getFullYear(), today.getMonth(),today.getDate());
            }
        };
        
        
        $scope.schedule = "";
        $scope.holiday = "";
        $scope.option.defaultDate = new Date();
        console.log("defaultDate: "+$scope.option.defaultDate);

        $scope.currDateUpdate = function(year, month, day){
            monthClick(year, month+1);
            $scope.option.toDate = new Date(year, month, day);
            eventClick({
                year : year,
                month : month,
                day : day
            });
        };
    });
