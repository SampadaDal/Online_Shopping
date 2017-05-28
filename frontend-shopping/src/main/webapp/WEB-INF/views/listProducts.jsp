<div class="container">
	<div class="row">

		<!--  To display the sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- To display actual product -->
		<div class="col-md-9">

			<!-- Adding a breadcrumb component -->
			<div class="row">
				<div class="col-lg-12">

					<c:if test="${userClickedAllProducts == true}">
					
					<script>
						window.categoryId = '';
					</script>
					
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>

						</ol>
					</c:if>
					
						<c:if test="${userClickedCategoryProducts == true}">
						
						<script>
						window.categoryId = '${category.catID}';
					</script>
						
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">category</li>
							<li class="active">${category.catName}</li>

						</ol>
					</c:if>
					
				</div>

			</div>

			<div class="row">
				
				<div class = "col-xs-12">
				
					<table id="productListTable" class = "table table-striped table-bordered" >
					
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity</th>
								<th></th>
							</tr>
						</thead>
					
						<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity</th>
								<th></th>
							</tr>
						</tfoot>
					</table>
				
				</div>
			
			
			</div>

		</div>
	</div>


</div>