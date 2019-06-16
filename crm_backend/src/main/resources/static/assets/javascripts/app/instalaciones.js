$(document).on('ready', function() {
	
	var cont = 0;
	
	setTimeout(function() {
		mostrarFormMateriales(false);
	}, 1000);
	
	agregarMaterialForm();
	
	cargarComboMateriales();
	
	limpiarInputsModalFormMateriales();
	
	agregarMaterialToTabla();
	
	eliminarFilaDeTabla();
	
	cancelarAccionFormMaterialesDetalle();
	
	var tablaInstalacionesDiaCable;
	
	var tablaInstalacionesDiaInternet;
		
	cargarComboResponsable();
	
	redireccionarCortesView();
	
	listarInstalacionDiaCable();
	
	listarInstalacionDiaInternet();
	
	ocultar_mostrar(20);
	
	asignartecnico();
	
	window.setInterval(
		    function(){
		    // Sección de código para modificar el DIV
		    // $("#miDiv").text(variable);
		    	$('#total').load(cargarTotalRegistrosPersona());
		    	evaluando();
		    // Ejemplo: Cada dos segundos se imprime la hora
		   
		  }
		  // Intervalo de tiempo
		,5000);
	
	/**
	 * 
	 *function para redireccionar a la vista de cortes
	 * 
	 */
	function ocultar_mostrar(id){
		
		if(id !== 0){
			
			
			for( var i = 1;i < id ; i++ ){
			if(i < id){
				
				$.ajax({
					
					type: 'GET',
					url: '/api/v1/usuario/listamodulos/' + i,
					dataType: 'json',
					success: function(response) {
							console.log(response);
							
							var descrip = response.descripcionmodulo;
							
							document.getElementById(descrip).style.display = 'block';
						}
					});
				}
			}
		}
	
	}
	
	/**
	 * 
	 * 
	 *@function mostrar formMateriales 
	 * 
	 */
	function mostrarFormMateriales(flag) {
		
		if(flag) {
			$('#listadoInstalaciones').hide();
			$('#formMateriales').show();
		}
		else {
			$('#listadoInstalaciones').show();
			$('#formMateriales').hide();
		}
	}
	
	function redireccionarCortesView() {
		
		$('#buttonCortes').on('click', function() {
			$(location).attr('href', '/instalacion/cortes/view');
		});
	}
	
	/**
	 * 
	 * function para listar instalaciones dia cable
	 * 
	 */
	function listarInstalacionDiaCable() {
		tablaInstalacionesDiaCable = $('#tablaInstalacionesDiaCable').dataTable({
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
			"bDestroy": true
		}).DataTable();
	}
	
	/**
	 * 
	 *function para listar instalaciones del dia internet 
	 * 
	 */
	function listarInstalacionDiaInternet() {
		
		tablaInstalacionesDiaInternet = $('#tablaInstalacionesDiaInternet').dataTable({
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
				"url": "/api/v1/instalacion/instalacionesDiaInternet",
				"dataSrc": ""
			},
			"columns": [
				{"data": "codigoDetalleCuenta"},
				{"data": "documentoPersonaCliente"},
				{"data": "cliente"},
				{"data": "direccionActualCliente"},
				{"data": "referenciaDireccion"},
				{"data": "telefonoCliente"},
				{"defaultContent": '<button type="button" class="btn btn-success btn-xs btntecnicoinsta" codigoDetalleCuenta><i class="fa fa-hand-o-up "></i> Asignar Técnico</button>'},
				{"defaultContent": '<button type="button" class="btn btn-success btn-xs btnMostrarFormMateriales" codigoDetalleCuenta documentoPersonaCliente clienteCuenta direccionCliente><i class="fa fa-plus-square"></i> Agregar Materiales</button>'}
			]
		}).DataTable();
		
		$('#tablaInstalacionesDiaInternet tbody').on('click', 'button', function(){
			
			var data = tablaInstalacionesDiaInternet.row( $(this).parents('tr')).data();
			console.log(data);
			$(this).attr('codigoDetalleCuenta', data.codigoDetalleCuenta);
			$(this).attr('documentoPersonaCliente', data.documentoPersonaCliente);
			$(this).attr('clienteCuenta', data.cliente);
			$(this).attr('direccionCliente', data.direccionActualCliente);
			
		});
		
		$('#tablaInstalacionesDiaInternet tbody').on('click', 'button.btntecnicoinsta', function(){
			var codigoDetalleCuentaValue = $(this).attr('codigoDetalleCuenta');
			
			$('#codigore').attr('disabled', true);
			$('#codigore').val(codigoDetalleCuentaValue);
			
			$('#modalFormTecnicoagregar').modal('show');
			
		});
		
		mostrarFormDetalleMateriales();
		
	}
	
	/**
	 * 
	 * 
	 *cancelar accion form materiales detalle 
	 * 
	 */
	function cancelarAccionFormMaterialesDetalle() {
		
		$('#cancelarAccion').on('click', function() {
			mostrarFormMateriales(false);
		});
	}
	
	/**
	 * 
	 * 
	 *function para cargar el combo materiales
	 * 
	 */
	function cargarComboMateriales() {
		
		var $nombreMaterial = $('#nombreMaterial');
		
		$.ajax({
			
			type: 'GET',
			url: '/api/v1/material/materiales',
			dataType: 'json',
			success: function(response) {
				console.log(response);
				$nombreMaterial.html('');
				$nombreMaterial.append('<option value="">Seleccione un Material</option>');
				for(var  i = 0; i < response.length; i++) {
					$nombreMaterial.append('<option value="' + response[i].descripcion + '">' + response[i].descripcion + '</option>');
				}
			}
		});
	}

	
	/**
	 *function agregarFilaToTabla 
	 * 
	 */
	function agregarFilaToTabla(data) {
		cont++;
		var fila = '<tr id="fila' + cont + '"><td>' + cont +'</td><td class="text-center">' + data.nombre +'</td><td class="text-center">' + data.cantidad + '</td><td><button type="button" class="btn btn-danger btn-sm btnEliminarFila" cont="' + cont +'"><i class="fa fa-times"><i></button></td></tr>';
		$('#contenidoMateriales').append(fila);
		reordenarNumeracionTabla();
	}
	
	/**
	 * 
	 *function para eliminar la fila de la tabla 
	 */
	function eliminarFilaDeTabla() {
		
		$('#tablaMateriales tbody').on('click', 'button.btnEliminarFila', function() {
			var cont = $(this).attr('cont');
			$("#fila" + cont).remove();
			reordenarNumeracionTabla();
		});
	}
	
	/**
	 *
	 * function reordenar numeracion tabla
	 * 
	 */
	function reordenarNumeracionTabla() {
		var num = 1;
		$('#tablaMateriales tbody tr').each(function() {
			$(this).find('td').eq(0).text(num);
			num++;
		});
	}
	
	/**
	 * 
	 *function para limpiar inputs del modal 
	 * 
	 */
	function limpiarInputsModalFormMateriales() {
		
		$('#cancelarModal').on('click', function() {
			$('#nombreMaterial').val('');
			$('#cantidadMaterial').val(1);
		});
	}
	
	/**
	 * 
	 *function para agregar material a la tabla 
	 * 
	 */
	function agregarMaterialToTabla() {
		
		$('#agregarMaterialToTabla').on('click', function(e) {
			e.preventDefault();
			
			if($('#nombreMaterial').val().trim() != "" && $('#cantidadMaterial').val() > 0) {
							
				var data = {
					nombre: $('#nombreMaterial').val(), 
					cantidad: $('#cantidadMaterial').val()
				};
				
				console.log(data);
				 agregarFilaToTabla(data);
				 $('#cantidadMaterial').val(1);
			}
			
			if($('#nombreMaterial').val().trim() == "" && $('#cantidadMaterial').val() == "") {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'Debe llenar algunos los Campos !'
	            });
				return false;
			}
			
			else {
				
				if($('#nombreMaterial').val().trim() == "") {
					
					swal({
		                type: 'error',
		                title: 'Ooops',
		                text: 'Debe Seleccionar un Material !'
		            });
					return false;
				}
				
				if($('#cantidadMaterial').val() <= 0) {
					
					swal({
		                type: 'error',
		                title: 'Ooops',
		                text: 'Ingrese un valor valido para la Cantidad de Material !'
		            });
					
					$('#cantidadMaterial').val('');
					$('#cantidadMaterial').focus();
					return false
				}
			}
		});
		
		$('#cantidadMaterial').on('keyup', function() {
			
			var valor = $(this).val();
			
			
			if(parseInt(valor) <= 0) {
				
				swal({
	                type: 'error',
	                title: 'Ooops',
	                text: 'Ingrese un valor valido para la Cantidad de Material'
	            });
				
				$(this).val('');
				$(this).focus();
			}
		});
	}
	
	/**
	 * 
	 *function agregar material 
	 * 
	 */
	function agregarMaterialForm() {
		
		$('#agregarMaterialForm').on('click', function() {
			$('#modalFormAgregarMaterial').modal('show');
		});
	}
	
	/**
	 * 
	 *@function para mostrar form materiales detalle 
	 * 
	 */
	function mostrarFormDetalleMateriales() {
		
		$('#tablaInstalacionesDiaInternet tbody').on('click', 'button.btnMostrarFormMateriales', function(){
			
			var codigoDetalleCuenta = $(this).attr('codigoDetalleCuenta');
			var documentoPersonaCliente = $(this).attr('documentoPersonaCliente');
			var clienteCuenta = $(this).attr('clienteCuenta');
			var direccionCliente = $(this).attr('direccionCliente');
			
			console.log("codigoDetalleCuenta: " + codigoDetalleCuenta);
			
			mostrarFormMateriales(true);
			$('#codigoCuentaDetalle').attr('disabled', true);
			$('#documentoPersonaClienteDetalle').attr('disabled', true);
			$('#clienteDetalle').attr('disabled', true);
			$('#direccionClienteDetalle').attr('disabled', true);
			
			$('#codigoCuentaDetalle').val(codigoDetalleCuenta);
			$('#documentoPersonaClienteDetalle').val(documentoPersonaCliente);
			$('#clienteDetalle').val(clienteCuenta);
			$('#direccionClienteDetalle').val(direccionCliente);
		});
	}
	
	function cargarComboResponsable() {
		
		var personaencargada = $('#personaencargada');

		$.ajax({

			type: 'GET',
			url: '/api/v1/atencion/comboempleado/0',
			dataType: 'json',
			success: function(response) {
				
				personaencargada.html('');
				personaencargada.append('<option value="">Seleccione un Responsable para la Instalación</option>');
				for(var i = 0; i < response.length; i++) {
					personaencargada.append('<option value="' + response[i].tecnicoescogigo + '">' + response[i].tecnicoescogigo + '</option>');
				}
			}
		});
	}
	
	function asignartecnico() {
		$('#asignartecnico').on('click', function(e) {
			e.preventDefault();
				
				var codigoreclamoes =  $('#codigore').val();
				var personaencargadas = codigoreclamoes + 'p' + $('#personaencargada').val();
				var tecnicoescogioes = $('#personaencargada').val();
				

				e.preventDefault();
					
					var formData = {
							
							datovaluar: $('#personaencargada').val(),
							codigo: $('#codigore').val(),
							descripciontarea:  $('#desc').val()
					};
					
					
					
					$.ajax({
						
						type: 'POST',
						url: '/api/v1/atencion/updatetecnicoinsta',
						headers: {
							"Content-Type": "application/json",
							"Accept": "application/json"
						},
						data: JSON.stringify(formData),
						dataType: 'json',
						success: function(response) {
						
							
							swal({
								type: "success",
								title: "Se asigno con exito al Sr: " + tecnicoescogioes + " como responsable de la instalación",
								showConfirmButton: true,
								confirmButtonText: "Cerrar",
								closeOnConfirm: false
							}).then((result) => {

								if(result.value) {
									$(location).attr('href', '/instalacion/instalaciones/view');
								}
							});
						},
						error: function() {
							swal({
				                type: 'error',
				                title: 'Ooops',
				                text: 'Error al Registrar Responsable Instalación !'
				            });
						}
					});
		});
			
	}
	
	function cargarmensajespopusnuevo(valor,id){
		
		
		
		var title = "Tareas Pendientes!!!";
		
		var position = "Bottom right";
		var duration = "1000";
		var theme = "warning";
		var closeOnClick = true;
		var displayClose =true;
		
		
		if(valor !== 0)
		{
			
			for(var i = 0;id > i;i++)
			{			
				if(id > i){
					$.ajax(
							{
								
								type: 'GET',
								url: '/api/v1/atencion/searchMensaje/' + (parseInt(valor) + parseInt(i)),
								dataType: 'json',
								success: function(response) {
									
									var mensaje = response.descripcionmensaje;
									var message = mensaje;
							
									
									
									window.createNotification({
										closeOnClick: closeOnClick,
										displayCloseButton: displayClose,
										positionClass: position,
										showDuration: duration,
										theme: theme
									})({
								title: title,
								message: message
							});
							
						}
					});
				}
			}
			
		}
	}

	function cargarmensajespopus(id){
		
		
		
		var title = "Tareas Pendientes!!!";
		
		var position = "Bottom right";
		var duration = "1000";
		var theme = "warning";
		var closeOnClick = true;
		var displayClose =true;
		
		if(id === 0)
		{
			
		}else{
			
			for(var i=1;i <= id;i++)
			{			
				if(i <= id){
					$.ajax(
							{
						
								type: 'GET',
								url: '/api/v1/atencion/searchMensaje/' + i,
								dataType: 'json',
								success: function(response) {
									
									var mensaje = response.descripcionmensaje;
									var message = mensaje;
							
									
									window.createNotification({
										closeOnClick: closeOnClick,
										displayCloseButton: displayClose,
										positionClass: position,
										showDuration: duration,
										theme: theme
									})({
								title: title,
								message: message
							});
							
						}
					});
				}
			}
			
		}
	}
	
	function estado(id){
		
		
		if(id !== 0){
			
			
			for(var i=1;i<=id;i++){
			if(i <= id){
				
				$.ajax({
					
					type: 'GET',
					url: '/api/v1/atencion/searchMensaje/' + i,
					dataType: 'json',
					success: function(response) {
						
						
						var tag = document.createElement("li");
						tag.innerHTML = '<span class="toggle">Jan</span>';
						
						var mensaje = response.nombrepersona;
						var respuesta = response.descripcionmensaje;
						var listNode = document.getElementById('agregarmensajesnoti');
						var liNode = document.createElement('li');
						var txtNode = document.createTextNode(mensaje);
						
						liNode.innerHTML = '<a href="#" class="clearfix"><figure class="image"><img src="http://clipart-library.com/images/8i6oer5KT.png" wight="40" height="40" alt="Joseph Junior" class="img-circle" /></figure><span class="title">' + String(mensaje) + '</span><span class="mensage">' + String(respuesta) + '</span></a>';
						listNode.appendChild(liNode);
						}
					});
				}
			}
		}
	}
	
	function estadonuevo(valor){
		
		
		if(valor !== 0){
			
			document.getElementById("agregarmensajesnoti").innerHTML="";
			for(var i=0;i<valor;i++){
			if(i < valor && (parseInt(valor) - parseInt(i)) >-1){
				
				$.ajax({
					
					type: 'GET',
					url: '/api/v1/atencion/searchMensaje/' + (parseInt(valor) - parseInt(i)),
					dataType: 'json',
					success: function(response) {
						
						
						var tag = document.createElement("li");
						tag.innerHTML = '<span class="toggle">Jan</span>';
						
						var mensaje = response.nombrepersona;
						var respuesta = response.descripcionmensaje;
						var listNode = document.getElementById('agregarmensajesnoti');
						var liNode = document.createElement('li');
						var txtNode = document.createTextNode(mensaje);
						
						liNode.innerHTML = '<a href="#" class="clearfix"><figure class="image"><img src="http://clipart-library.com/images/8i6oer5KT.png" wight="40" height="40" alt="Joseph Junior" class="img-circle" /></figure><span class="title">' + String(mensaje) + '</span><span class="mensage">' + String(respuesta) + '</span></a>';
						listNode.appendChild(liNode);
						}
					});
				}
			}
		}
	}
	
	function evaluando(){
		
		var estatico = null;
		var dinamico = null;
		var valuee = null;
		
		estatico = document.getElementsByName("canje")[0].value;
		dinamico = document.getElementsByName("canjes")[0].value;
		valuee = document.getElementsByName("canjess")[0].value;
		
		
		var verificando = valuee - dinamico;
		
		if(estatico === valuee && valuee === dinamico){
		
			estado(valuee);
			cargarmensajespopus(valuee);
			$('#canje').val("0");
		}
		if(verificando === 0){
		
			estado(verificando);
			cargarmensajespopus(verificando);
			$('#canje').val("0");
		}
		if(verificando !== 0){
		
			estadonuevo(parseInt(valuee));
			
			cargarmensajespopusnuevo(parseInt(dinamico) + 1,parseInt(verificando));
		
			$('#canje').val("0");
			$('#canjes').val(valuee);
		}
	}
	
	function cargarTotalRegistrosPersona() {
		
		
		var formData = {
				
		};
		
		$.ajax({
			
			type: 'POST',
			url: '/api/v1/atencion/obtenercantidad',
			headers: {
				"Content-Type": "application/json",
				"Accept": "application/json"
			},
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function(response) {
				
				$('#total').html(response.message);
				$('#totalidad').html(response.message);
				$('#canjess').val(response.message);
			}
			
		});	
		
	}
	
	
	function cargarTotalRegistrosPersonita() {
		
		
		var formData = {
				
		};
		
		$.ajax({
			
			type: 'POST',
			url: '/api/v1/atencion/obtenercantidad',
			headers: {
				"Content-Type": "application/json",
				"Accept": "application/json"
			},
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function(response) {
				
				$('#total').html(response.message);
				$('#totalidad').html(response.message);
				$('#canje').val(response.message);
				$('#canjes').val(response.message);
				$('#canjess').val(response.message);
			}
			
		});	
		
	}
});
