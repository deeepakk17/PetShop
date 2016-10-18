<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset Password</title>
<style type="text/css">

.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
#reset-box {
	width: 60%;
	padding: 30px;
	margin: 13px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body>
	<!-- include navigation bar -->
	<%@ include file="header.jsp"%>

	<div id="reset-box">
	<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
	<c:url value='/user/resetpassword' var="reset" />
<center><h4>Reset Password</h4></center>
		<form:form role="form"  modelAttribute="userDetails"
			action="${reset}" method='POST'>


			<div class="form-group">
				<label for="username">New Password</label>
				<form:input type='password' path='password' name='password' class="form-control" />
			</div>

			<div class="form-group">
				<label for="password">Confirm Password</label>
				<form:input type='password' path='confirmpassword' name='confirmpassword'
					class="form-control" />
			</div>

			<div>
				<input name="submit" type="submit" value="Update"
					class="btn btn-primary" />
			</div>



		</form:form>
	</div>

	<!-- include Footer -->
	<%@ include file="footer.jsp"%>

</body>
</html>