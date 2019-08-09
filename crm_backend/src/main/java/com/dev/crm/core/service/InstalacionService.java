package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.dto.ActivacionRequest;
import com.dev.crm.core.dto.ActivacionesResultViewModel;
import com.dev.crm.core.dto.InformeInstalacionDiaResultViewModel;
import com.dev.crm.core.dto.InstalacionDiaInternetResultViewModel;
import com.dev.crm.core.dto.InstalacionesPorTecnicoResultViewModel;
import com.dev.crm.core.dto.InstalacionesResultViewModel;

public interface InstalacionService {

	List<InstalacionDiaInternetResultViewModel> spListarInstalacionDiaInternet(String usuario);
	
	List<InformeInstalacionDiaResultViewModel> listarInformeInstalacionDia();
	
	List<InstalacionesResultViewModel> contadorInstalacionesRealizadas();
	
	List<ActivacionesResultViewModel> listarActivacionesInstalacion();
	
	List<InstalacionesPorTecnicoResultViewModel> instalacionesPorTecnico();
	
	String spInsertActivacion (ActivacionRequest codigo);
}
