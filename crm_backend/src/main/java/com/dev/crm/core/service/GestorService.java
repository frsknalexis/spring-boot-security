package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.dto.ClienteGestorRequest;
import com.dev.crm.core.dto.ClienteGestorResultViewModel;

public interface GestorService {

	List<ClienteGestorResultViewModel> listarClienteGestor(); 
	
	String updateClienteGestor(ClienteGestorRequest request);
}
