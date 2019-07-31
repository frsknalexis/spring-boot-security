package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.dto.CuentaPorEstadoRequest;
import com.dev.crm.core.dto.CuentaPorEstadoResultViewModel;
import com.dev.crm.core.dto.CuentaRequest;
import com.dev.crm.core.dto.CuentasPorInstalarResultViewModel;
import com.dev.crm.core.dto.CuentasRangoRequest;
import com.dev.crm.core.dto.CuentasRangoResultViewModel;
import com.dev.crm.core.dto.CuentasResultViewModel;
import com.dev.crm.core.dto.DatosInternetServicioRequest;
import com.dev.crm.core.dto.DatosMaterialesRequest;
import com.dev.crm.core.dto.DetalleCuentaRequest;
import com.dev.crm.core.dto.EstadoCuentasResultViewModel;
import com.dev.crm.core.dto.EstadosCuentaResultViewModel;
import com.dev.crm.core.dto.ObservacionResultViewModel;
import com.dev.crm.core.model.entity.DetalleCuenta;

public interface DetalleCuentaService {

	String spInsercionCuentaInternet(DetalleCuentaRequest request);
	
	String spInsercionCuentaCable(DetalleCuenta detalleCuenta);
	
	String spEnvioDatosInternetServicio(DatosInternetServicioRequest request);
	
	String spEnvioDatosMaterial(DatosMaterialesRequest request);
	
	Integer spContadorPendientesCable();
	
	Integer spContadorPendientesInternet();
	
	String spReprogramarInstalacionCable();
	
	String spReprogramarInstalacionInternet();
	
	String spRevalidandoFechaCable();
	
	String spRevalidandoFechaInternet();
	
	List<CuentasPorInstalarResultViewModel> listarCuentaPorInstalar();
	
	List<EstadoCuentasResultViewModel> listarEstadoCuentas();
	
	List<EstadosCuentaResultViewModel> listarEstadosCuentas();
	
	List<CuentasResultViewModel> listarCuentasPorDia(CuentaRequest request);
	
	List<CuentasRangoResultViewModel> listarCuentasPorRango(CuentasRangoRequest request);
	
	List<CuentaPorEstadoResultViewModel> listarCuentasPorEstado(CuentaPorEstadoRequest request);
	
	void spUpdateDetalleCuenta(Integer codigoDetalleCuenta);
	
	ObservacionResultViewModel spRecuperarObservacion(Integer codigoDetalleCuenta);
}
