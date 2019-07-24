/**
 * 
 */
$(document).on('ready', function() {
	
	var tablaEstadoCuentasInternet;
	
	listarTablaEstadoCuentasInternet();
	
	regresarListadoCuentas();
});

function listarTablaEstadoCuentasInternet() {
	
	tablaEstadoCuentasInternet = $('#tablaEstadoCuentasInternet').dataTable({
		"language": {
			"sProcessing":     "Procesando...",
			"sLengthMenu":     "Mostrar _MENU_ registros",
			"sZeroRecords":    "No se encontraron resultados",
			"sEmptyTable":     "Ningún dato disponible en esta tabla",
			"sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
			"sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
			"sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
			"sInfoPostFix":    "",
			"sSearch":         "Buscar:",
			"sUrl":            "",
			"sInfoThousands":  ",",
			"sLoadingRecords": "Cargando...",
			"oPaginate": {
				"sFirst":    "Primero",
				"sLast":     "Último",
				"sNext":     "Siguiente",
				"sPrevious": "Anterior"
			},
			"oAria": {
				"sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
				"sSortDescending": ": Activar para ordenar la columna de manera descendente"
			}
		},
		'bProcessing': true,
		"bDestroy": true,
		"ajax": {
			"url": "/api/v1/detalleCuenta/estadoCuentas",
			"dataSrc": ""
		},
		"columns": [
			{"data": "codigoDetalleCuenta"},
			{"data": "codigoCuenta"},
			{"data": "cliente"},
			{"data": "documentoPersonaCliente"},
			{"data": "direccionCliente"},
			{"data": "estado"}
		]
	}).DataTable();
}

function regresarListadoCuentas() {
	
	$('#btnRegresarListaCuentas').on('click', function() {
		$(location).attr('href', '/detalleCuenta/cuentas/view');
	});
}