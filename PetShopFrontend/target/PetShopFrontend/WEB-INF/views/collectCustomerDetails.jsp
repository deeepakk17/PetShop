<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
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
<div class="container ">
	<div class="row ">
		<div id="signup-box">
			<form:form role="form" modelAttribute="address">
				<center><h2 style="color: white;">Shipping Address:</h2></center>

				<div class="form-group">
					<label for="doornumber">Door Number</label>
					<form:input path="doornumber" id="doornumber"
						pattern="^[a-zA-Z0-9]+$" class="form-control" />
				</div>
				
        <div class="form-group">
            <label for="streetname">Street Name</label>
            <form:input path="streetname" id="streetname" class="form-control" />
        </div>

        <div class="form-group">
            <label for="areaname">Area Name</label>
            <form:input path="areaname" id="areaname" class="form-control" />
        </div>

        <div class="form-group">
            <label for="city">City</label>
            <form:input path="city" id="city" class="form-control" />
        </div>

        <div class="form-group">
            <label for="state">State</label>
            <form:input path="state" id="state" class="form-control" />
        </div>

        <div class="form-group">
            <label for="country">Country</label>
            <form:input path="country" id="country" class="form-control" />
        </div>

        <div class="form-group">
            <label for="pincode">Pincode</label>
            <form:input path="pincode" id="pincode" class="form-control" />
        </div>			
				<!-- for triggering webflow events using form submission,
					the eventId to be triggered is given in "name" attribute as:
					-->
				<div class="form-group">
					<input type="submit" name="_eventId_submit" class="btn btn-primary"
						value="Save Address" />
				</div>

			</form:form>
		</div>
	</div>
</div>


<%-- <div class="container-wrapper">
	<div class="container">


		<form:form modelAttribute="address" class="form-horizontal">

			 <div class="form-group">
            <label for="name">Name</label>
            <form:input path="userDetails.username" id="username" class="form-control" />
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <form:input path="cart.userDetails.email" id="email" class="form-control" />
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <form:input path="cart.userDetails.mobilenumber" id="mobilenumber" class="form-control" />
        </div>

        <br/>

			<h3>Address:</h3>

			<div class="form-group">
				<label for="doornumber">Door Number</label>
				<form:input path="doornumber" id="doornumber" class="form-control" />
			</div>

			<div class="form-group">
				<label for="streetname">Street Name</label>
				<form:input path="streetname" id="streetname" class="form-control" />
			</div>

			<div class="form-group">
				<label for="areaname">Area Name</label>
				<form:input path="areaname" id="areaname" class="form-control" />
			</div>

			<div class="form-group">
				<label for="city">City</label>
				<form:input path="city" id="city" class="form-control" />
			</div>

			<div class="form-group">
				<label for="state">State</label>
				<form:input path="state" id="state" class="form-control" />
			</div>

			<div class="form-group">
				<label for="country">Country</label>
				<form:input path="country" id="country" class="form-control" />
			</div>

			<div class="form-group">
				<label for="pincode">Pincode</label>
				<form:input path="pincode" id="pincode" class="form-control" />
			</div>

			<input type="hidden" name="_flowExecutionKey" />

			<br />
			<br />

			<input type="submit" value="Next" class="btn btn-default"
				name="_eventId_submit" />


		</form:form> --%>
		<br />
		<br /> <br />
		<br /> <br />
		<br />
		<%@ include file="footer.jsp"%>
		</body>
</html>