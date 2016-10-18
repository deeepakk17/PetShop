<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">

<!-- Mobile Specific -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- JS -->

<title>Pets</title>



<!-- <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.12/angular.min.js"></script> -->
</head>
<body>

	<!-- include navigation bar -->

	<%@ include file="header.jsp"%>

	<div class="container" ng-app="searchApp"
		ng-controller="searchController">

<div ng-repeat="item in petList">	 
					{{ item.id }}</div>

		<div class="alert alert-info">
			<p>Sort Type: {{ sortType }}</p>
			<p>Sort Reverse: {{ sortReverse }}</p>
			<p>Search Query: {{ searchItem }}</p>
		</div>

		<form>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-search"></i>
					</div>
					<input type="text" class="form-control" placeholder="Search "
						ng-model="searchItem">
				</div>
			</div>
		</form>

		<table class="table table-bordered table-striped">

			<thead>
				<tr>
					<td><a href="#"
						ng-click="sortType = 'id'; sortReverse = !sortReverse"> ID <span
							ng-show="sortType == 'id' && !sortReverse"
							class="fa fa-caret-down"></span> <span
							ng-show="sortType == 'id' && sortReverse" class="fa fa-caret-up"></span>
					</a></td>
					<td><a href="#"
						ng-click="sortType = 'name'; sortReverse = !sortReverse"> NAME
							<span ng-show="sortType == 'name' && !sortReverse"
							class="fa fa-caret-down"></span> <span
							ng-show="sortType == 'name' && sortReverse"
							class="fa fa-caret-up"></span>
					</a></td>
					<td><a href="#"
						ng-click="sortType = 'category'; sortReverse = !sortReverse">
							CATEGORY <span ng-show="sortType == 'category' && !sortReverse"
							class="fa fa-caret-down"></span> <span
							ng-show="sortType == 'category' && sortReverse"
							class="fa fa-caret-up"></span>
					</a></td>
				</tr>
			</thead>
		<tbody>
				<tr
					ng-repeat="item in petList | orderBy:sortType:sortReverse | filter:searchItem">
					<td>{{ item.id }}</td>
					<td>{{ item.name }}</td>
					<td>{{ item.category.name }}</td>
				</tr>
			</tbody>

		</table>


	</div>


<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.12/angular.min.js"></script> 

<!-- <script type="text/javascript">
angular.module('searchApp',[]).controller('searchController',function($scope,$http){
 alert("hi");
 
  console.log("im in getProduct");
  $http({method:'GET',url:'/dta'}).success(function(data,status,headers,config)
    
  {
  alert(data); 
 //$scope.petList=JSON.parse(JSON.stringify(data));
  $scope.petList=response.data;
   console.log("length"+petList.length);
   for(var c=0;c<$scope.petList.length;c++)
    {
     var cc=$scope.petList[c];
     console.log(cc);
     console.log($scope.petList);
     return $scope.petList;
    }
   
   $http.get("/dta")
    .then(function(response)
  });
 
});
</script>
 -->
 <script>
var app = angular.module('searchApp', []);
app.controller('searchController', function($scope, $http) {
	$http({method:'GET',url:'http://localhost:8083/PetShopFrontend/getdata'}).success(function(data,status,headers,config)
			     {$scope.petList = data;});});
</script>

	<!-- include Footer -->	 
	<%@ include file="footer.jsp"%>

</body>
</html>