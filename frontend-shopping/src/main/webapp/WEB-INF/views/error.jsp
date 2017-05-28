<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- specifies the root directory of the project which is frontend-shopping!! -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!-- /resources mapping comes from dispatcher-servlet -->
<spring:url var="css" value="/resources/css" />

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
	
	window.contextRoot = '${contextRoot}';
	
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
		<nav class = "navbar navbar-inverse navbar-fixed-top" role="">
			<div class="container">
				<!-- Brand and Toggle get grouped for better mobile display!! -->
					<div class="navbar-header">
						<a class="navbar-brand" href="${contextRoot}/home">Home</a>
					</div>
			</div>
		</nav>
		
		<div class="content">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class="jumbotron">
							<h1>${errorTitle}</h1>
							<hr/>
							<blockquote style = "word-wrap :break-word">
								${errorDescription}
							</blockquote>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
