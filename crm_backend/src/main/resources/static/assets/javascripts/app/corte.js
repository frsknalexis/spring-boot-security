$(document).on('ready', function() {
	
	var tablaCortesCable;
	
	var tablaCortesInternet;
	
	redireccionarViewInstalacionesDelDia();
	
	listarCortesCable();
	
	listarCortesInternet();
	
	 realizarCorte();
	 
	 ocultar_mostrar(50);
	 
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
	 *Funcion para redireccionar instalaciones del dia
	 * 
	 */
	function redireccionarViewInstalacionesDelDia() {
		
		$('#buttonInstalacionesDelDia').on('click', function() {
			
			$(location).attr('href', '/instalacion/instalaciones/view');
		});
	}
	
	/**
	 * 
	 *function para listar cortes cable 
	 * 
	 */
	function listarCortesCable() {
		
		tablaCortesCable = $('#tablaCortesCable').dataTable({
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
	 *function para listar Cortes
	 * 
	 */
	function listarCortesInternet() {
		tablaCortesInternet = $('#tablaCortesInternet').dataTable({
			
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
				"url": "/api/v1/corte/corteInternet",
				"dataSrc": ""
			},
			"columns": [
				{"defaultContent": '<button type="button" class="btn btn-danger btn-xs buttonRealizarCorte" codigoServicioInternet><i class="fa fa-check"></i> Realizar Corte</button>'},
				{"data": "codigoServicioInternet"},
				{"data": "documentoPersonaCliente"},
				{"data": "cliente"},
				{"data": "deudaTotal"}
			]
		}).DataTable();
		
		$('#tablaCortesInternet tbody').on('click', 'button', function() {
			
			var data = tablaCortesInternet.row( $(this).parents('tr')).data();
			
			$(this).attr('codigoServicioInternet', data.codigoServicioInternet);
		});
	}
	
	/**
	 * 
	 *function para lanzar el evento realizar corte 
	 * 
	 */
	function realizarCorte() {
		
		$('#tablaCortesInternet tbody').on('click', 'button.buttonRealizarCorte', function() {
			
			var codigoServicioInternet = $(this).attr('codigoServicioInternet');
			
			
			swal({
		        title: '¿Esta Seguro de realizar el Corte a este Cliente ?',
		        text: '¡Si no lo esta puede Cancelar la accion!',
		        type: 'warning',
		        showCancelButton: true,
		        confirmButtonColor: '#3085d6',
		        cancelButtonColor: '#d33',
		        cancelButtonText: 'Cancelar',
		        confirmButtonText: '¡Si, realizar Corte !'
		    }).then((result) => {
		        if(result.value){
		           
		        	$.ajax({
		        		
		        		url: '/api/v1/corte/actualizarServicio/' + codigoServicioInternet,
		        		type: 'GET',
		        		success: function(response){
		        			
		        			console.log(response);
		        			
		        			swal({
		        				type: "success",
		                        title: "El Corte se ha realizado correctamente",
		                        showConfirmButton: true,
		                        confirmButtonText: "Cerrar",
		                        closeOnConfirm: false
		                       }).then((result) => {
		                         if(result.value) {
		                            $(location).attr("href", "/instalacion/cortes/view");
		                        }
		                     })
		                 }
		        	});
		        }
		        else {
		            swal({
		                type: "error",
		                title: "Cancelado", 
		                text: "Usted ha cancelado la acción de Realizar Corte"
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
