package com.dev.crm.core.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.ClienteGestorResultViewModel;
import com.dev.crm.core.facade.GestorFacade;
import com.dev.crm.core.util.GenericUtil;

@RestController
@RequestMapping("/api/v1/gestor")
public class GestorRestController {

	@Autowired
	@Qualifier("gestorFacade")
	private GestorFacade gestorFacade;
	
	@GetMapping("/gestorClientes")
	public ResponseEntity<List<ClienteGestorResultViewModel>> listarClienteGestor() {
		
		try {
			
			List<ClienteGestorResultViewModel> clientesGestor = gestorFacade.listarClienteGestor();
			if(GenericUtil.isCollectionEmpty(clientesGestor)) {
				return new ResponseEntity<List<ClienteGestorResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<ClienteGestorResultViewModel>>(clientesGestor, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<ClienteGestorResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
}
