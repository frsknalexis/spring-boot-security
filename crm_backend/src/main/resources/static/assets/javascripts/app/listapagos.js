$(document).on('ready', function() {
	
	var tablaPagosRealizadosGeneral;
	
	redireccionarViewPagos();
	
	listarPagosRealizados();
	
	mostrarFormRevalidarPago();
	
	cargarComboComprobante();
	
	validarFormRevalidarPago();
	
	guardarRevalidarPago();
	
	/**
	 * 
	 *function para redireccionar a la vista de pagos 
	 * 
	 */
	function redireccionarViewPagos() {
		
		$('#buttonVolverRegistroPago').on('click', function() {
			$(location).attr('href', '/pago/pagos');
		});
	}
	
	/**
	 *
	 * function listar pagos realizados
	 * 
	 */
	function listarPagosRealizados() {
		
		tablaPagosRealizadosGeneral = $('#tablaPagosRealizadosGeneral').dataTable({
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
			"bDestroy": true,
			"ajax": {
				"url": "/api/v1/pago/pagosDelDia",
				"dataSrc": ""
			},
			"columns": [
				{"data": "codigoPago"},
				{"data": "descuento"},
				{"data": "cantidadPago"},
				{"data": "mesValido"},
				{"data": "anioValido"},
				{"data": "cliente"},
				{"data": "direccionActualCliente"},
				{"data": "fechaPagoDia"},
				{"defaultContent": '<button type="button" data-toggle="modal" class="btn btn-primary btn-xs btnRevalidarPago" codigoPago><i class="fa fa-money"></i> Revalidar Pago</button>'}
			]
		}).DataTable();
		
		$('#tablaPagosRealizadosGeneral tbody').on('click', 'button', function() {
			var data = tablaPagosRealizadosGeneral.row( $(this).parents('tr')).data();
			$(this).attr('codigoPago', data.codigoPago);
		});
	}
	
	
	/**
	 * 
	 *function para mostrar el form revalidar Pago 
	 * 
	 */
	function mostrarFormRevalidarPago() {
		
		$('#tablaPagosRealizadosGeneral tbody').on('click', 'button.btnRevalidarPago', function() {
			
			var codigoPago = $(this).attr('codigoPago');
			console.log("codigoPago: " + codigoPago);
			
			$('#modalFormRevalidarPago').modal('show');
			$('#codigoPagoRevalidar').val(codigoPago);
		});
	}
	
	/**
	 *
	 * function para cargarComboComprobante
	 * 
	 */
	function cargarComboComprobante() {
		
		var $codigoComprobante = $('#codigoComprobanteRevalidar');
		
		$.ajax({
			
			type: 'GET',
			url: '/api/v1/comprobante/comprobantes',
			dataType: 'json',
			success: function(response) {
				$codigoComprobante.html('');
				$codigoComprobante.append('<option value="">Seleccione un Comprobante</option>');
				for(var i = 0; i < response.length; i++) {
					$codigoComprobante.append('<option value="' + response[i].codigoComprobante + '">' + response[i].descripcionComprobante + '</option>');
				}
			}
		});
	}
	
	/**
	 * 
	 *function validar form revalidar pago 
	 * 
	 */
	function validarFormRevalidarPago() {
		
		$('#guardarPagoRevalidado').on('click', function(e) {
			e.preventDefault();
			
			if($('#codigoComprobanteRevalidar').val().trim() == "" && $('#cantidadPagoRevalidar').val() == "") {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'Debe llenar algunos los Campos !'
	            });
				return false;
			}
			else {
				if($('#codigoComprobanteRevalidar').val().trim() == "") {
					
					swal({
		                type: 'error',
		                title: 'Ooops',
		                text: 'Debe seleccionar un Tipo de Comprobante !'
		            });
					return false;
				}
				
				if($('#cantidadPagoRevalidar').val() <= 0) {
					
					swal({
		                type: 'error',
		                title: 'Ooops',
		                text: 'Ingrese un valor valido para el Monto a Pagar !'
		            });
					
					$('#cantidadPagoRevalidar').val('');
					$('#cantidadPagoRevalidar').focus();
					return false;
				}
			}
		});
		
		$('#cantidadPagoRevalidar').on('keyup', function() {
			
			var valor = $(this).val();
			
			
			if(parseInt(valor) <= 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'Ingrese un valor valido para el Monto a Pagar'
	            });
				
				$(this).val('');
				$(this).focus();
			}
		});
	}
	
	/**
	 * 
	 *function para guardar revalidar pago 
	 * 
	 */
	function guardarRevalidarPago() {
		
		$('#guardarPagoRevalidado').on('click', function(e) {
			e.preventDefault();
			
			if($('#codigoComprobanteRevalidar').val().trim() != "" && $('#cantidadPagoRevalidar').val() > 0) {
				
				var formData = {
						codigoPago: $('#codigoPagoRevalidar').val(),
						codigoComprobante: $('#codigoComprobanteRevalidar').val(),
						cantidadPago: $('#cantidadPagoRevalidar').val()
				};
				
				console.log(formData);
				
				$.ajax({
					
					type: 'POST',
					url: '/api/v1/pago/consecutivoPago',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					data: JSON.stringify(formData),
					dataType: 'json',
					success: function(response) {
						console.log(response);
						
						if(response.message == "BUENO") {
							
							swal({
								type: "success",
								title: "Se Revalido el Pago con exito",
								showConfirmButton: true,
								confirmButtonText: "Cerrar",
								closeOnConfirm: false
							}).then((result) => {

								if(result.value) {
									$(location).attr('href', '/pago/listaPagos');
								}
							});
						}
						else if(response.message == "SIN PERMISO") {
							
							swal({
				                type: 'error',
				                title: 'Ooops',
				                text: 'No tiene los permisos suficientes para Revalidar este Pago !'
				            });
						}
						else if(response.message == "ERROR") {
							
							swal({
				                type: 'error',
				                title: 'Ooops',
				                text: 'Ocurrio un error al Revalidar Pago !'
				            });
						}
					},
					error: function() {
						
						swal({
			                type: 'error',
			                title: 'Ooops',
			                text: 'Error al Revalidar Pago !'
			            });
					}
				});
			}
		});
	}
});