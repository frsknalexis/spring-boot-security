/**
 * 
 */
$(document).on('ready', function() {
	
	var tablaCuentasInternet;

	tablaListarCuentasInternet();
	
	anularCuenta();

	function tablaListarCuentasInternet() {
		
		tablaCuentasInternet = $('#tablaCuentasInternet').dataTable({
			
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
			"ajax": {
				"url": "/api/v1/detalleCuenta/cuentas",
				"dataSrc": ""
			},
			"columns": [
				{"data": "codigoDetalleCuenta"},
				{"data": "codigoCuenta"},
				{"data": "documentoPersonaCliente"},
				{"data": "cliente"},
				{"data": "direccionActualCliente"},
				{"data": "fechaProgramacionInstalacion"},
				{"defaultContent": '<button type="button" class="btn btn-danger btn-xs btnAnularCuenta" codigoDetalleCuenta><i class="fa fa-times"></i> Anular Cuenta</button>'}
			]
		}).DataTable();
		
		$('#tablaCuentasInternet tbody').on('click', 'button', function() {
			var data = tablaCuentasInternet.row( $(this).parents('tr')).data();
			$(this).attr('codigoDetalleCuenta', data.codigoDetalleCuenta);
		});
	}
	
	function anularCuenta() {
		
		$('#tablaCuentasInternet tbody').on('click', 'button.btnAnularCuenta', function() {
			
			var codigoDetalleCuenta = $(this).attr('codigoDetalleCuenta');
			console.log("codigoDetalleCuenta: " + codigoDetalleCuenta);
			
			swal({
		        title: '¿Esta Seguro de Anular esta Cuenta ?',
		        text: '¡Si no lo esta puede Cancelar la accion!',
		        type: 'warning',
		        showCancelButton: true,
		        confirmButtonColor: '#3085d6',
		        cancelButtonColor: '#d33',
		        cancelButtonText: 'Cancelar',
		        confirmButtonText: '¡Si, Anular!'
		    }).then((result) => {
		        if(result.value){
		           
		        	$.ajax({
		        		
		        		url: '/api/v1/detalleCuenta/anular/' + codigoDetalleCuenta,
		        		type: 'GET',
		        		dataType: 'json',
		        		success: function(response){
		        			
		        			swal({
		        				type: "success",
		                        title: "Se Anulo la Cuenta con exito",
		                        showConfirmButton: true,
		                        confirmButtonText: "Cerrar",
		                        closeOnConfirm: false
		                       }).then((result) => {
		                         if(result.value) {
		                            $(location).attr("href", "/detalleCuenta/cuentas/view");
		                        }
		                     })
		                 }
		        	});
		        }
		        else {
		            swal({
		                type: "error",
		                title: "Cancelado", 
		                text: "Usted ha cancelado la acción de Anular Cuenta"
		            });
		        }
		    });
		});
	}
});



