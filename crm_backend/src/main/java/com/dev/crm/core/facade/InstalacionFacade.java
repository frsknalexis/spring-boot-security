package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.ActivacionRequest;
import com.dev.crm.core.dto.ActivacionesResultViewModel;
import com.dev.crm.core.dto.InformeInstalacionDiaResultViewModel;
import com.dev.crm.core.dto.InstalacionDiaInternetResultViewModel;
import com.dev.crm.core.dto.InstalacionesPorTecnicoResultViewModel;
import com.dev.crm.core.dto.InstalacionesResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;

public interface InstalacionFacade {

	List<InstalacionDiaInternetResultViewModel> spListarInstalacionDiaInternet(String usuario);
	
	List<InformeInstalacionDiaResultViewModel> listarInformeInstalacionDia();
	
	List<InstalacionesPorTecnicoResultViewModel> instalacionesPorTecnico();
	
	List<InstalacionesResultViewModel> contadorInstalacionesRealizadas();
	
	List<ActivacionesResultViewModel> listarActivacionesInstalacion(); 
	
	ResponseBaseOperation spInsertarActivacion(ActivacionRequest codigo);
}
