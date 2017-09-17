$(document).ready(function() {

	aplicarListeners();
	aplicarListenersBtnSalvar();

});

var limparModal = function(){
	$('#id').val('')
	$('#categoria').val('')
	$('#data').val('')
	$('#valor').val('')
	$('#observacao').val('')
}

var aplicarListenersBtnSalvar = function() {
	
	$('#btn-salvar').on('click', function() {
		var url = 'movimentos';
		var dadosMovimento = $('#form-movimento').serialize();

		$.post(url, dadosMovimento).done(function(pagina) {
			$('#secao-movimentos').html(pagina);
			aplicarListeners();
		})
		.fail(function(e) {
			alert('Erro ao salvar movimento!');
		})
		.always(function() {
			$('#modal-movimento').modal('hide');
		});
	});
	
}

var aplicarListeners = function() {
	
	$('#modal-movimento').on('hide.bs.modal', limparModal);
	
	$('.btn-editar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var url = 'movimentos/' + id
		
		$.get(url)
		.success(function(movimento){
			$('#id').val(movimento.id)
			$('#categoria').val(movimento.categoria)
			$('#data').val(movimento.data)
			$('#valor').val(movimento.valor)
			$('#observacao').val(movimento.observacao)
			
			$('#modal-movimento').modal('show');
		});
	});

	$('.btn-deletar').on('click', function() {
		var id = $(this).parents('tr').data('id');
		var csrf = $('#_csrf').val();
		
			$.ajax({
				url : "movimentos/" + id,
				type : 'DELETE',
				headers: {'X-CSRF-TOKEN': csrf},
				success : function(result) {
				$('tr[data-id="' + id + '"]').remove();
				var movimentos = $('#quantidade-movimentos').text();
				$('#quantidade-movimentos').text(movimentos - 1);
				 }
			});
			
	});
	
}