package com.dev.crm.core.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class HerramientaPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6751253102473458319L;
	
	private Integer codigoHerramienta;
	
	private Date fechaRegistroHerramienta;
	
	private Integer secuencialHerramienta;

	public HerramientaPK() {
	
	}

	public HerramientaPK(Integer codigoHerramienta, Date fechaRegistroHerramienta, Integer secuencialHerramienta) {
		super();
		this.codigoHerramienta = codigoHerramienta;
		this.fechaRegistroHerramienta = fechaRegistroHerramienta;
		this.secuencialHerramienta = secuencialHerramienta;
	}

	public Integer getCodigoHerramienta() {
		return codigoHerramienta;
	}

	public void setCodigoHerramienta(Integer codigoHerramienta) {
		this.codigoHerramienta = codigoHerramienta;
	}

	public Date getFechaRegistroHerramienta() {
		return fechaRegistroHerramienta;
	}

	public void setFechaRegistroHerramienta(Date fechaRegistroHerramienta) {
		this.fechaRegistroHerramienta = fechaRegistroHerramienta;
	}

	public Integer getSecuencialHerramienta() {
		return secuencialHerramienta;
	}

	public void setSecuencialHerramienta(Integer secuencialHerramienta) {
		this.secuencialHerramienta = secuencialHerramienta;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		final HerramientaPK other = (HerramientaPK) obj;
		if(!Objects.equals(this.codigoHerramienta, other.codigoHerramienta)) {
			return false;
		}
		if(!Objects.equals(this.fechaRegistroHerramienta, other.fechaRegistroHerramienta)) {
			return false;
		}
		if(!Objects.equals(this.secuencialHerramienta, other.secuencialHerramienta)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
	
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.codigoHerramienta);
		hash = 59 * hash + Objects.hashCode(this.fechaRegistroHerramienta);
		hash = 59 * hash + Objects.hashCode(this.secuencialHerramienta);
		return hash;
	}
}
