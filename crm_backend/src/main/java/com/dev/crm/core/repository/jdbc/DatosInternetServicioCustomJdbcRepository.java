package com.dev.crm.core.repository.jdbc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.DatosInternetServicioRequest;
import com.dev.crm.core.util.Constantes;

@Repository("datosInternetServicioJdbcRepository")
public class DatosInternetServicioCustomJdbcRepository implements DatosInternetServicioJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public String spEnvioDatosInternetServicio(DatosInternetServicioRequest request) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_ENVIO_DATOS_IN_SERVICIO);
			simpleJdbcCall.declareParameters(new SqlParameter("CODCUN", Types.INTEGER),
					new SqlParameter("DNIRUC", Types.VARCHAR),
					new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("CODCUN", request.getCodigoCuenta());
			inParams.put("DNIRUC", request.getDocumentoPersonaCliente());
			
			Map<String, Object> out = simpleJdbcCall.execute(inParams);
			String result = (String) out.get("MENSAJE");
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
