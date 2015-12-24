<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport"
		content="width=device-width,nitial-scale=1.0,maximum-scale=1.0,user-scalable=no">
	<title>添加一笔收入</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/angular.min.js"></script>
</head>
<body>
	<form name="form" novalidate="novalidate">
		<label name="email">Your email</label>
		<input type="email" name="email" ng-model="email" placeholder="Email Address" />
	</form>
</body>
</html>