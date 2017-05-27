
<%-- <%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>    --%>
<%--Using forEach --%>
<%-- <div class="container">
	<h1>List of Products</h1>
	<hr/>
	
	<c:forEach items="${products}" var="product">
	
		${product.name}
	
		<hr/>
	</c:forEach>
	
</div>  

--%>

<%-- Using Angular JS--%>
<script src="${js}/angular.js"></script>
<script src="${js}/productController.js"></script>

<div ng-app="myApp">
	<div class="container">

		<div ng-controller="ProductListController as pctrl">
			<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
				<table border="1" margin=2px>
					<thead>
						<tr>
							<th><b>Product Name</b></th>
							<th><b>Product Description</b></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="product in pctrl.products">
							<td>{{product.name}}</td>
							<td>{{product.desc}}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>