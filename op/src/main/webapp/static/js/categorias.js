$(document).ready(function() {

	aplicarListeners();
	aplicarListenersBtnSalvar();

});

var limparModal = function(){
	$('#id').val('')
	$('#nome').val('')
	$('#tipo').val('')
}

var aplicarListenersBtnSalvar = function() {
	
	$('#btn-salvar').on('click', function() {
		var url = 'categorias';
		var dadosCategoria = $('#form-categoria').serialize();

		$.post(url, dadosCategoria).done(function(pagina) {
			$('#secao-categorias').html(pagina);
			aplicarListeners();
		})
		.fail(function(e) {
			alert('Erro ao salvar categoria!');
		})
		.always(function() {
			$('#modal-categoria').modal('hide');
		});
	});
	
}

var aplicarListeners = function() {
	
	$('#modal-categoria').on('hide.bs.modal', limparModal);
	
	$('.btn-editar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var url = 'categorias/' + id
		
		$.get(url)
		.success(function(categoria){
			$('#id').val(categoria.id)
			$('#nome').val(categoria.nome)
			$('#tipo').val(categoria.tipo)
			
			$('#modal-categoria').modal('show');
		});
	});

	$('.btn-deletar').on('click', function() {
		var id = $(this).parents('tr').data('id');
		var csrf = $('#_csrf').val();
		
			$.ajax({
				url : "categorias/" + id,
				type : 'DELETE',
				headers: {'X-CSRF-TOKEN': csrf},
				success : function(result) {
				$('tr[data-id="' + id + '"]').remove();
				var categorias = $('#quantidade-categorias').text();
				$('#quantidade-categorias').text(categorias - 1);
				 }
			});
			
	});
	
}