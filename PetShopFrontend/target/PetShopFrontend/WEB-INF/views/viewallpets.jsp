<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- Mobile Specific -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>All Pets</title>

<style>
.col-item {
	border: 2px solid #fff;
	border-radius: 5px;
	background: #FFF;
}

.col-item .photo img {
	margin: 0 auto;
	width: 100%;
}

.col-item .info {
	padding: 10px;
	border-radius: 0 0 5px 5px;
	margin-top: 1px;
}

.col-item:hover .info {
	background-color: rgba(215, 215, 244, 0.5);
}

.col-item .price {
	/*width: 50%;*/
	float: left;
	margin-top: 5px;
}

.col-item .price h5 {
	line-height: 20px;
	margin: 0;
}

.price-text-color {
	color: #00990E;
}

.col-item .info .rating {
	color: #003399;
}

.col-item .separator {
	border-top: 1px solid #FFCCCC;
}

.clear-left {
	clear: left;
}

.col-item .separator p {
	line-height: 20px;
	margin-bottom: 0;
	margin-top: 10px;
	text-align: center;
}

.col-item .separator p i {
	margin-right: 5px;
}

.col-item .btn-add {
	width: 50%;
	float: left;
}

.col-item .btn-add {
	border-right: 1px solid #CC9999;
}

.col-item .btn-details {
	width: 50%;
	float: left;
	padding-left: 10px;
}

.controls {
	margin-top: 20px;
}

[data-slide="prev"] {
	margin-right: 10px;
}
</style>




</head>
<body>
	<!-- include navigation bar -->
	<%@ include file="header.jsp"%>


	<!-- Page Content -->
	<div class="container" data-ng-app="displayApp"
		data-ng-controller="displayController">

		<!-- Page Header -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Choose your Pets <small> </small>
				</h1>
			</div>
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-11 col-md-11">
				<form>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-search"></i>
							</div>
							<input type="text" class="form-control"
								placeholder="Search for pets" data-ng-model="searchItem">
						</div>
					</div>
				</form>
			</div>
			<div class="col-lg-1 col-md-1">
				<div class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">Sort
						By <i class="fa fa-angle-down"></i>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#"
							data-ng-click="sortType = 'price'; sortReverse = !sortReverse">Price
								<span data-ng-show="sortType == 'price' && !sortReverse"
								class="fa fa-caret-down"></span> <span
								data-ng-show="sortType == 'price' && sortReverse"
								class="fa fa-caret-up"></span>
						</a></li>
						<li><a href="#"
							data-ng-click="sortType = 'name'; sortReverse = !sortReverse">Name
								<span data-ng-show="sortType == 'name' && !sortReverse"
								class="fa fa-caret-down"></span> <span
								data-ng-show="sortType == 'name' && sortReverse"
								class="fa fa-caret-up"></span>
						</a></li>
					</ul>
				</div>
			</div>
		</div>




		<!-- Projects Row -->
		<div class="row">
			<div
				data-ng-repeat="item in petList | orderBy:sortType:sortReverse | filter:searchItem">
				<div class="col-md-3 col-sm-4" style="padding-bottom: 16px">
					<div class="col-item">
						<div class="info">
							<div class="row">
								<div class="price col-md-6">
									<h5>{{ item.name }}</h5>
									<h5 class="price-text-color">Rs. {{ item.price }}</h5>
								</div>
								<div class="rating hidden-sm col-md-6">
									<i class="price-text-color fa fa-star"></i> <i
										class="price-text-color fa fa-star"></i> <i
										class="price-text-color fa fa-star"></i>
								</div>
							</div>
						</div>

						<div class="photo">
							<img
								src="<c:url value='/assets/images/products/{{item.id}}.jpg'/>"
								class="img-responsive" alt="{{item.name}}" />
						</div>
						<div class="info">
							<div class="separator clear-left">
								<sec:authorize access="hasRole('ROLE_USER')">
									<p ng-show="{{ item.quantity > 0 }}" class="btn-add">
										<i class="fa fa-shopping-cart"></i><a href="<c:url value="/user/addusercart/{{ item.id }}"/>"
											class="hidden-sm">Add to cart</a>
									</p>
									
									<p ng-show="{{ item.quantity == 0 }}" class="btn-add">
										<a class="hidden-sm"><s>Sold Out</s></a>
									</p>

									 <%-- <p class="btn-add">
										<i class="fa fa-shopping-cart"></i><a
											href="<c:url value="/user/addusercart/{{ item.id }}"/>"
											class="hidden-sm">Add to cart</a>
									</p> --%> 

									<!-- to angular controller -->
									<%--	 <p  class="btn-add">
										<i class="fa fa-shopping-cart"></i><a href="#"
										data-ng-click="addToCart('{{ item.id }}')"											
											class="hidden-sm">Add to cart</a>
									</p> --%>

									<p class="btn-details">
										<i class="fa fa-list"></i><a
											href="<c:url value="product/view/{{ item.id }}"/>"
											class="hidden-sm">View</a>
									</p>
								</sec:authorize>
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<p class="btn-add">
										<i class="fa fa-list"></i><a
											href="<c:url value="/product/edit/{{ item.id }}"/>"
											class="hidden-sm">Edit</a>
									</p>
									<p class="btn-details">
										<i class="fa fa-list"></i><a
											href="<c:url value="/product/deleteitem/{{ item.id }}"/>"
											class="hidden-sm">Delete</a>
									</p>
								</sec:authorize>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.row -->
		<hr>
	</div>
	<!-- /.container -->



	<!-- include Footer -->
	<%@ include file="footer.jsp"%>
	<script type="text/javascript">
		var data = ${item};
		var app = angular.module('displayApp', [])
		app.controller('displayController', function($scope, $http) {
			$scope.petList = data;

			$scope.addToCart = function(productId) {
				$http.put('/rest/add/' + productId).success(function() {
					alert('Product successfully added to the cart!');
				});
			};
		});

		app.controller('imageRetriver', function($scope) {
			$scope.posts = [ {
				id : 1
			}, {
				id : 2
			} ];
			$scope.funcName = function(id) {
				return IMAGES[id];
			};
		});
	</script>
</body>
</html>