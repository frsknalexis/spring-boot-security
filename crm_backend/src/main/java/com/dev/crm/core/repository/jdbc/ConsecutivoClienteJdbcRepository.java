package com.dev.crm.core.repository.jdbc;

import com.dev.crm.core.dto.CodigoConsecutivoClienteRequest;

public interface ConsecutivoClienteJdbcRepository {

	void generarCodigoConsecutivoCliente(CodigoConsecutivoClienteRequest request);
}
