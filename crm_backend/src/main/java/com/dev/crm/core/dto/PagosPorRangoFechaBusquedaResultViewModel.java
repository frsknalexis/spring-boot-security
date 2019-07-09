package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.dev.crm.core.json.JsonBigDecimalSimpleSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class PagosPorRangoFechaBusquedaResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5617868180876462592L;

	private Integer codigoPago;
	
	private String mesPago;
	
	@JsonSerialize(using = JsonBigDecimalSimpleSerializer.class)
	private BigDecimal cantidadPago;
	
	private Date fechaPagoDia;
	
	private String cliente;

	public PagosPorRangoFechaBusquedaResultViewModel() {
		
	}

	public Integer getCodigoPago() {
		return codigoPago;
	}

	public void setCodigoPago(Integer codigoPago) {
		this.codigoPago = codigoPago;
	}

	public String getMesPago() {
		return mesPago;
	}

	public void setMesPago(String mesPago) {
		this.mesPago = mesPago;
	}

	public BigDecimal getCantidadPago() {
		return cantidadPago;
	}

	public void setCantidadPago(BigDecimal cantidadPago) {
		this.cantidadPago = cantidadPago;
	}

	public Date getFechaPagoDia() {
		return fechaPagoDia;
	}

	public void setFechaPagoDia(Date fechaPagoDia) {
		this.fechaPagoDia = fechaPagoDia;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
}
