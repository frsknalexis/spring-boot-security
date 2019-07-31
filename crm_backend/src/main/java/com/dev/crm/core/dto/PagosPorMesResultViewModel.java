package com.dev.crm.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PagosPorMesResultViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2320320987027771047L;

	private Date diaFechaPago;
	
	private BigDecimal cantidadPago;

	public PagosPorMesResultViewModel() {
		
	}

	public Date getDiaFechaPago() {
		return diaFechaPago;
	}

	public void setDiaFechaPago(Date diaFechaPago) {
		this.diaFechaPago = diaFechaPago;
	}

	public BigDecimal getCantidadPago() {
		return cantidadPago;
	}

	public void setCantidadPago(BigDecimal cantidadPago) {
		this.cantidadPago = cantidadPago;
	}
}
