<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<c:set var="path" value="${pageContext.request.contextPath}"
	scope="request" />
<style type="text/css">
@IMPORT url("${path}/static/bootstrap/css/bootstrap.min.css");

@IMPORT url("${path}/static/bootstrap/css/bootstrap-theme.min.css");

.btn {
	height: 22px;
	padding: 0px 2px;
}

.topTable {
    font-weight: bold;
    background-color: #eeeeee;
    text-align: center;
}
.itemCategoria {
    font-size: 12px;
    padding: 2px !important;
    text-align: left;
	font-weight: bold;
}
.itemLista {
    font-size: 12px;
    padding: 2px !important;
    text-align: right;
}

</style>
</head>
<body>

	<div class="container">
		<section id="secao-categorias">
			<div>
					${html}
			</div>
		</section>
	</div>

	<script type="text/javascript"
		src="${path}/static/js/jquery-2.1.3.min.js"></script>
	<script type="text/javascript"
		src="${path}/static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${path}/static/js/categorias.js"></script>
</body>
</html>