package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.dto.SexoResultViewModel;
import com.dev.crm.core.model.entity.Sexo;

public interface SexoService {

	List<Sexo> findAll();
	
	List<SexoResultViewModel> listarSexo();
}
