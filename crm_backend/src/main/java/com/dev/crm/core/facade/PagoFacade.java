package com.dev.crm.core.facade;

import java.util.List;

import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.ConsecutivoPagoRequest;
import com.dev.crm.core.dto.DetallePagoResultViewModel;
import com.dev.crm.core.dto.ListaPagosPorCajaResultViewModel;
import com.dev.crm.core.dto.MesDeudaResultViewModel;
import com.dev.crm.core.dto.PagoMoraRequest;
import com.dev.crm.core.dto.PagoRequest;
import com.dev.crm.core.dto.PagosDelDiaResultViewModel;
import com.dev.crm.core.dto.PagosPorDiaRequest;
import com.dev.crm.core.dto.PagosPorDiaResultViewModel;
import com.dev.crm.core.dto.ReciboResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;

public interface PagoFacade {

	List<ClientePagoResultViewModel> spListarClientesPago(String usuario);
	
	List<MesDeudaResultViewModel> spMesesDeudas(String documentoPersonaCliente, String numeroCaja);
	
	List<PagosDelDiaResultViewModel> spListarPagosDelDia(String usuario);
	
	List<ListaPagosPorCajaResultViewModel> spListaPagosPorCajaReporte(String usuario);
	
	List<PagosPorDiaResultViewModel> spReporteListaPagosPorDia(PagosPorDiaRequest request);
	
	ResponseBaseOperation spPagoServicio(PagoRequest pagoRequest);
	
	ResponseBaseOperation spPagoMora(PagoMoraRequest pagoMora);
	
	ResponseBaseOperation spInsertarConsecutivoPago(ConsecutivoPagoRequest request);
	
	List<DetallePagoResultViewModel> spListarDetallePago(String persona);
	
	ReciboResultViewModel spGenerarReciboPago(String usuario, Integer codigoPago);
}
