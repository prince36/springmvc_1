<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >
	<title>Produkty</title>
</head>
<body>
<jsp:include page="module/navbar.jsp" />
<section>
	<div class="jumbotron">
		<div class="container">
			<h1>Produkty</h1>
			<p>Wszystkie produkty dostępne w naszym sklepie</p>
		</div>
	</div>
</section>

<section class="container">
	<div class="row">
		<c:forEach items="${products}" var="product">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<img src="<c:url value="/resources/images/${product.productId}.png"></c:url>" alt="<c:url value="${product.productId}"></c:url>" style = "width:100%"/>
						<h3>${product.name}</h3>
						<p>${product.description}</p>
						<p>${product.unitPrice} PLN</p>
						<p>Liczba sztuk w magazynie: ${product.unitsInStock}</p>
						<p>
							<a
									href=" <spring:url value="/products/product?id=${product.productId}" /> "
									class="btn btn-primary"> Szczegóły
							</a>
						</p>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</section>

<jsp:include page="module/footer.jsp" />
</body>
</html>
