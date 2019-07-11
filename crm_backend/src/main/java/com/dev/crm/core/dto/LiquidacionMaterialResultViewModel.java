package com.dev.crm.core.dto;

import java.io.Serializable;

public class LiquidacionMaterialResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2360822386661959196L;

	private String codigoServicioInternet;
	
	private String fechaInicio;
	
	private String observacion;
	
	private String documentoCliente;
	
	private String codigoMaterial;
	
	private String cantidadMaterial;
	
	private String descripcionMaterial;
	
	private String cliente;

	public LiquidacionMaterialResultViewModel() {
		
	}

	public String getCodigoServicioInternet() {
		return codigoServicioInternet;
	}

	public void setCodigoServicioInternet(String codigoServicioInternet) {
		this.codigoServicioInternet = codigoServicioInternet;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public String getCodigoMaterial() {
		return codigoMaterial;
	}

	public void setCodigoMaterial(String codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}

	public String getCantidadMaterial() {
		return cantidadMaterial;
	}

	public void setCantidadMaterial(String cantidadMaterial) {
		this.cantidadMaterial = cantidadMaterial;
	}

	public String getDescripcionMaterial() {
		return descripcionMaterial;
	}

	public void setDescripcionMaterial(String descripcionMaterial) {
		this.descripcionMaterial = descripcionMaterial;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
}
