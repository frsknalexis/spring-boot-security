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

import com.dev.crm.core.dto.ClienteDatosAtencionResultViewModel;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Repository("clienteDatosAtencionJdbcRepository")
public class ClienteDatosAtencionCustomJdbcRepository implements ClienteDatosAtencionJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public ClienteDatosAtencionResultViewModel spListarDatosGeneralesCliente(String documentoPersonaCliente) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_DATOS_GENERALES_CLIENTE);
			simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
			simpleJdbcCall.useInParameterNames("COD_DOC");
			simpleJdbcCall.declareParameters(new SqlParameter("COD_DOC", Types.VARCHAR),
					new SqlOutParameter("DOCUMENTO", Types.VARCHAR),
					new SqlOutParameter("CLIENTEE", Types.VARCHAR),
					new SqlOutParameter("TELEFONO", Types.VARCHAR),
					new SqlOutParameter("CARGOEMPLEADO", Types.VARCHAR),
					new SqlOutParameter("SERVICIOO", Types.VARCHAR),
					new SqlOutParameter("CORREO", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("COD_DOC", documentoPersonaCliente);
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			System.out.println(result);
			
			if(GenericUtil.isNotNull(result.get("CLIENTEE")) && GenericUtil.isNotNull(result.get("CARGOEMPLEADO"))
				&& GenericUtil.isNotNull(result.get("DOCUMENTO")) && GenericUtil.isNotNull(result.get("CORREO"))
				&& GenericUtil.isNotNull(result.get("TELEFONO")) && GenericUtil.isNotNull(result.get("SERVICIOO"))) {
				
				ClienteDatosAtencionResultViewModel clienteDatosAtencion = new ClienteDatosAtencionResultViewModel();
				clienteDatosAtencion.setTelefonos((String) result.get("TELEFONO"));
				clienteDatosAtencion.setCliente((String) result.get("CLIENTEE"));
				clienteDatosAtencion.setDocumentoPersonaCliente((String) result.get("DOCUMENTO"));
				clienteDatosAtencion.setCargoempleado((String) result.get("CARGOEMPLEADO"));
				clienteDatosAtencion.setServicio((String) result.get("SERVICIOO"));
				clienteDatosAtencion.setCorreo((String) result.get("CORREO"));
				return clienteDatosAtencion;	
			}
			else if(GenericUtil.isNull(result.get("CLIENTEE")) && GenericUtil.isNull(result.get("CARGOEMPLEADO"))
				&& GenericUtil.isNull(result.get("DOCUMENTO")) && GenericUtil.isNull(result.get("CORREO"))
				&& GenericUtil.isNull(result.get("TELEFONO")) && GenericUtil.isNull(result.get("SERVICIOO"))) {
				return null;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
