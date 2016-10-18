<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Choose your payment method</h1>
<form>
	
	<label>	
	<input type="radio">Cash on Delivery
	</label>
	<label>	
	<input type="radio">Net Banking
	</label>
	   
	

                        <input type="submit" value="Confirm" class="btn btn-default" name="_eventId_toprocessOrder" />
	
</form>

</body>
</html>