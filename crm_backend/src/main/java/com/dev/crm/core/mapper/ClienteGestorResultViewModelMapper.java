package com.dev.crm.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dev.crm.core.dto.ClienteGestorResultViewModel;

public class ClienteGestorResultViewModelMapper implements RowMapper<ClienteGestorResultViewModel> {

	@Override
	public ClienteGestorResultViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ClienteGestorResultViewModel clienteGestor = new ClienteGestorResultViewModel();
		clienteGestor.setConsecutivoCliente(rs.getInt("cons_cliente"));
		clienteGestor.setCliente(rs.getString("cliente"));
		clienteGestor.setGestor(rs.getString("gestor"));
		return clienteGestor;
	}
}
