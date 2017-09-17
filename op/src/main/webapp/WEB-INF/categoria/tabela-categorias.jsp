<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<table
	class="table table-hover table-condensed table-striped table-bordered">
	<thead>
		<tr>
			<td style="width: 80%">Categoria</td>
			<td style="width: 10%">Tipo</td>
			<td style="width: 5%"></td>
			<td style="width: 5%"></td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${categorias}" var="categoria">
			<tr data-id="${categoria.id}">
				<td>${categoria.nome}</td>
				<td>${categoria.tipo}</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>				
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">Categorias cadastradas: <span id="quantidade-categorias">${categorias.size()}</span></td>
		</tr>
		<tr>
			<td colspan="5">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-categoria">Cadastrar Categoria</button>
			</td>
		</tr>
	</tfoot>
</table>