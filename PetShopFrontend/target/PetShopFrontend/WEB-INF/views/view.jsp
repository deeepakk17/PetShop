<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<!-- Mobile Specific -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>view</title>
<style>

/*********************************************
        		Theme Elements
*********************************************/

.gold{
	color: #FFBF00;
}

/*********************************************
					PRODUCTS
*********************************************/

.product{
	border: 1px solid #dddddd;
	height: 321px;
}

/* .product>img{
	max-width: 230px;
}
 */
.product-rating{
	font-size: 20px;
	margin-bottom: 25px;
}

.product-title{
	font-size: 20px;
}

.product-desc{
	font-size: 14px;
}

.product-price{
	font-size: 22px;
}

.product-stock{
	color: #74DF00;
	font-size: 20px;
	margin-top: 10px;
}

.product-info{
		margin-top: 50px;
}

/*********************************************
					VIEW
*********************************************/

.content-wrapper {
	max-width: 1140px;
	background: #fff;
	margin: 0 auto;
	margin-top: 25px;
	margin-bottom: 10px;
	border: 0px;
	border-radius: 0px;
}

.container-fluid{
	max-width: 1140px;
	margin: 0 auto;
}

.view-wrapper {
	float: right;
	max-width: 70%;
	margin-top: 25px;
}

.container {
	padding-left: 0px;
	padding-right: 0px;
	max-width: 100%;
}

/*********************************************
				ITEM 
*********************************************/
/* 
.service1-items {
	padding: 0px 0 0px 0;
	float: left;
	position: relative;
	overflow: hidden;
	max-width: 100%;
	height: 321px;
	width: 130px;
}

.service1-item {
	height: 107px;
	width: 120px;
	display: block;
	float: left;
	position: relative;
	padding-right: 20px;
	border-right: 1px solid #DDD;
	border-top: 1px solid #DDD;
	border-bottom: 1px solid #DDD;
}

.service1-item > img {
	max-height: 110px;
	max-width: 110px;
	opacity: 0.6;
	transition: all .2s ease-in;
	-o-transition: all .2s ease-in;
	-moz-transition: all .2s ease-in;
	-webkit-transition: all .2s ease-in;
}

.service1-item > img:hover {
	cursor: pointer;
	opacity: 1;
} */

/* .service-image-left {
	padding-right: 50px;
}

.service-image-right {
	padding-left: 50px;
} */

/* .service-image-left > center > img,.service-image-right > center > img{
	max-height: 155px;
} */

.btn a {
color: white;
}
</style>
</head>
<body>

	<!-- include navigation bar -->
	<%@ include file="header.jsp"%>

	<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
		<input type="button" class="btn btn-primary" value="BACK"
			onclick="javascript:history.back()" />
	</div>
	
	<%-- <div class="col-md-12 col-sm-12">

			
			<div class=" col-md-6 col-sm-6">
				<img
					src="<c:url value='/assets/images/products/${productDetails.id}.jpg'/>"
					class="img-responsive" alt="${productDetails.name}" />
			</div>
			<div class="info  col-sm-6 col-md-6">
				<div class="price ">
					<h1>${productDetails.name}</h1>
					<h1 class="price-text-color">Rs. ${productDetails.price}</h1>
				</div>
				<div class="price ">
					<h1>Description</h1>
					<h1 class="price-text-color">${productDetails.description}</h1>
				</div>

				<div class="clear-left">
					<p class="btn-add">
					<h1>	<i class="fa fa-shopping-cart"></i><a href="#" class="hidden-sm">Add
							to cart</a> </h1>
					</p>

				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	 --%>
<div class="container-fluid">
    <div class="content-wrapper">	
		<div class="item-container">	
			<div class="container">	
				<div class="col-md-12">
					<div class="product col-md-5 service-image-left">
                    
						
							<img id="item-display" src="<c:url value='/assets/images/products/${productDetails.id}.jpg'/>" alt="${productDetails.name}"></img>
						
					</div>
					
					
				
					
				<div class="col-md-7">
					<div class="product-title">${productDetails.name}</div>
					<div class="product-desc">${productDetails.description}</div>
					<div class="product-rating"><i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star-o"></i> </div>
					<hr>
					<div class="product-price">Rs. ${productDetails.price}</div>
					<!-- <div class="product-stock">In Stock</div> -->
					<hr>
					<div class="btn-group cart">
					<c:if test="${productDetails.quantity >0 }">
					<p class="btn btn-primary">
										<i class="fa fa-shopping-cart"></i><a
											href="<c:url value="/user/addusercart/${productDetails.id}"/>"
											class="hidden-sm "> Add to cart</a>
									</p>
						</c:if>
						<c:if test="${productDetails.quantity ==0 }">
						<p class="btn btn-primary"><a> <s>Sold Out</s></s></a></p>
						</c:if>
					</div>
					<!-- <div class="btn-group wishlist">
						<button type="button" class="btn btn-danger">
							Add to wishlist 
						</button>
					</div> -->
				</div>
				</div>
			</div> 
		</div>
<!-- 		<div class="container-fluid">		
			<div class="col-md-12 product-info">
					<ul id="myTab" class="nav nav-tabs nav_tabs">
						
						<li class="active"><a href="#service-one" data-toggle="tab">DESCRIPTION</a></li>
						<li><a href="#service-two" data-toggle="tab">PRODUCT INFO</a></li>
						<li><a href="#service-three" data-toggle="tab">REVIEWS</a></li>
						
					</ul>
				<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade in active" id="service-one">
						 
							<section class="container product-info">
								
							</section>
										  
						</div>
					<div class="tab-pane fade" id="service-two">
						
						<section class="container">
								
						</section>
						
					</div>
					<div class="tab-pane fade" id="service-three">
												
					</div>
				</div>
				<hr>
			</div>
		</div> -->
	</div>
</div>

	<!-- include Footer -->
	<%@ include file="footer.jsp"%>

</body>
</html>