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

import com.dev.crm.core.dto.PagoServicioGestorRequest;
import com.dev.crm.core.util.Constantes;

@Repository("pagoServicioGestorJdbcRepository")
public class PagoServicioGestorCustomJdbcRepository implements PagoServicioGestorJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public String realizarPagoServicioGestor(PagoServicioGestorRequest request) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_PAGO_SERVICIO_GESTOR)
				.declareParameters(new SqlParameter("CDOCOMP", Types.INTEGER),
						new SqlParameter("CODDOC", Types.VARCHAR),
						new SqlParameter("DNI_RUC", Types.VARCHAR),
						new SqlParameter("PAGO", Types.FLOAT),
						new SqlParameter("NOMB_GES", Types.VARCHAR),
						new SqlOutParameter("MENSAJE", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("CDOCOMP", request.getCodigoComprobante());
			inParams.put("CODDOC", request.getDocumentoPersonaPago());
			inParams.put("DNI_RUC", request.getDocumentoPersonaCliente());
			inParams.put("PAGO", request.getCantidadPago());
			inParams.put("NOMB_GES", request.getNombreGestor());
			
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
