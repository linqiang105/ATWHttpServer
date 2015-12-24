<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width,nitial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>过磅明细清单</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/angular.min.js"></script>
</head>
<body ng-app="myApp" ng-controller="weightCtrl">

	<div class="table-responsive">

		<table class="table table-condensed table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>流水号</th>
					<th>车号</th>
					<th>收货单位</th>
					<th>货名</th>
					<th>毛重</th>
					<th>皮重</th>
					<th>净重</th>
					<th>毛重时间</th>
					<th>皮重时间</th>
					<th>备注</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="w in weightInfos">
					<td>{{ $index + 1 }}</td>
					<td>{{ w.glideNo }}</td>
					<td>{{ w.carNo }}</td>
					<td>{{ w.receiver }}</td>
					<td>{{ w.goods }}</td>
					<td>{{ w.gross }}</td>
					<td>{{ w.tare }}</td>
					<td>{{ w.net }}</td>
					<td>{{ w.grossTime }}</td>
					<td>{{ w.tareTime }}</td>
					<td>{{ w.memo }}</td>
				</tr>
			</tbody>
		</table>

	</div>

	<script src="js/todayWeight.js"></script>
</body>
</html>