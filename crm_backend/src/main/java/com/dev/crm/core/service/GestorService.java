package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.dto.ClienteGestorRequest;
import com.dev.crm.core.dto.ClienteGestorResultViewModel;
import com.dev.crm.core.dto.DeudasGestoresResultViewModel;
import com.dev.crm.core.dto.DiasDeudasRequest;
import com.dev.crm.core.dto.GestoresResultViewModel;

public interface GestorService {

	List<ClienteGestorResultViewModel> listarClienteGestor();
	
	List<GestoresResultViewModel> listarGestores();
	
	List<DeudasGestoresResultViewModel> recuperarDiasDeudasGestoresParametrizado(DiasDeudasRequest request);
	
	String updateClienteGestor(ClienteGestorRequest request);
}
