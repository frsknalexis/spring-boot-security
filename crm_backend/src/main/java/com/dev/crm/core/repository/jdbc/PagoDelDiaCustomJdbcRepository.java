package com.dev.crm.core.repository.jdbc;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.dto.PagosDelDiaResultViewModel;
import com.dev.crm.core.mapper.PagosDelDiaResultViewModelMapper;
import com.dev.crm.core.util.Constantes;

@Repository("pagoDelDiaJdbcRepository")
public class PagoDelDiaCustomJdbcRepository implements PagoDelDiaJdbcRepository {

	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PagosDelDiaResultViewModel> spListarPagosDelDia(String usuario) {
		
		List<PagosDelDiaResultViewModel> pagosDelDia = new ArrayList<PagosDelDiaResultViewModel>();
		
		try {
			
			simpleJdbcCall.withProcedureName(Constantes.SP_LISTAR_PAGOS_DEL_DIA);
			simpleJdbcCall.declareParameters(new SqlParameter("CODUSU", Types.VARCHAR));
			simpleJdbcCall.returningResultSet("pagosDelDia", new PagosDelDiaResultViewModelMapper());
			
			MapSqlParameterSource inParams = new MapSqlParameterSource();
			inParams.addValue("CODUSU", usuario);
			
			Map<String, Object> result = simpleJdbcCall.execute(inParams);
			pagosDelDia = (List<PagosDelDiaResultViewModel>) result.get("pagosDelDia");
			return pagosDelDia;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
