<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<c:set var="path" value="${pageContext.request.contextPath}" scope="request" />
	<style type="text/css">
		@IMPORT url("${path}/static/bootstrap/css/bootstrap.min.css");
		@IMPORT url("${path}/static/bootstrap/css/bootstrap-theme.min.css");
	</style>
</head>
<body>
	
	<div class="container">
	<section id="secao-categorias">
		<jsp:include page="tabela-movimentos.jsp"></jsp:include>
	</section>
	</div>

	<jsp:include page="modal-movimento.jsp" />

	<script type="text/javascript" src="${path}/static/js/jquery-2.1.3.min.js"></script>
	<script type="text/javascript" src="${path}/static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${path}/static/js/movimentos.js"></script>
</body>
</html>