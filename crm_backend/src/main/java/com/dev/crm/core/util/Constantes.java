package com.dev.crm.core.util;

public class Constantes {

	public static final String DASHBOARD_VIEW = "dashboard";
	public static final String DASHBOARD_VIEW2 = "dashboard2";
	public static final String USUARIO_VIEW = "modulo-personas/usuario/usuario";
	public static final String PROFILE_USER_VIEW = "modulo-personas/usuario/perfilusuario";
	public static final String PERSONA_VIEW = "modulo-personas/persona/persona";
	public static final String EMPLEADO_VIEW = "modulo-personas/empleado/empleado";
	public static final String DETALLE_CUENTA_VIEW = "modulo-servicios/detallecuenta/detallecuenta";
	public static final String CUENTAS_VIEW = "modulo-servicios/detallecuenta/cuentas";
	public static final String ESTADO_CUENTAS_VIEW = "modulo-servicios/detallecuenta/estadocuentas";
	public static final String REPROGRAMACION_VIEW = "modulo-servicios/detallecuenta/reprogramacion";
	public static final String PAGOS_VIEW = "modulo-pagos/pagos/pago";
	public static final String ATENCION_VIEW = "modulo-atencion/herramienta/herramienta";
	public static final String HERRAMIENTAS_VIEW = "modulo-atencion/herramientas/herramientas";
	public static final String RECLAMO_VIEW= "modulo-atencion/reclamo/view";
	public static final String RECLAMOS_VIEW= "modulo-atencion/herramienta/index";
	public static final String TAREA_VIEW= "modulo-notificacion/tarea/view";
	public static final String CORTE_VIEW = "modulo-servicios/instalacion/cortes";
	public static final String INSTALACIONES_VIEW = "modulo-servicios/instalacion/instalaciones";
	public static final String ACTIVACIONES_VIEW = "modulo-servicios/instalacion/activaciones";
	public static final String INFORME_INSTALACION_VIEW = "modulo-servicios/instalacion/informeinstalaciones";
	public static final String INSTALACIONES_TECNICO_VIEW = "modulo-servicios/instalacion/instalacionesTecnico";
	public static final String LISTA_PAGOS_VIEW = "modulo-pagos/pagos/listapagos";
	public static final String CLIENTE_GESTORES_VIEW = "modulo-pagos/gestores/clientegestores";
	public static final String PAGO_GESTORES_VIEW = "modulo-pagos/gestores/pagogestores";
	public static final String LOGIN_VIEW = "login";
	public static final String ADMINISTRACION_PAGOS_VIEW = "modulo-administracion/pagos";
	public static final String ADMINISTRACION_REPORTES_VIEW = "modulo-administracion/reportes";
	public static final String ADMINISTRACION_REPORTES_VENTAS_VIEW = "modulo-administracion/reportesventas";
	
	public static final String SP_ACTIVAR_DESACTIVAR_CLIENTE = "sp_activar_desactivar";
	public static final String SP_LISTA_PERSONA_NO_EMPLEADO = "sp_lista_persona_no_empleado";
	public static final String SP_INSERCION_EMPLEADO = "sp_insercion_empleado";
	public static final String SP_ACTUALIZAR_EMPLEADO = "sp_actualizar_empleado";
	public static final String SP_ACT_DES_EMPLEADO = "sp_act_des_empleado";
	public static final String SP_LISTAR_PERSONA_EMPLEADO= "sp_listar_persona_empleado";
	public static final String SP_LISTAR_EMPLEADOS_INT_EXT = "sp_listar_empleados_int_ext";
	public static final String SP_BUSCAR_PERSONA_CLIENTE_VENDEDOR = "sp_buscar_persona_cliente_vendedor";
	public static final String SP_INSERCION_CUENTA_INTERNET = "sp_insercion_cuenta_internet";
	public static final String SP_INSERCION_CUENTA_CABLE ="sp_insercion_cuenta_cable";
	public static final String SP_REPROGRAMAR_INSTALACION_CABLE = "sp_reprogramar_insta_cable";
	public static final String SP_REPROGRAMAR_INSTALACION_INTERNET = "sp_reprogramar_insta_internet";
	public static final String SP_REVALIDANDO_FECHA_CABLE = "sp_revalidando_fecha_cable";
	public static final String SP_REVALIDANDO_FECHA_INTERNET = "sp_revalidando_fecha_internet";
	public static final String SP_CONTADOR_PENDIENTES_CABLE = "sp_contador_pendientes_cable";
	public static final String SP_CONTADOR_PENDIENTES_INTERNET = "sp_contador_pendientes_internet";
	public static final String SP_PAGO_SERVICIO = "sp_pago_servicio";
	public static final String SP_LISTAR_CLIENTE_VENDEDOR = "sp_listar_cliente_vendedor";
	public static final String SP_BUSCAR_CLIENTE_PAGO = "sp_buscar_cliente_pago";
	public static final String SP_BUSCAR_DATOS_ONU_INSTALACION = "sp_recuperar_datos_ins_onu";
	public static final String SP_RECUPERAR_MES_DEUDA = "recuperar_mes_monto_nombreout";
	public static final String SP_BUSCAR_DATOS_PAGOS_MES = "a";
	public static final String SP_LISTAR_COMPROBANTE = "sp_listar_comprobante";
	public static final String SP_MESES_DEUDAS = "sp_meses_deudas";
	public static final String SP_PAGO_MORA = "sp_insercion_pago_mora";
	public static final String SP_AGREGAR_PERSONA = "sp_inserccion_persona_ci";
	public static final String SP_LISTAR_CLIENTES_ATENCION = "sp_listar_clientes_atencion";
	public static final String SP_LISTAR_DATOS_GENERALES_CLIENTE = "sp_listar_datos_generales_cliente";
	public static final String SP_LISTAR_CLIENTES_ATENCION_DETALLE = "sp_listar_clientes_atencion_detalle";
	public static final String SP_LISTAR_HERRAMIENTA_GENERAL = "sp_listar_herramienta_general";
	public static final String SP_INSERCCION_HERRAMIENTA = "sp_inserccion_herramienta";
	public static final String SP_INSERCCION_ACTIVACION = "sp_ins_act_cuenta";
	public static final String SP_GUARDAR_DESCUENTO_MES= "sp_inserccion_historial_descuento";
	public static final String SP_INSERCCION_DETALLE_HERRAMIENTA = "sp_inserccion_detalle_herramienta";
	public static final String SP_BUSQUEDA_HERRAMIENTA = "sp_envio_herramienta";
	public static final String SP_LISTAR_PREGUNTAS = "sp_listar_detalle_herramienta";
	public static final String SP_LISTAR_DATOS_GENERAL_HERRAMIENTA = "sp_listar_datos_herramienta";
	public static final String SP_EDITAR_HERRAMIENTA = "sp_update_herramienta";
	public static final String SP_EDITAR_PREGUNTA = "sp_update_pregunta";
	public static final String SP_GUARDAR_RECLAMO = "sp_inserccion_reclamo";
	public static final String SP_LISTAR_EMPLEADO_GENERAL_EXT_INT = "sp_listar_empleados_int_ext";
	public static final String SP_ESTADO_PLANTA = "sp_ubicacion_empleado_planta";
	public static final String SP_EDITAR_TAREA = "sp_update_tarea";
	public static final String SP_EDITAR_PERSONA = "sp_update_persona";
	public static final String SP_LISTAR_COMBO_TECNICO = "sp_combo_asignar_tecnico";
	public static final String SP_LISTA_PLANILLA = "sp_listar_pagos_pdf_dia";
	public static final String SP_LISTAR_RECLAMO = "sp_listar_Reclamo";
	public static final String SP_LISTA_MODULO = "sp_listar_modulos_usuario";
	public static final String SP_LISTAR_TAREA = "sp_listar_tarea";
	public static final String SP_EDITAR_RECLAMO_TECNICO = "sp_update_reclamo_tecnico";
	public static final String SP_EDITAR_INSTALACION_TECNICO = "sp_update_insta_in_tecnico";
	public static final String SP_CANTIDAD_TAREA = "sp_noti_tarea";
	public static final String SP_RECUPERAR_MENSAJE_NOTI = "sp_recuperar_noti_mensajes";
	public static final String SP_DATOS_ONUS = "sp_recuperar_datos_onu";
	public static final String SP_LISTAR_CORTE_INTERNET = "sp_listar_corte";
	public static final String SP_UPDATE_SERVICIO_INTERNET = "sp_update_servicio_internet";
	public static final String SP_LISTAR_INSTALACION_DIA_INTERNET = "sp_listar_instalacion_dia";
	public static final String SP_LISTAR_PAGOS_DEL_DIA = "sp_listar_pagos_del_dia";
	public static final String SP_INSERTAR_CONSECUTIVO_PAGO = "sp_insertar_consecutivo_pago";
	public static final String SP_LISTAR_DETALLE_PAGO = "sp_recuperar_pagos_cliente";
	public static final String SP_GENERAR_RECIBO = "sp_generar_recibo";
	public static final String SP_LISTAR_PAGOS_POR_CAJA_REPORTE = "sp_listar_excel_pdf_pagos_por_caja";
	public static final String SP_LISTAR_PAGOS_PDF_DIA= "sp_listar_pagos_pdf_dia";
	public static final String SP_LISTAR_PAGOS_PDF_RANGO = "sp_listar_pagos_pdf_rango";
	public static final String SP_RECUPERAR_DATOS_EDIT_CLIENTE = "sp_recuperar_datos_edit_cliente";
	public static final String SP_UPDATE_PERSONA_CLIENTE= "sp_update_persona_cliente";
	public static final String SP_CAMBIO_DOMICILIO = "sp_cambios_datos_por_domicilio";
	public static final String SP_LISTAR_PDF_CLIENTE = "sp_listar_pdf_cliente";
	public static final String SP_LISTAR_MATERIAL = "sp_listar_material";
	public static final String SP_ENVIO_DATOS_IN_SERVICIO = "sp_envio_datos_in_servicio";
	public static final String SP_ENVIO_DATOS_ONU = "sp_envio_datos_onu";
	public static final String SP_ENVIO_DATOS_MATERIAL = "sp_envio_datos_material";
	public static final String SP_LISTAR_VENTAS_POR_INSTALAR = "sp_listar_ventas_por_instalar";
	public static final String SP_LISTAR_CUENTA_POR_INSTALAR = "sp_listar_cuenta_por_instalar";
	public static final String SP_UPDATE_DETALLE_CUENTA = "sp_update_detalle_cuenta";
	public static final String SP_RECUPERAR_OBSERVACION = "sp_recuperar_obser";
	public static final String SP_LISTAR_INFORME_INSTALACION_DIA = "sp_listar_informe_instalacion_dia";
	public static final String SP_LISTAR_CLIENTE_GESTOR = "sp_listar_cliente_gestor";
	public static final String SP_UPDATE_CLIENTE_GESTOR = "sp_update_cliente_gestor";
	public static final String SP_LISTA_GESTORES = "sp_lista_gestores";
	public static final String SP_INSERTAR_MESES_ADELANTADOS = "sp_insertar_meses_adelantados";
	public static final String SP_LISTAR_VENDEDORES = "sp_listar_vendedores";
	public static final String SP_LISTAR_CUENTAS_DIA_SOLICITADO = "sp_listar_cuentas_dia_solicitado";
	public static final String SP_LISTAR_CUENTAS_RANGO_SOLICITADO = "sp_listar_cuentas_rango_solicitado";
	public static final String SP_LISTAR_PAGOS_DIA_SOLICITADO = "sp_listar_pagos_pdf_dia_solicitado";
	public static final String RECUPERAR_DIAS_DEUDAS = "recuperar_dias_deudas";
	public static final String RECUPERAR_DIAS_DEUDAS_PARAMETRIZADO = "recuperar_dias_deudas_parametrizado";
	public static final String SP_GENERAR_LIQUIDACION_MATERIAL = "sp_generar_liquidacion_material";
	public static final String SP_LISTAR_INSTALACIONES_POR_TECNICO = "sp_listar_lista_insta_x_tecnico";
	public static final String SP_PERFIL_USUARIO = "sp_mi_perfil";
	public static final String SP_UPDATE_USUARIO_PERFIL = "update_mi_perfil_contrasena";
	public static final String SP_LISTAR_ESTADO_CUENTA = "sp_listar_estado_cuenta";
	public static final String SP_LISTA_PAGO_POR_MES = "sp_lista_pago_x_mes";
	public static final String SP_LISTAR_ESTADO_CUENTA_POR_ESTADO = "sp_listar_estado_cuenta_x_estado";
	public static final String SP_LISTAR_ESTADO = "sp_listar_estado";
	public static final String SP_CUENTAS_POR_VENDEDOR = "sp_pdf_lista_x_vendedor";
	public static final String SP_LISTA_PAGOS_POR_MES_CAJA1 = "sp_lista_pago_x_mes_c1";
	public static final String SP_LISTA_PAGOS_POR_MES_CAJA2 = "sp_lista_pago_x_mes_c2";
	public static final String SP_LISTA_PAGOS_POR_MES_CAJA3 = "sp_lista_pago_x_mes_c3";
	public static final String SP_CONTADOR_GANANCIA_POR_MES_CAJA = "sp_contador_ganancia_mes";
	public static final String SP_CONTADOR_CANTIDAD_VENTAS_POR_DIA = "sp_contador_ventas";
	public static final String SP_CONTADOR_VENTAS_POR_VENDEDOR = "sp_contador_ventasx_vendedor";
	public static final String SP_CONTADOR_INSTALACIONES_REALIZADAS = "sp_contador_instalacion";
	public static final String SP_LISTAR_REPORTE_ACTIVACIONES = "sp_listar_reporte_ac_ins";
	public static final String SP_LISTAR_CUENTAS_INSTALADAS_RANGO_FECHA = "sp_listar_cuentas_rango_solicitado_instalado";
	public static final String SP_RECUPERAR_DEUDAS_POR_GESTOR = "recuperar_dias_deudas_gestor";
	public static final String RECUPERAR_CODIGO_CONSECUTIVO_CLIENTE = "recuperar_codigo_consecutivo";
	public static final String SP_LISTAR_ACTIVACIONES_POR_DIA = "sp_listar_reporte_ac_ins_dia";
	public static final String SP_LISTAR_ACTIVACIONES_POR_RANGO = "sp_listar_reporte_ac_ins_rango";
	public static final String SP_CONTADOR_GANANCIA_POR_DIA_CAJA = "sp_contador_ganancia_dia";
	public static final String SP_LISTAR_SEXO = "sp_listar_sexo";
	public static final String SP_LISTAR_UBIGEO = "sp_listar_ubigeo";
	public static final String SP_INSERCCION_CLIENTE = "sp_inserccion_cliente";
	public static final String SP_PAGO_SERVICIO_GESTOR = "sp_pago_servicio_gestor";
	public static final String SP_LISTAR_CONSOLIDADO_INTERNET = "sp_listar_consolidado_internet";
	public static final String SP_RECUPERAR_DIAS_DEUDAS_GESTOR_MONTO_ACUMULADO = "recuperar_dias_deudas_gestor_monto_acumulado";
	
	public static final boolean HABILITADO = true;
	public static final boolean INHABILITADO = false;
	public static final String EMPTY = "";
	
	public static final String CREATED_STATUS = "CREATED";
	public static final String UPDATED_STATUS  = "UPDATED";
	public static final String ERROR_STATUS = "ERROR";
	public static final String SUCCESS_STATUS = "SUCCESS";
	
	public static final String MESSAGE_CREATED = "Se Registro Correctamente";
	public static final String MESSAGE_UPDATED = "Se Actualizo Correctamente";
	public static final String MESSAGE_ERROR = "Ocurrio un Error";
	public static final String MESSAGE_SUCCESS_DISABLED = "Se Deshabilito Correctamente este Registro";
	public static final String MESSAGE_SUCCESS_ENABLED = "Se Habilito Correctamente este Registro";
	public static final String MESSAGE_GENERATED = "GENERADO";
	public static final String MESSAGE_TOTAL_REGISTROS = "Total Registros";
	public static final String MESSAGE_TOTAL_REGISTROS_CON = "";
	public static final String ESTADO = "SERVICIO OPERANDO";
	public static final String HECHO = "HECHO";
	public static final String BUENO = "BUENO";
	public static final String ERROR = "ERROR";
	public static final String EXCEDIO = "EXCEDIO";
	public static final String UPS = "UPS";
	public static final String SIN_PERMISO = "SIN PERMISO";
	public static final String AUTORIZADO = "MES NO AUTORIZADO";
	public static final String LLENO = "LLENO";
	public static final String PAGO_RAPIDO = "PAGO RAPIDO";
	public static final String PAGO_ADELANTADO_SIN_PROMO = "PAGO ADELANTADO SIN PROMO";
	public static final String PAGO_ADELANTADO_CON_PROMO = "PAGO ADELANTADO CON PROMO";
	
	public static final String REPORTE_CUENTAS = "/reports/reporteCuentas.jrxml";
}
