<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Register</title>
<style type="text/css">
.container .form-group span {
	color: #ff0000
}

#signup-box {
	width: 70%;
	padding: 30px;
	margin: 13px auto;
	background: black;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body>
	<!-- include navigation bar -->
	<%@ include file="header.jsp"%>


	<br>
	<div class="container ">
		<div class="row ">
			<div id="signup-box">
				<form:form role="form" modelAttribute="userDetails">

					<div class="form-group">
						<form:label path="firstname" class="control-label">
							<spring:message text="First Name" />
						</form:label>
						<form:input path="firstname" class="form-control"
							pattern="^[a-zA-Z]+$" title="Example:Adolf" />

						<!-- to display validation messages -->
						<c:forEach
							items="${flowRequestContext.messageContext.getMessagesBySource('firstname')}"
							var="err">
							<div>
								<span>${err.text}</span>
							</div>
						</c:forEach>
					</div>


					<div class="form-group">
						<form:label path="lastname" class="control-label">
							<spring:message text="Last Name" />
						</form:label>
						<form:input path="lastname" class="form-control"
							pattern="^[a-zA-Z]+$" title="Example:Hitler" />

						<c:forEach
							items="${flowRequestContext.messageContext.getMessagesBySource('lastname')}"
							var="err">
							<div>
								<span>${err.text}</span>
							</div>
						</c:forEach>
					</div>

					<div class="form-group">
						<form:label path="username" class="control-label">
							<spring:message text="User Name" />
						</form:label>
						<form:input path="username" pattern="^[a-zA-Z0-9]+$" class="form-control" />

						<c:forEach
							items="${flowRequestContext.messageContext.getMessagesBySource('username')}"
							var="err">
							<div>
								<span>${err.text}</span>
							</div>
						</c:forEach>
					</div>
					
					<div class="form-group">
						<form:label path="email" class="control-label">
							<spring:message text="Email" />
						</form:label>
						<form:input path="email" pattern="^[a-z0-9._%+-]+@gmail+\.[a-z]{2,3}$" class="form-control" />
						<c:forEach
							items="${flowRequestContext.messageContext.getMessagesBySource('email')}"
							var="err">
							<div>
								<span>${err.text}</span>
							</div>
						</c:forEach>
					</div>

					<div class="form-group">
						<form:label path="mobilenumber" class="control-label">
							<spring:message text="Mobile Number" />
						</form:label>
						<form:input path="mobilenumber" class="form-control"
							pattern="[7|8|9][0-9]{9} *"
							title="Phone number should start with 7-9 and remaing 9 digit with 0-9" />
						<c:forEach
							items="${flowRequestContext.messageContext.getMessagesBySource('mobilenumber')}"
							var="err">
							<div>
								<span>${err.text}</span>
							</div>
						</c:forEach>
					</div>

					<div class="form-group">
						<form:label path="password" class="control-label">
							<spring:message text="Password" />
						</form:label>
						<form:input type='password' path="password"
							title="Password Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
							pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
							class="form-control" />
						<c:forEach
							items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
							var="err">
							<div>
								<span>${err.text}</span>
							</div>
						</c:forEach>
					</div>

					<%-- <div class="form-group">
						<form:label path="confirmpassword" class="control-label">
							<spring:message text="Confirm Password" />
						</form:label>
						<form:input type='password' path="confirmpassword"
							title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
							pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
							class="form-control" />
						<c:forEach
							items="${flowRequestContext.messageContext.getMessagesBySource('confirmpassword')}"
							var="err">
							<div>
								<span>${err.text}</span>
							</div>
						</c:forEach>
					</div> --%>

					<!-- for triggering webflow events using form submission,
					the eventId to be triggered is given in "name" attribute as:
					-->
					<div class="form-group">
						<input type="submit" name="_eventId_submit"
							class="btn btn-primary" value="Register" />
					</div>

				</form:form>
			</div>
		</div>
	</div>



	<!-- include Footer -->
	<%@ include file="footer.jsp"%>
	
	<!-- pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" -->
</body>
</html>