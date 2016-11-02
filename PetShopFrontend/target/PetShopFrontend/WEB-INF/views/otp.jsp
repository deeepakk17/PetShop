<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter OTP</title>
</head>
<body>
	<!-- include navigation bar -->
	<%@ include file="header.jsp"%>
	<div class="container">
		<form:form modelAttribute="oTP">
			<center style="color: white">Enter OTP : Check your Mail</center>
			<form:input path="otp" class="form-control" />
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('otp')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>
			
			<div class="form-group">
				<input type="submit" name="_eventId_verifyotp" class="btn btn-primary"
					value="Submit" />
			</div>


		</form:form>
		</div>
		<!-- include Footer -->
		<%@ include file="footer.jsp"%>
	
</body>
</html>