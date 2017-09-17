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
			<td style="width: 20%">Categoria</td>
			<td style="width: 15%">Data</td>
			<td style="width: 15%">Valor</td>
			<td style="width: 30%">Observação</td>
			<td style="width: 10%"></td>
			<td style="width: 10%"></td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${movimentos}" var="movimento">
			<tr data-id="${movimento.id}">
				<td>${movimento.categoria.nome}</td>
				<td><fmt:formatDate value="${movimento.data.time}" pattern="dd/MM/yyyy"/></td>
				<td>${movimento.valor}</td>
				<td>${movimento.observacao}</td>				
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>				
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">Movimentos cadastrados: <span id="quantidade-movimentos">${movimentos.size()}</span></td>
		</tr>
		<tr>
			<td colspan="6">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-movimento">Cadastrar Movimento</button>
			</td>
		</tr>
	</tfoot>
</table>