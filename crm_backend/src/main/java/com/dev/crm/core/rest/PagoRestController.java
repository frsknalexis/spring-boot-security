package com.dev.crm.core.rest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.ClientePagoResultViewModel;
import com.dev.crm.core.dto.ConsecutivoPagoRequest;
import com.dev.crm.core.dto.DetallePagoResultViewModel;
import com.dev.crm.core.dto.ListaPagosPorCajaResultViewModel;
import com.dev.crm.core.dto.MesDeudaResultViewModel;
import com.dev.crm.core.dto.PagoMoraRequest;
import com.dev.crm.core.dto.PagoRequest;
import com.dev.crm.core.dto.PagosDelDiaResultViewModel;
import com.dev.crm.core.dto.ResponseBaseOperation;
import com.dev.crm.core.facade.PagoFacade;
import com.dev.crm.core.security.UserDetail;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.view.excel.ExcelGenerator;
import com.dev.crm.core.view.pdf.PdfGenerator;

@RestController
@RequestMapping("/api/v1/pago")
public class PagoRestController {

	@Autowired
	@Qualifier("pagoFacade")
	private PagoFacade pagoFacade;
	
	@Autowired
	@Qualifier("userDetail")
	private UserDetail userDetail;
	
	@GetMapping("/clientes/clientesPago")
	public ResponseEntity<List<ClientePagoResultViewModel>> spListarClientesPago() {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			
			String usuario = usuarioLogueado.getUsername();
			List<ClientePagoResultViewModel> clientesPagos = pagoFacade.spListarClientesPago(usuario);
			if(GenericUtil.isNotEmpty(clientesPagos)) {
				return new ResponseEntity<List<ClientePagoResultViewModel>>(clientesPagos, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<ClientePagoResultViewModel>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<ClientePagoResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/clientes/listaMesesDeudas/{documentoPersonaCliente}")
	public ResponseEntity<List<MesDeudaResultViewModel>> spMesesDeudas(@PathVariable(value="documentoPersonaCliente") String documentoPersonaCliente) {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			
			String numeroCaja = usuarioLogueado.getUsername();
			List<MesDeudaResultViewModel> mesesDeudas = pagoFacade.spMesesDeudas(documentoPersonaCliente, numeroCaja);
			if(GenericUtil.isNotEmpty(mesesDeudas)) {
				return new ResponseEntity<List<MesDeudaResultViewModel>>(mesesDeudas, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<MesDeudaResultViewModel>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<MesDeudaResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/realizarPago")
	public ResponseEntity<ResponseBaseOperation> spPagoServicio(@Valid @RequestBody PagoRequest pagoRequest) {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			
			String numeroCaja = usuarioLogueado.getUsername();
			pagoRequest.setNumeroCaja(numeroCaja);
			ResponseBaseOperation response = pagoFacade.spPagoServicio(pagoRequest);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/realizarPagoMora")
	public ResponseEntity<ResponseBaseOperation> spPagoMora(@Valid @RequestBody PagoMoraRequest pagoMora) {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			
			String numeroCaja = usuarioLogueado.getUsername();
			pagoMora.setNumeroCaja(numeroCaja);
			ResponseBaseOperation response = pagoFacade.spPagoMora(pagoMora);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/consecutivoPago")
	public ResponseEntity<ResponseBaseOperation> spInsertarConsecutivoPago(@Valid @RequestBody ConsecutivoPagoRequest request) {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			
			String codigoUsuario = usuarioLogueado.getUsername();
			request.setCodigoUsuario(codigoUsuario);
			ResponseBaseOperation response = pagoFacade.spInsertarConsecutivoPago(request);
			return new ResponseEntity<ResponseBaseOperation>(response, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<ResponseBaseOperation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/pagosDelDia")
	public ResponseEntity<List<PagosDelDiaResultViewModel>> spListarPagosDelDia() {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			
			String usuario = usuarioLogueado.getUsername();
			List<PagosDelDiaResultViewModel> pagosDelDia = pagoFacade.spListarPagosDelDia(usuario);
			if(GenericUtil.isCollectionEmpty(pagosDelDia) && pagosDelDia.isEmpty()) {
				return new ResponseEntity<List<PagosDelDiaResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<PagosDelDiaResultViewModel>>(pagosDelDia, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<PagosDelDiaResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listaDetallePago/{persona}")
	public ResponseEntity<List<DetallePagoResultViewModel>> spListaDetallePago(@PathVariable(value="persona") String persona) {
		
		try {
			
			List<DetallePagoResultViewModel> Dpago = pagoFacade.spListarDetallePago(persona);
			if(GenericUtil.isNotEmpty(Dpago)) {
				return new ResponseEntity<List<DetallePagoResultViewModel>>(Dpago, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<DetallePagoResultViewModel>>(HttpStatus.NO_CONTENT);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<DetallePagoResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/generarRecibo", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> generarReciboToPdf() {
		
		try {
			
			ByteArrayInputStream bis = PdfGenerator.generarReciboToPDF();
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=recibo.pdf");
			
			return ResponseEntity.ok()
					.headers(headers)
					.contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
		catch(Exception e) {
			return new ResponseEntity<InputStreamResource>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/pdfReport", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> pagosReportToPDF() throws IOException {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			
			String usuario = usuarioLogueado.getUsername();
			List<ListaPagosPorCajaResultViewModel> pagosPorCaja = pagoFacade.spListaPagosPorCajaReporte(usuario);
			
			ByteArrayInputStream bis = PdfGenerator.pagosToPdf(pagosPorCaja);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=pagosReport.pdf");
			
			return ResponseEntity.ok()
					.headers(headers)
					.contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(bis));
		}
		catch(Exception e) {
			return new ResponseEntity<InputStreamResource>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/excelReport")
	public ResponseEntity<InputStreamResource> pagosReportToExcel() throws IOException {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			
			String usuario = usuarioLogueado.getUsername();
			List<PagosDelDiaResultViewModel> pagosDelDia = pagoFacade.spListarPagosDelDia(usuario);
			
			ByteArrayInputStream bis = ExcelGenerator.pagosToExcel(pagosDelDia);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=pagos.xlsx");
			
			return ResponseEntity.ok()
					.headers(headers)
					.body(new InputStreamResource(bis));
		}
		catch(Exception e) {
			return new ResponseEntity<InputStreamResource>(HttpStatus.BAD_REQUEST);
		}
	}
}
