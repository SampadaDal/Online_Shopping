/*solving the active tab problem using jquery */

$(function() {

	// using the window.menu property of page.jsp
	switch (menu) {

	// case gets value from tile which is specified in PageController class
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Login':
		$('#login').addClass('active');
		break;
	default:

		if (menu == "Home")
			break;

		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	/*
	 * Code for jquery Datatables...
	 */

	var $table = $('#productListTable');

	if ($table.length) {

		// console.log('Inside the table!!');

		// creating json url
		var jsonUrl = '';

		if (window.categoryId == '') {

			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {

			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table
				.dataTable({

					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records',
									'All Records' ] ],
					pageLength : 2,

					// using ajax property to display the data
					ajax : {

						url : jsonUrl,
						dataSrc : ''
					},

					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {

									return '<img src = "' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg " class="dataTablesImg"/>';
								}

							},

							{

								data : 'name'
							},

							{
								data : 'brand'
							},
							{
								data : 'price',
								mRender : function(data, type, row) {

									return '&#8377; ' + data;
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style = "color:red">Out of Stock!!</span>';
									}

									return data;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href = "'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
									
									if(row.quantity < 1) {
										str += '<a href = "javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									}
									else {
									str += '<a href = "'
											+ window.contextRoot
											+ '/cart/add/'
											+ data
											+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									}
									return str;
								}
							} ]

				});
	}

});