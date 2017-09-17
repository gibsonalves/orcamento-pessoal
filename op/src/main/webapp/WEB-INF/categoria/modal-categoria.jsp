<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modal-categoria" tabindex="-1"
	role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-categoria" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Informações da Categoria</h4>
				</div>
				<div class="modal-body">
					<label for="nome">Nome: </label>
					<input id="nome" name="nome" class="form-control">
					<label for="tipo">Tipo:</label>
					<select id="tipo" name="tipo" class="form-control">
						<c:forEach items="${tipos}" var="tipo">
							<option value="${tipo}">${tipo}</option>
						</c:forEach>
					</select>
					<input id="id" name ="id" type="hidden" />
					<input type="hidden" id="_csrf" name="_csrf" value="${_csrf.token}"></input>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button id="btn-salvar" type="button" class="btn btn-primary">Salvar Informações</button>
				</div>
			</form>
		</div>
	</div>
</div>