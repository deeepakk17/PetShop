

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<title>Login Page</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 60%;
	padding: 30px;
	margin: 13px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
<script type="text/javascript">
window.history.forward();
function noBack() {window.history.forward();}
</script>
</head>
<body onload='noBack(); document.loginForm.username.focus();' onpageshow="if (event.persisted) noBack();" onunload="">

<!-- include navigation bar -->

	<%@ include file="header.jsp"%>
	
	<!-- Page Header -->
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<h1 class="" style="font-family: 'comic Sans MS', cursive, sans-serif;text-align: center">
				<i class="fa fa-paw" aria-hidden="true"></i>  Enter our world   <small></small>
			</h1>
		</div>
	</div>

	<div>


		
	<div id="login-box">
	<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		<form role="form" name='loginForm' action="<c:url value='/spring_login' />"
			method='POST'>


			<div class="form-group">
			<label for="username">Username:</label>
			<input type='text' name='username' class="form-control" />
			</div>
			
			<div class="form-group">
			<label for="password">	Password:</label> 
			<input type='password' name='password' class="form-control" />
			</div>
			<div class="checkbox">
					<label><input type="checkbox"> Remember me</label>
				</div>
			<div>
				<input name="submit" type="submit" value="Explore" class="btn btn-primary" />
			</div>


			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
		</div>
	</div>
<hr>
	<!-- include Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>
