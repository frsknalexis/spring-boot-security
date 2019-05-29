package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ReciboResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6867071197749946207L;

	private Integer codigoPago;
	
	private String cliente;
	
	private String direccion;
	
	private Date fechaInicio;
	
	private String mesValido;
	
	private BigDecimal monto;
	
	private BigDecimal descuento;

	public ReciboResultViewModel() {
		
	}

	public Integer getCodigoPago() {
		return codigoPago;
	}

	public void setCodigoPago(Integer codigoPago) {
		this.codigoPago = codigoPago;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getMesValido() {
		return mesValido;
	}

	public void setMesValido(String mesValido) {
		this.mesValido = mesValido;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}
}
