var app = angular.module('myApp', []);

app.controller('ProductListController',['$scope','$http', function($scope,$http){
	var me = this;
	
	me.products = [];
	
	
	$http.get('/frontend-shopping/product/all')
	.then(
			// success callback
			function(response){
				me.products = response.data;
			},
			// error callback
			function(error){
				console.log(error);
			}
	);
	
	
//	me.anotherMessage = 'Another message';
//	$scope.message = 'Hello World from Angular Controller';
	
}]);