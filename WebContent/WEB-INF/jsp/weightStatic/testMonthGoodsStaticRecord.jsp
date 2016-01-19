<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width,nitial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>过磅统计报表</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/angular.min.js"></script>
</head>
<body ng-app="myApp" ng-controller="weightStaticCtrl">

	<div class="table-responsive">

		<table class="table table-condensed table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>货名</th>
					<th>车次</th>
					<th>毛重</th>
					<th>皮重</th>
					<th>净重</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="w in weightStatic">
					<td>{{ $index + 1 }}</td>
					<td>{{ w.condition }}</td>
					<td>{{ w.count }}</td>
					<td>{{ w.gross }}</td>
					<td>{{ w.tare }}</td>
					<td>{{ w.net }}</td>
				</tr>
			</tbody>
		</table>

	</div>

	<script src="js/weightStatic/testMonthGoodsStaticRecord.js"></script>
</body>
</html>