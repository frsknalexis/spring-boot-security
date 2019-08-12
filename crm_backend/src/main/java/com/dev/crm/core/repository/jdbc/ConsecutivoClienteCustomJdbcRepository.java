package com.dev.crm.core.repository.jdbc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.CodigoConsecutivoClienteRequest;
import com.dev.crm.core.util.Constantes;

@Repository("consecutivoClienteJdbcRepository")
public class ConsecutivoClienteCustomJdbcRepository implements ConsecutivoClienteJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	 }
	
	@Override
	public void generarCodigoConsecutivoCliente(CodigoConsecutivoClienteRequest request) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.RECUPERAR_CODIGO_CONSECUTIVO_CLIENTE)
					.declareParameters(new SqlParameter("DNIRUC", Types.VARCHAR));
		
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("DNIRUC", request.getDocumentoPersonaCliente());
			
			simpleJdbcCall.execute(inParams);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
