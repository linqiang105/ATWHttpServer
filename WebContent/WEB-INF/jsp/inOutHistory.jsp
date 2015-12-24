<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width,nitial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>账面明细</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/angular.min.js"></script>
</head>
<body ng-app="myApp" ng-controller="incomeExpenseCtrl">

	<div class="table-responsive">

		<table class="table table-condensed">
			<thead>
				<tr>
					<th style="background-color: skyblue">#</th>
					<th style="background-color: skyblue">类型</th>
					<th style="background-color: skyblue">来源</th>
					<th style="background-color: skyblue">金额</th>
					<th style="background-color: skyblue">录入人员</th>
					<th style="background-color: skyblue">录入时间</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="ie in incomeExpenses">
					<td ng-if="ie.inOutItem.direction==0" style="background-color: red">{{
						$index+1 }}</td>
					<td ng-if="ie.inOutItem.direction==1"
						style="background-color: green">{{ $index+1 }}</td>
					<td ng-if="ie.inOutItem.direction==0" style="background-color: red">{{
						ie.inOutItem.name }}</td>
					<td ng-if="ie.inOutItem.direction==1"
						style="background-color: green">{{ ie.inOutItem.name }}</td>
					<td ng-if="ie.inOutItem.direction==0" style="background-color: red">{{
						ie.desc }}</td>
					<td ng-if="ie.inOutItem.direction==1"
						style="background-color: green">{{ ie.desc }}</td>
					<td ng-if="ie.inOutItem.direction==0" style="background-color: red">{{
						ie.money | currency:"￥" }}</td>
					<td ng-if="ie.inOutItem.direction==1"
						style="background-color: green">{{ ie.money | currency:"￥" }}</td>
					<td ng-if="ie.inOutItem.direction==0" style="background-color: red">{{
						ie.updateUser.username }}</td>
					<td ng-if="ie.inOutItem.direction==1"
						style="background-color: green">{{ ie.updateUser.username }}</td>
					<td ng-if="ie.inOutItem.direction==0" style="background-color: red">{{
						ie.createTime | date:'medium' }}</td>
					<td ng-if="ie.inOutItem.direction==1"
						style="background-color: green">{{ ie.createTime |
						date:'medium' }}</td>
				</tr>
			</tbody>
		</table>

	</div>

	<script src="js/incomeExpense.js"></script>
</body>
</html>