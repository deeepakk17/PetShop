<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Home | Confirm</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style type="text/css">
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

	<div class="container ">


			<!-- Page Header -->
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<h1 class="page-header" style="text-align: center">Confirm Details</h1>
				</div>
			</div>

			<div class="container ">
				<div class="row">
				<div id="signup-box">

					<form:form class="form-horizontal" role="form"
						modelAttribute="userDetails">

						<div class="form-group">
							<form:label path="username" class="control-label">
								<spring:message text="UserName:" />
							</form:label>
							<form:input path="username" readonly="true" class="form-control" />

						</div>
						<div class="form-group">
							<form:label path="firstname" class="control-label">
								<spring:message text="First Name:" />
							</form:label>
							<form:input path="firstname" readonly="true" class="form-control" />

						</div>
						<div class="form-group">
							<form:label path="lastname" class="control-label">
								<spring:message text="Last Name:" />
							</form:label>
							<form:input path="lastname" readonly="true" class="form-control" />

						</div>
						
						<div class="form-group">
							<form:label path="email" class="control-label">
								<spring:message text="Email:" />
							</form:label>
							<form:input path="email" readonly="true" class="form-control" />

						</div>
						<div class="form-group">
							<form:label path="mobilenumber" class="control-label">
								<spring:message text="Mobile Number:" />
							</form:label>
							<form:input path="mobilenumber" readonly="true"
								class="form-control" />

						</div>

						
						
						<!-- for triggering webflow events using form submission,
					 the eventId to be triggered is given in "name" attribute as:
					-->
					<div class="form-group">
						<input type="submit" name="_eventId_edit" class="btn btn-primary"	value="Edit" /> 
						<input type="submit" name="_eventId_submit"	class="btn btn-primary" value="Confirm Details" />
						</div>

					</form:form>

 
 
					<%-- <form:form class="form-horizontal" modelAttribute="userDetails">

						<div class="form-group">
							<form:label path="username" class="control-label">
								<spring:message text="UserName:" />
							</form:label>
							<form:label path="username" class="control-label">
								<spring:message text="${userDetails.username}" />
							</form:label> 
												
						
						
						</div>
						<div class="form-group">
							<form:label path="firstname" class="control-label">
								<spring:message text="First Name:" />
							</form:label>
							<form:label path="firstname" class="control-label">
								<spring:message text="${userDetails.firstname}" />
							</form:label> 

						</div>
						<div class="form-group">
							<form:label path="lastname" class="control-label">
								<spring:message text="Last Name:" />
							</form:label>
							<form:label path="lastname" class="control-label">
								<spring:message text="${userDetails.lastname}" />
							</form:label> 

						</div>
						<div class="form-group">
							<form:label path="email" class="control-label">
								<spring:message text="Email ID:" />
							</form:label>
							<form:label path="email" class="control-label">
								<spring:message text="${userDetails.email}" />
							</form:label> 

						</div>
						<div class="form-group">
							<form:label path="mobilenumber" class="control-label">
								<spring:message text="Mobile Number:" />
							</form:label>
							<form:label path="mobilenumber" class="control-label">
								<spring:message text="${userDetails.mobilenumber}" />
							</form:label> 

						</div>

						<!-- for triggering webflow events using form submission,
					 the eventId to be triggered is given in "name" attribute as:
					-->
						<div class="form-group">
							<input type="submit" name="_eventId_edit" class="btn btn-primary"
								value="Edit" /> <input type="submit" name="_eventId_submit"
								class="btn btn-primary" value="Confirm Details" />
						</div>

					</form:form> --%>
</div>

				</div>
			</div>
		</div>
	
	<!-- include Footer -->
	<%@ include file="footer.jsp"%>


</body>
</html>