/**
 * 
 */
$(document).on('ready', function() {
	obtenerDetalleCuentaUsuario(); 
});

function obtenerDetalleCuentaUsuario() {
	
	$.ajax({
		
		type: 'GET',
		url: '/api/v1/usuario/perfilUsuario',
		dataType: 'json',
		success: function(response) {
			console.log(response);
			$('#usuarioPerfil').html(response.nombresUsuario);
			$('#cargoPerfil').html(response.cargoUsuario);
		},
		error: function() {
			swal({
                type: 'warning',
                title: 'Ooops',
                text: 'No se Encontraron Resultados de Busqueda !'
            });
		}
	});
}