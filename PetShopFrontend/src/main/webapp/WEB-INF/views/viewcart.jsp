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
<h1 style="color: white;">Your Cart is Empty</h1>

<a class="btn btn-primary" href="<c:url value = "/viewallpet" />">Choose your Pet</a>
</section>

<!-- include Footer -->
	<%@ include file="footer.jsp"%>
</c:if>	

<c:if test="${not empty cartList}">	
	<div>
		<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
			<h1 class="" style="font-family: 'comic Sans MS', cursive, sans-serif;text-align: center">
				You are about to own.. 
							</h1>
		</div>
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
		<a class="btn btn-primary" href="<c:url value = "/viewallpet" />">Continue Shopping</a>
		<a class="btn btn-primary" href="<c:url value = "/order/${cartId}" />">Checkout</a>
		
		
		</div>
		
	</div><br>
		
<div class="container oList">
<table class="table">
<thead> 
 <tr>
				<th width="100">IMAGE</th>
				<th width="200">PRODUCTNAME</th>
				<th width="100">QUANTITY</th>
			   <th width="100">PRICE</th>
			   <th width="100">TOTALPRICE</th>
				<th width="100">ACTION</th>
				</tr>
			</thead>

<tbody>
<c:forEach items="${cartList}" var="cart">
								<tr>
									
									<td><img src="<c:url value='/assets/images/products/${cart.products.id}.jpg'/>"  class="img-responsive"
							 height="30px" width="30px"></td>
									<td>${cart.products.name}</td>
									<td>${cart.quantity}</td>
									<td>${cart.products.price}</td>
									<td>${cart.totalPrice}</td>
									
									<td><a
										href=" <c:url value="/deletecart/${cart.cartItemId}"/>">Not my pet</a></td>
								</tr>
							</c:forEach>




</tbody>
<%-- <td style="font-size:25px;">Total Amount : ${totalAmount}</td> --%>
</table>
<br>
<div style="font-size:25px;">
<p style="color: white;">Total Amount : Rs.  ${totalAmount}</p>
</div>
</div>
</c:if>		
	
	
	
	
	
	
<!-- include Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>