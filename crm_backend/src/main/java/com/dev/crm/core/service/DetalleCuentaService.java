package com.dev.crm.core.service;

import com.dev.crm.core.dto.DatosInternetServicioRequest;
import com.dev.crm.core.dto.DetalleCuentaRequest;
import com.dev.crm.core.model.entity.DetalleCuenta;

public interface DetalleCuentaService {

	String spInsercionCuentaInternet(DetalleCuentaRequest request);
	
	String spInsercionCuentaCable(DetalleCuenta detalleCuenta);
	
	String spEnvioDatosInternetServicio(DatosInternetServicioRequest request);
	
	Integer spContadorPendientesCable();
	
	Integer spContadorPendientesInternet();
	
	String spReprogramarInstalacionCable();
	
	String spReprogramarInstalacionInternet();
	
	String spRevalidandoFechaCable();
	
	String spRevalidandoFechaInternet();
}
