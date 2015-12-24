angular.module('myApp', []).controller(
		'weightCtrl',
		function($scope, $http) {
			$http.get("/ATWHttpServer/weight/getTestMonthRecord.do").success(
					function(response) {
						$scope.weightInfos = response.result;
					});
		});