package com.dev.crm.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dao.DetalleCuentaDAO;
import com.dev.crm.core.dto.DatosInternetServicioRequest;
import com.dev.crm.core.dto.DetalleCuentaRequest;
import com.dev.crm.core.model.entity.DetalleCuenta;
import com.dev.crm.core.repository.jdbc.DatosInternetServicioJdbcRepository;
import com.dev.crm.core.repository.jdbc.DetalleCuentaInternetJdbcRepository;
import com.dev.crm.core.service.DetalleCuentaService;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Service("detalleCuentaService")
@Transactional("hibernateTransactionManager")
public class DetalleCuentaServiceImpl implements DetalleCuentaService {

	@Autowired
	@Qualifier("detalleCuentaDAO")
	private DetalleCuentaDAO detalleCuentaDAO;
	
	@Autowired
	@Qualifier("detalleCuentaInternetJdbcRepository")
	private DetalleCuentaInternetJdbcRepository detalleCuentaInternetJdbcRepository;
	
	@Autowired
	@Qualifier("datosInternetServicioJdbcRepository")
	private DatosInternetServicioJdbcRepository datosInternetServicioJdbcRepository;
	
	@Override
	public String spInsercionCuentaInternet(DetalleCuentaRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = detalleCuentaInternetJdbcRepository.spInsercionCuentaInternet(request);
				if(StringUtil.hasText(result)) {
					return result;
				}
				else {
					return null;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String spInsercionCuentaCable(DetalleCuenta dC) {
		
		try {
			
			if(GenericUtil.isNotNull(dC)) {
				String result = detalleCuentaDAO.spInsercionCuentaCable(dC);
				if(StringUtil.hasText(result)) {
					return result;
				}
				else {
					return null;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String spEnvioDatosInternetServicio(DatosInternetServicioRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = datosInternetServicioJdbcRepository.spEnvioDatosInternetServicio(request);
				if(StringUtil.hasText(result)) {
					return result;
				}
				else {
					return null;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Integer spContadorPendientesCable() {
		
		try {
			
			Integer result = detalleCuentaDAO.spContadorPendientesCable();
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer spContadorPendientesInternet() {
		
		try {
			
			Integer result = detalleCuentaDAO.spContadorPendientesInternet();
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String spReprogramarInstalacionCable() {
		
		try {
			
			String result = detalleCuentaDAO.spReprogramarInstalacionCable();
			if(StringUtil.hasText(result)) {
				return result;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String spReprogramarInstalacionInternet() {
		
		try {
			
			String result = detalleCuentaDAO.spReprogramarInstalacionInternet();
			if(StringUtil.hasText(result)) {
				return result;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String spRevalidandoFechaCable() {
		
		try {
			
			String result = detalleCuentaDAO.spRevalidandoFechaCable();
			if(StringUtil.hasText(result)) {
				return result;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String spRevalidandoFechaInternet() {
		
		try {
			
			String result = detalleCuentaDAO.spRevalidandoFechaInternet();
			if(StringUtil.hasText(result)) {
				return result;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
