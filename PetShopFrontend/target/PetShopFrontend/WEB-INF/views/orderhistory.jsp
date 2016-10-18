<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Cart</title>
</head>
<body>
<!-- include navigation bar -->
	<%@ include file="header.jsp"%>

<c:if test="${empty cartList}">


<section id="error" class="container text-center">
<h1 style="color: white;">Dear User, You haven't Adopted any pet yet.</h1>

<a class="btn btn-primary" href="<c:url value = "/viewallpet" />">Choose your Pet</a>
</section>

<!-- include Footer -->
	<%@ include file="footer.jsp"%>


</c:if>	

<c:if test="${not empty cartList}">	
	<div>
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<h1 class="" style="font-family: 'comic Sans MS', cursive, sans-serif;text-align: center">
				Order History
							</h1>
		</div>
				
	</div><br>
		
<div class="container oList">
<table class="table">
<thead> 
 <tr>
 <th width="100">ORDER ID</th>
 <th width="100">DATE</th>
				<th width="100">TIME</th>
				<th width="100">IMAGE</th>
				<th width="200">PRODUCTNAME</th>
				<th width="100">QUANTITY</th>
			   <th width="100">PRICE</th>
			   <th width="100">TOTAL PRICE</th>
			   
				</tr>
			</thead>

<tbody>
<c:forEach items="${cartList}" var="cart">
								<tr>
									
									<td>#${cart.orderId}</td>
									<td>${cart.date}</td>
									<td>${cart.time}</td>
									<td><img src="<c:url value='/assets/images/products/${cart.products.id}.jpg'/>"  class="img-responsive"
							 height="30px" width="30px"></td>
									<td>${cart.products.name}</td>
									<td>${cart.quantity}</td>
									<td>${cart.products.price}</td>
									<td>${cart.totalPrice}</td>
									
									
									</tr>
							</c:forEach>




</tbody>
</table>
<br>

</div>
</c:if>		
	
	
	
	
	
	
<!-- include Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>