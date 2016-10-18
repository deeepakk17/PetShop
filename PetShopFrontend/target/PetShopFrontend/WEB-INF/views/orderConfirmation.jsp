<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<%@ include file="header.jsp"%>
	<jsp:useBean id="now" class="java.util.Date" />

	<div class="container-wrapper">
		<div class="container">
			<div class="page-header">
				<h1>Order confirmation</h1>
			</div>

			<div class="container">

				<div class="row">

					<form:form commandName="orderDetails" class="form-horizontal">

						<div
							class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">

							<div class="txt-center">
								<h1 style="color: black;">Receipt</h1>
							</div>
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<address>
										<strong>Shipping Address</strong><br /> ${address.doornumber},
										${address.streetname} <br /> ${address.areaname} <br />

										${address.city}, ${address.state} <br /> ${address.country},
										${address.pincode}
									</address>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6 text-right">
									<p>
										Shipping Date:
										<fmt:formatDate type="date" value="${now}" />
									</p>
								</div>
							</div>
<%-- 
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<address>
										<strong>Billing Address</strong><br />
										${order.userCart.userDetails.address.doornumber},
										${order.userCart.userDetails.address.streetName} <br />
										${order.userCart.userDetails.address.areaname} <br />

										${order.userCart.userDetails.address.city},
										${order.userCart.userDetails.address.state} <br />
										${order.userCart.userDetails.address.country},
										${order.userCart.userDetails.address.pinCode}
									</address>
								</div>
							</div>
 --%>
							<%-- <div class="row">
								<table class="table table-hover">
									<thead>
										<tr>
											<td>Product</td>
											<td>#</td>
											<td class="text-center">Price</td>
											<td class="text-center">Total</td>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="cartItem"
											items="${orderDetails.cart.cartItemList}">
											<tr>
												<td class="col-md-8"><em>${cartItem.products.name}</em></td>
												<td class="col-md-1" style="text-align: center">${cartItem.quantity}</td>
												<td class="col-md-1" style="text-align: center">${cartItem.products.price}</td>
												<td class="col-md-2" style="text-align: center">Rs.
													${cartItem.totalPrice}</td>
											</tr>
										</c:forEach>

										<tr>
											<td></td>
											<td></td>
											<td class="text-right">
												<h4>
													<strong>Grand Total:</strong>
												</h4>
											</td>
											<td class="text-center text-danger">
												<h4>
													<strong>Rs. ${order.userCart.grandTotal}</strong>
												</h4>
											</td>
										</tr>

									</tbody>
								</table>
							</div> --%>
							
							<div class="row">
								<table class="table table-hover">
									<thead>
										<tr>
											<td>Image</td>
											<td>Product</td>
											<td>#</td>
											<td class="text-center">Price</td>
											<td class="text-center">Total</td>
										</tr>
									</thead>
									<tbody>
									<c:set var="grandtotal" value="${0}"/>
										<c:forEach var="cartItem"
											items="${orderDetails.cartItemList}">
											<tr>
											<td><img src="<c:url value='/assets/images/products/${cartItem.products.id}.jpg'/>"  class="img-responsive"
							 height="30px" width="30px"></td>
												<td class="col-md-8"><em>${cartItem.products.name}</em></td>
												<td class="col-md-1" style="text-align: center">${cartItem.quantity}</td>
												<td class="col-md-1" style="text-align: center">${cartItem.products.price}</td>
												<td class="col-md-2" style="text-align: center">Rs.
													${cartItem.totalPrice}</td>
											</tr>
											<c:set var="grandtotal" value="${grandtotal+cartItem.totalPrice}"/>
										</c:forEach>

										
										<%-- <tr>
											<td></td>
											<td></td>
											<td class="text-right">
												<h4>
													<strong>Grand Total:</strong>
												</h4>
											</td>
											<td class="text-center text-danger">
												<h4>
													<strong>Rs. ${grandtotal}</strong>
												</h4>
											</td>
										</tr> --%>

									</tbody>
								</table>
								<div >
<p class="total-right" style="color: black;font-size:18px;">Grand Total: Rs.  ${grandtotal}</p>
<p style="font-style: italic;">Only Cash on Delivery Available*</p>
</div>
							</div>


							<input type="hidden" name="_flowExecutionKey" /> <br />
							<br />

							<button class="btn btn-primary" name="_eventId_back">Back</button>

							<input type="submit" value="Submit Order" class="btn btn-primary"
								name="_eventId_submit" />

						</div>
					</form:form>
				</div>
			</div></div></div>
			<%@ include file="footer.jsp"%>
</body>
</html>