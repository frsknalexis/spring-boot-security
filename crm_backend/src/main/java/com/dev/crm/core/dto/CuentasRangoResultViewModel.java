package com.dev.crm.core.dto;

import java.io.Serializable;

public class CuentasRangoResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3812425783337712770L;

	private Integer codigoDetalleCuenta;
	
	private Integer codigoCuenta;
	
	private String cliente;
	
	private String observacion;
	
	private String documentoPersona;

	public CuentasRangoResultViewModel() {
		
	}

	public Integer getCodigoDetalleCuenta() {
		return codigoDetalleCuenta;
	}

	public void setCodigoDetalleCuenta(Integer codigoDetalleCuenta) {
		this.codigoDetalleCuenta = codigoDetalleCuenta;
	}

	public Integer getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(Integer codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getDocumentoPersona() {
		return documentoPersona;
	}

	public void setDocumentoPersona(String documentoPersona) {
		this.documentoPersona = documentoPersona;
	}
}
