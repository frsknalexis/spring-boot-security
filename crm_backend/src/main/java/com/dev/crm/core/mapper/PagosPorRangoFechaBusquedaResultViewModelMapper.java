package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.PagosPorRangoFechaBusquedaResultViewModel;

public class PagosPorRangoFechaBusquedaResultViewModelMapper implements RowMapper<PagosPorRangoFechaBusquedaResultViewModel> {

	@Override
	public PagosPorRangoFechaBusquedaResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PagosPorRangoFechaBusquedaResultViewModel pagosPorRangoFecha = new PagosPorRangoFechaBusquedaResultViewModel();
		pagosPorRangoFecha.setCodigoPago(rs.getInt("codigo_pago"));
		pagosPorRangoFecha.setMesPago(rs.getString("mes_pago"));
		pagosPorRangoFecha.setCantidadPago(rs.getBigDecimal("cant_pago"));
		pagosPorRangoFecha.setFechaPagoDia(rs.getDate("fecha_pago_dia"));
		pagosPorRangoFecha.setCliente(rs.getString("cliente"));
		return pagosPorRangoFecha;
	}
}
