package com.dev.crm.core.repository.jdbc;

import java.util.List;

import com.dev.crm.core.dto.GestoresResultViewModel;

public interface GestoresJdbcRepository {

	List<GestoresResultViewModel> listarGestores();
}
