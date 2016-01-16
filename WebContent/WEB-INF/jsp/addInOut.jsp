<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width,nitial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>添加一笔收支</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

<script src="js/angular.min.js"></script>
<script src="js/addInOut.js"></script>
</head>
<body ng-app="myApp" ng-controller="addInOutCtrl">
	<div class="container">
		<h1></h1>
		<div class="form-group">
			<label class="radio-inline"> <input name="display"
				type="radio" value="true" ng-model="bIncomeExpense"
				ng-checked="true" required> 收入
			</label> <label class="radio-inline"> <input name="display"
				type="radio" value="false" ng-model="bIncomeExpense"> 支出
			</label>
		</div>
		<div class="form-group">
			<label for="projectName">项目名称</label> <select id="inOutProject"
				class="form-control" ng-model="currentInOutProject"
				ng-options="option.name for option in inOutProject">
			</select>
		</div>
		<div class="form-group">
			<label for="inOutItem">条目</label> <select id="inOutItem"
				class="form-control" ng-model="currentInOutItem"
				ng-options="option.name for option in inOutItem" required="true">
			</select>
		</div>
		<div class="form-group">
			<label for="reason">来源/支出项目</label> <input type="text"
				class="form-control" id="reason" ng-model="reason"
				placeholder="来源/支出项目" required="true">
		</div>
		<div class="form-group">
			<label for="money">金额</label> <input type="number"
				class="form-control" id="money" ng-model="money" placeholder="金额"
				required="true">
		</div>
		<div class="form-group">
			<label for="memo">备注</label> <input type="text" class="form-control"
				id="memo" ng-model="memo" placeholder="备注" required="true">
		</div>

		<button type="submit"
			class="btn btn-default btn-primary btn-lg btn-block"
			ng-click="saveInOut()">保存</button>

		<h1 ng-show="showSuccess" class="text-success">添加数据成功！</h1>
		<h1 ng-show="showFail" class="text-danger">添加数据失败！</h1>
		
	</div>

</body>
</html>