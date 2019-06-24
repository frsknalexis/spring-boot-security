package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.ClienteGestorResultViewModel;
import com.dev.crm.core.facade.GestorFacade;
import com.dev.crm.core.service.GestorService;
import com.dev.crm.core.util.GenericUtil;

@Component("gestorFacade")
public class GestorFacadeImpl implements GestorFacade {

	@Autowired
	@Qualifier("gestorService")
	private GestorService gestorService;
	
	@Override
	public List<ClienteGestorResultViewModel> listarClienteGestor() {
		
		List<ClienteGestorResultViewModel> clientesGestor = new ArrayList<ClienteGestorResultViewModel>();
		
		try {
			
			clientesGestor = gestorService.listarClienteGestor();
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
}
