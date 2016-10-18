<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration success</title>
<style type="text/css">
h3,p {
color: white;
}
</style>
</head>
<body>
<!-- include navigation bar -->
	<%@ include file="header.jsp"%>
<section id="successpage" class="container text-center">
<h1>Hi ${userDetails.firstname}</h1>
<h3>Registration successful</h3>
<p>Explore the world of pets</p>
<a class="btn btn-primary" href="<c:url value = "/" />">GO BACK TO THE HOMEPAGE</a>
</section>

<!-- include Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>