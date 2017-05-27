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
	 * Code for jquery Datatables... Creating dummy dataSet
	 */
	
	var products = [
	                
	                ['1','ABC'],
	                ['2', 'PQR'],
	                ['3','XYZ']
	                
	                ];
	
	var $table = $('#productListTable');
	
	if($table.length) {
		
//		console.log('Inside the table!!');
		
		$table.dataTable({
			
			lengthMenu : [[3,5,10,-1],['3 Records','5 Records','10 Records', 'All Records']],
			pageLength : 2,
			data : products
		});
	}

});