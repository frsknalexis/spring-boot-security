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

import com.dev.crm.core.dto.DescuentoHistorialRequest;
import com.dev.crm.core.util.Constantes;

@Repository("HistorialDescuentoResquestdbcRepository")
public class HistorialDescuentoRquestCustomJdbcRepository implements HistorialDescuentoResquestdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}

	@Override
	public String spGenerarDescuento(DescuentoHistorialRequest codigo) {
		
		simpleJdbcCall.withProcedureName(Constantes.SP_GUARDAR_DESCUENTO_MES);
		simpleJdbcCall.declareParameters(new SqlParameter("CODDOC", Types.VARCHAR),
				new SqlParameter("NUMERO_MES", Types.INTEGER),
				new SqlParameter("ANIO_VALIDO", Types.INTEGER),
				new SqlParameter("DESCU", Types.DOUBLE),
				new SqlParameter("MOTI",Types.VARCHAR),
				new SqlParameter("CODUSU", Types.VARCHAR),
				new SqlOutParameter("MENSAJE", Types.VARCHAR));
		
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put("CODDOC", codigo.getDocumentopersoma());
		inParams.put("NUMERO_MES", codigo.getNumerodemes());
		inParams.put("ANIO_VALIDO", codigo.getAniovalido());
		inParams.put("DESCU", codigo.getDescuentodelmes());
		inParams.put("MOTI", codigo.getMotivodeldescuento());
		inParams.put("CODUSU", codigo.getCodigoUsuario());
		
		Map<String, Object> out = simpleJdbcCall.execute(inParams);
		String result = (String) out.get("MENSAJE");
		return result;
	}
}
