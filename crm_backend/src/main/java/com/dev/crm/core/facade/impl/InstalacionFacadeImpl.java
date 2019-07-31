package com.dev.crm.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dev.crm.core.dto.ActivacionRequest;
import com.dev.crm.core.dto.InformeInstalacionDiaResultViewModel;
import com.dev.crm.core.dto.InstalacionDiaInternetResultViewModel;
import com.dev.crm.core.dto.InstalacionesPorTecnicoResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.InstalacionFacade;
import com.dev.crm.core.service.InstalacionService;
import com.dev.crm.core.util.Constantes;
import com.dev.crm.core.util.GenericUtil;

@Component("instalacionFacade")
public class InstalacionFacadeImpl implements InstalacionFacade {

	@Autowired
	@Qualifier("instalacionService")
	private InstalacionService instalacionService;
	
	@Override
	public List<InstalacionDiaInternetResultViewModel> spListarInstalacionDiaInternet(String usuario) {
		
		List<InstalacionDiaInternetResultViewModel> instalacionesDiaInternet = new ArrayList<InstalacionDiaInternetResultViewModel>();
		
		try {
			
			if(GenericUtil.isNotEmpty(usuario)) {
				instalacionesDiaInternet = instalacionService.spListarInstalacionDiaInternet(usuario);
				if(GenericUtil.isCollectionEmpty(instalacionesDiaInternet)) {
					return null;
				}
				else {
					return instalacionesDiaInternet;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<InformeInstalacionDiaResultViewModel> listarInformeInstalacionDia() {
		
		List<InformeInstalacionDiaResultViewModel> informesInstalacionDia = new ArrayList<InformeInstalacionDiaResultViewModel>();
		
		try {
			
			informesInstalacionDia = instalacionService.listarInformeInstalacionDia();
			if(GenericUtil.isCollectionEmpty(informesInstalacionDia)) {
				return null;
			}
			else {
				return informesInstalacionDia;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<InstalacionesPorTecnicoResultViewModel> instalacionesPorTecnico() {
		
		List<InstalacionesPorTecnicoResultViewModel> instalacionesPorTecnico = new ArrayList<InstalacionesPorTecnicoResultViewModel>();
		
		try {
			
			instalacionesPorTecnico = instalacionService.instalacionesPorTecnico();
			if(GenericUtil.isCollectionEmpty(instalacionesPorTecnico)) {
				return null;
			}
			else {
				return instalacionesPorTecnico;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseBaseOperation spInsertarActivacion(ActivacionRequest codigo) {

		try {
			
			if(GenericUtil.isNotNull(codigo)) {
				String result = instalacionService.spInsertActivacion(codigo);
				if(result.equals(Constantes.HECHO)) {
					return new ResponseBaseOperation(Constantes.CREATED_STATUS, result, codigo);
				}
				else if(result.equals(Constantes.ERROR)) {
					return new ResponseBaseOperation(Constantes.ERROR_STATUS, result, codigo);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
