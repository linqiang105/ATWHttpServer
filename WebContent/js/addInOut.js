var app = angular.module('myApp', []);

app.controller('addInOutCtrl', function($scope, $http, $location, $timeout) {

	$scope.money = 0;
	$scope.bIncomeExpense = true;
	$scope.showSuccess = false;
	$scope.showFail = false;

	var sValue = $location.absUrl().match(
			new RegExp("[\?\&]" + "userToken" + "=([^\&]*)(\&?)", "i"));
	$scope.userToken = (sValue ? sValue[1] : sValue);

	$http.get("/ATWHttpServer/incomeExpense/inOutProject.do").success(
			function(response) {
				$scope.inOutProject = response.result;
				$scope.currentInOutProject = $scope.inOutProject[0].name;
			});

	$http.get("/ATWHttpServer/incomeExpense/inOutItem.do").success(
			function(response) {
				$scope.inOutItem = response.result;
				$scope.currentInOutItem = $scope.inOutItem[0].name;
			});

	var showSuccess = $timeout(function() {
		$scope.showSuccess = false;
	}, 2000);

	$scope.saveInOut = function() {
		$http({
			url : '/ATWHttpServer/incomeExpense/saveInOutHistory.do',
			method : 'POST',
			params : {
				'userToken' : $scope.userToken,
				'inOutType' : $scope.bIncomeExpense,
				'inOutItem' : $scope.currentInOutItem.name,
				'desc' : $scope.reason,
				'money' : $scope.money,
				'memo' : $scope.memo,
				'project' : $scope.currentInOutProject.name
			}
		}).success(function(data, header, config, status) {

			$scope.showSuccess = true;
			$timeout(function() {
				$scope.showSuccess = false;
				$scope.money = 0;
				$scope.memo = "";
				$scope.reason = "";
			}, 2000);

		}).error(function(data, header, config, status) {
			$scope.showFail = true; 
			$timeout(function() {
				$scope.showFail = false;
			}, 2000);
		});
	}
});