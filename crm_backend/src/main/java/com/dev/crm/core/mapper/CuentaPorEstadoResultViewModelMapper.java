package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.CuentaPorEstadoResultViewModel;

public class CuentaPorEstadoResultViewModelMapper implements RowMapper<CuentaPorEstadoResultViewModel> {

	@Override
	public CuentaPorEstadoResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CuentaPorEstadoResultViewModel cuentasPorEstado = new CuentaPorEstadoResultViewModel();
		cuentasPorEstado.setCodigoDetalleCuenta(rs.getInt("codi_detcun"));
		cuentasPorEstado.setDocumentoPersonaCliente(rs.getString("documento_personac"));
		cuentasPorEstado.setCliente(rs.getString("cliente"));
		cuentasPorEstado.setEstado(rs.getString("estado"));
		cuentasPorEstado.setFechaInicio(rs.getString("fechainicio"));
		cuentasPorEstado.setReferencia(rs.getString("referencia_persona"));
		cuentasPorEstado.setVendedorResponsable(rs.getString("nombrevendedorurgencia"));
		return cuentasPorEstado;
	}
}
