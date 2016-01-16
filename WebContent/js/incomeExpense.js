angular.module('myApp', []).controller('incomeExpenseCtrl', function($scope,$http) {
  $http.get("/ATWHttpServer/incomeExpense/getCurrentInOutHistory.do").success(function(response) {
    $scope.incomeExpenses = response.result; 
  });
});