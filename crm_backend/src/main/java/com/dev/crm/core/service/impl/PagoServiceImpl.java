package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.ConsecutivoPagoRequest;
import com.dev.crm.core.dto.DetallePagoResultViewModel;
import com.dev.crm.core.dto.MesDeudaResultViewModel;
import com.dev.crm.core.dto.PagoMoraRequest;
import com.dev.crm.core.dto.PagoRequest;
import com.dev.crm.core.dto.PagosDelDiaResultViewModel;
import com.dev.crm.core.repository.jdbc.ClientePagoJdbcRepository;
import com.dev.crm.core.repository.jdbc.ConsecutivoPagoJdbcRepository;
import com.dev.crm.core.repository.jdbc.DetallePagoResultJdbcRepository;
import com.dev.crm.core.repository.jdbc.MesDeudaResultJdbcRepository;
import com.dev.crm.core.repository.jdbc.PagoDelDiaJdbcRepository;
import com.dev.crm.core.repository.jdbc.PagoJdbcRepository;
import com.dev.crm.core.repository.jdbc.PagoMoraJdbcRepository;
import com.dev.crm.core.service.PagoService;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Service("pagoService")
@Transactional("hibernateTransactionManager")
public class PagoServiceImpl implements PagoService {

	@Autowired
	@Qualifier("pagoJdbcRepository")
	private PagoJdbcRepository pagoJdbcRepository;
	
	@Autowired
	@Qualifier("clientePagoJdbcRepository")
	private ClientePagoJdbcRepository clientePagoJdbcRepository;
	
	@Autowired
	@Qualifier("mesDeudaResultJdbcRepository")
	private MesDeudaResultJdbcRepository mesDeudaResultJdbcRepository;
	
	@Autowired
	@Qualifier("pagoMoraJdbcRepository")
	private PagoMoraJdbcRepository pagoMoraJdbcRepository;
	
	@Autowired
	@Qualifier("pagoDelDiaJdbcRepository")
	private PagoDelDiaJdbcRepository pagoDelDiaJdbcRepository;
	
	@Autowired
	@Qualifier("consecutivoPagoJdbcRepository")
	private ConsecutivoPagoJdbcRepository consecutivoPagoJdbcRepository;
	
	@Autowired
	@Qualifier("DetallePagoResultJdbcRepository")
	private DetallePagoResultJdbcRepository detallePagoResultJdbcRepository;
	
	@Override
	public String spPagoServicio(PagoRequest pagoRequest) {
		
		try {
			
			if(GenericUtil.isNotNull(pagoRequest)) {
				String result = pagoJdbcRepository.spPagoServicio(pagoRequest);
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
	public String spPagoMora(PagoMoraRequest pagoMora) {
		
		try {
			
			if(GenericUtil.isNotNull(pagoMora)) {
				String result = pagoMoraJdbcRepository.spPagoMora(pagoMora);
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
	public String spInsertarConsecutivoPago(ConsecutivoPagoRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = consecutivoPagoJdbcRepository.spInsertarConsecutivoPago(request);
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
	public List<MesDeudaResultViewModel> spMesesDeudas(String documentoPersonaCliente, String numeroCaja) {
		
		List<MesDeudaResultViewModel> mesesDeuda = new ArrayList<MesDeudaResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotEmpty(documentoPersonaCliente) && GenericUtil.isNotEmpty(numeroCaja)) {
				mesesDeuda = mesDeudaResultJdbcRepository.spMesesDeudas(documentoPersonaCliente, numeroCaja);
			}
			if(GenericUtil.isNotEmpty(mesesDeuda)) {
				return mesesDeuda;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PagosDelDiaResultViewModel> spListarPagosDelDia(String usuario) {
		
		List<PagosDelDiaResultViewModel> pagosDelDia = new ArrayList<PagosDelDiaResultViewModel>();
		
		try {
			if(StringUtil.hasText(usuario)) {
				pagosDelDia = pagoDelDiaJdbcRepository.spListarPagosDelDia(usuario);
				if(GenericUtil.isEmpty(pagosDelDia) && pagosDelDia.isEmpty()) {
					return null;
				}
				else {
					return pagosDelDia;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ClientePagoResultViewModel> spListarClientesPago(String usuario) {
		
		List<ClientePagoResultViewModel> clientesPagos = new ArrayList<ClientePagoResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotEmpty(usuario)) {
				clientesPagos = clientePagoJdbcRepository.spListarClientesPago(usuario);
			}
			if(GenericUtil.isNotEmpty(clientesPagos)) {
				return clientesPagos;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DetallePagoResultViewModel> spListarDetallePago(String persona) {
		
		List<DetallePagoResultViewModel> Dpago = new ArrayList<DetallePagoResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotEmpty(persona)) {
				Dpago = detallePagoResultJdbcRepository.spListaDetallePago(persona);
			}
			if(GenericUtil.isNotEmpty(Dpago)) {
				return Dpago;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}