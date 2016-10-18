<!-- include navigation bar -->
<%@ include file="header.jsp"%>
<jsp:useBean id="now" class="java.util.Date" />

<c:if test="${empty orderList}">


	<section id="error" class="container text-center">
		<h1 style="color: white;">Currently there is no Order :'(</h1>

		<a class="btn btn-primary" href="<c:url value = "/" />">Back to
			home </a>
	</section>

	<!-- include Footer -->
	<%@ include file="footer.jsp"%>


</c:if>

<c:if test="${not empty orderList}">
	<div>
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<h1 class=""
				style="font-family: 'comic Sans MS', cursive, sans-serif; text-align: center">
				Customer Orders</h1>
		</div>


	</div>
	<br>

	<c:forEach items="${orderList}" var="order">

		<div class="container oList">
			<div class="row">


				<div class="col-xs-6 col-sm-6 col-md-6">
					<h4
						style="font-family: 'comic Sans MS', cursive, sans-serif; color: white;">
						Order ID : #${order.orderId}</h4>
					<address style="color: white;">
						<strong>Shipping Address:</strong><br />
						${order.billingaddress.doornumber},
						${order.billingaddress.streetname} <br />
						${order.billingaddress.areaname} <br />

						${order.billingaddress.city}-${order.billingaddress.pincode},
						${order.billingaddress.state} <br />
						${order.billingaddress.country}

					</address>
				</div>
				<div class="col-xs-6 col-sm-6 col-md-6 text-right">
					<p style="color: white;">
						Shipping Date:
						<fmt:formatDate type="date" value="${now}" />
					</p>
				</div>


			</div>

			<table class="table">
				<thead>
					<tr>
						<th width="100">IMAGE</th>
						<th width="200">PRODUCTNAME</th>
						<th width="100">QUANTITY</th>
						<th width="100">PRICE</th>
						<th width="100">TOTALPRICE</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${order.cart.cartItemList}" var="cartItem">
						<tr>

							<td><img
								src="<c:url value='/assets/images/products/${cartItem.products.id}.jpg'/>"
								class="img-responsive" height="30px" width="30px"></td>
							<td>${cartItem.products.name}</td>
							<td>${cartItem.quantity}</td>
							<td>${cartItem.products.price}</td>
							<td>${cartItem.totalPrice}</td>
						</tr>
					</c:forEach>




				</tbody>
				<td style="font-size: 25px;">Total Amount : ${totalAmount}</td>
			</table>

			<br>
			<div style="font-size: 25px;">
				<p style="color: white;">Total Amount : Rs. ${totalAmount}</p>
			</div>
		</div>
	</c:forEach>
</c:if>






<!-- include Footer -->
<%@ include file="footer.jsp"%>