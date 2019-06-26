package com.dev.crm.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dto.ClienteGestorRequest;
import com.dev.crm.core.dto.ClienteGestorResultViewModel;
import com.dev.crm.core.repository.jdbc.AsignarClienteGestorJdbcRepository;
import com.dev.crm.core.repository.jdbc.ClienteGestorJdbcRepository;
import com.dev.crm.core.service.GestorService;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Service("gestorService")
@Transactional("hibernateTransactionManager")
public class GestorServiceImpl implements GestorService {

	@Autowired
	@Qualifier("clienteGestorJdbcRepository")
	private ClienteGestorJdbcRepository clienteGestorJdbcRepository;
	
	@Autowired
	@Qualifier("asignarClienteGestorJdbcRepository")
	private AsignarClienteGestorJdbcRepository asignarClienteGestorJdbcRepository;
	
	@Override
	public List<ClienteGestorResultViewModel> listarClienteGestor() {
		
		List<ClienteGestorResultViewModel> clientesGestor = new ArrayList<ClienteGestorResultViewModel>();
		
		try {
			
			clientesGestor = clienteGestorJdbcRepository.listarClienteGestor();
			if(GenericUtil.isCollectionEmpty(clientesGestor)) {
				return null;
			}
			else {
				return clientesGestor;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateClienteGestor(ClienteGestorRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = asignarClienteGestorJdbcRepository.updateClienteGestor(request);
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
}
