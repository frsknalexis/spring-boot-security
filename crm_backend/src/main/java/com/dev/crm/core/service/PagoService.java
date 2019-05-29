package com.dev.crm.core.service;

import java.util.List;

import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.ConsecutivoPagoRequest;
import com.dev.crm.core.dto.DetallePagoResultViewModel;
import com.dev.crm.core.dto.ListaPagosPorCajaResultViewModel;
import com.dev.crm.core.dto.MesDeudaResultViewModel;
import com.dev.crm.core.dto.PagoMoraRequest;
import com.dev.crm.core.dto.PagoRequest;
import com.dev.crm.core.dto.PagosDelDiaResultViewModel;
import com.dev.crm.core.dto.ReciboResultViewModel;

public interface PagoService {

	List<ClientePagoResultViewModel> spListarClientesPago(String usuario);
	
	List<MesDeudaResultViewModel> spMesesDeudas(String documentoPersonaCliente, String numeroCaja);
	
	List<PagosDelDiaResultViewModel> spListarPagosDelDia(String usuario);
	
	List<ListaPagosPorCajaResultViewModel> spListaPagosPorCajaReporte(String usuario);
	
	String spPagoServicio(PagoRequest pagoRequest);
	
	String spPagoMora(PagoMoraRequest pagoMora);
	
	String spInsertarConsecutivoPago(ConsecutivoPagoRequest request);
	
	List<DetallePagoResultViewModel> spListarDetallePago(String persona);
	
	ReciboResultViewModel spGenerarReciboPago(String usuario, Integer codigoPago);
}
