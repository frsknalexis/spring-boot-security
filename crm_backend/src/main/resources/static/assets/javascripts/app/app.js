$(document).on('ready', function() {
	
	recuperarUsuarioActual(); 
	/**
	 * 
	 * function recuperar usuario actual del sistema
	 * 
	 */
	function recuperarUsuarioActual() {
		
		$.ajax({
			
			type: 'GET',
			url: '/api/v1/usuario/usuarioLogueado',
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$('#nombreUsuario').html(response.username);
			}
		});
	}
});