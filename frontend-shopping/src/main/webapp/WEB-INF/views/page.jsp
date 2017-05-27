<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- specifies the root directory of the project which is frontend-shopping!! -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!-- /resources mapping comes from dispatcher-servlet -->
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Online shopping ${title}</title>

<script>
	window.menu = '${title}';
</script>
<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap darkly theme -->
<link href="${css}/bootstrap-darkly-theme.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<script type="text/javascript"
	src="https://gc.kis.v2.scr.kaspersky-labs.com/E86634CC-C6D2-2842-928D-C12277901808/main.js"
	charset="UTF-8"></script>
</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->

		<div class="content">
			<!-- Loading home page -->
			<c:if test="${userClickedHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load only when user clicks about -->
			<c:if test="${userClickedAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load only when user clicked contact -->
			<c:if test="${userClickedContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>


			<!-- Load only when user clicked All Products & Category Products -->
			<c:if test="${userClickedAllProducts == true or userClickedCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>

		</div>
		
		
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- jQuery -->
		<script src="${js}/jquery-3.1.1.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- Jquery Data Tables -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- self coded js file -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
