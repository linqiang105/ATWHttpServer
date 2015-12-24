angular.module('myApp', []).controller(
		'weightCtrl',
		function($scope, $http) {
			$http.get("/ATWHttpServer/weight/getTestTodayRecord.do").success(
					function(response) {
						$scope.weightInfos = response.result;
					});
		});