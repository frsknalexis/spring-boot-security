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

import com.dev.crm.core.dto.LiquidacionMaterialResultViewModel;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Repository("liquidacionMaterialJdbcRepository")
public class LiquidacionMaterialCustomJdbcRepository implements LiquidacionMaterialJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@Override
	public LiquidacionMaterialResultViewModel generarLiquidacionMaterial(Integer codigoServicioInternet) {
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_GENERAR_LIQUIDACION_MATERIAL);
			simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
			simpleJdbcCall.useInParameterNames("CODSER");
			simpleJdbcCall.declareParameters(new SqlParameter("CODSER", Types.INTEGER),
					new SqlOutParameter("CODISERIN", Types.VARCHAR),
					new SqlOutParameter("FECHAINICIO", Types.VARCHAR),
					new SqlOutParameter("OBS", Types.VARCHAR),
					new SqlOutParameter("DNIRU", Types.VARCHAR),
					new SqlOutParameter("CODIMATEOUT", Types.VARCHAR),
					new SqlOutParameter("CANTIDADMATE", Types.VARCHAR),
					new SqlOutParameter("DESCR", Types.VARCHAR),
					new SqlOutParameter("CLIE", Types.VARCHAR));
			
			Map<String, Object> inParams = new HashMap<String, Object>();
			inParams.put("CODSER", codigoServicioInternet);
			
			Map<String, Object> out = simpleJdbcCall.execute(inParams);
			System.out.println(out);
			
			if(GenericUtil.isNotNull(out.get("CODISERIN")) && GenericUtil.isNotNull(out.get("FECHAINICIO")) && GenericUtil.isNotNull(out.get("OBS"))
				&& GenericUtil.isNotNull(out.get("DNIRU")) && GenericUtil.isNotNull(out.get("CODIMATEOUT")) && GenericUtil.isNotNull(out.get("CANTIDADMATE"))
				&& GenericUtil.isNotNull(out.get("DESCR")) && GenericUtil.isNotNull(out.get("CLIE"))) {
				
				LiquidacionMaterialResultViewModel liquidacion = new LiquidacionMaterialResultViewModel();
				liquidacion.setCodigoServicioInternet((String) out.get("CODISERIN"));
				liquidacion.setFechaInicio((String) out.get("FECHAINICIO"));
				liquidacion.setObservacion((String) out.get("OBS"));
				liquidacion.setDocumentoCliente((String) out.get("DNIRU"));
				liquidacion.setCodigoMaterial((String) out.get("CODIMATEOUT"));
				liquidacion.setCantidadMaterial((String) out.get("CANTIDADMATE"));
				liquidacion.setDescripcionMaterial((String) out.get("DESCR"));
				liquidacion.setCliente((String) out.get("CLIE"));
				return liquidacion;
			}
			else if(GenericUtil.isNull(out.get("CODISERIN")) && GenericUtil.isNull(out.get("FECHAINICIO")) && GenericUtil.isNull(out.get("OBS")) 
					&& GenericUtil.isNull(out.get("DNIRU")) && GenericUtil.isNull(out.get("CODIMATEOUT")) && GenericUtil.isNull(out.get("CANTIDADMATE"))
					&& GenericUtil.isNull(out.get("DESCR")) && GenericUtil.isNull(out.get("CLIE"))) {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
