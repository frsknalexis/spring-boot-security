package com.dev.crm.core.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.crm.core.dto.InstalacionDiaInternetResultViewModel;
import com.dev.crm.core.facade.InstalacionFacade;
import com.dev.crm.core.security.UserDetail;
import com.dev.crm.core.util.GenericUtil;

@RestController
@RequestMapping("/api/v1/instalacion")
public class InstalacionRestController {

	@Autowired
	@Qualifier("instalacionFacade")
	private InstalacionFacade instalacionFacade;
	
	@Autowired
	@Qualifier("userDetail")
	private UserDetail userDetail;
	
	@GetMapping("/instalacionesDiaInternet")
	public ResponseEntity<List<InstalacionDiaInternetResultViewModel>> spListarInstalacionDiaInternet() {
		
		try {
			
			User usuarioLogueado = userDetail.findLoggedInUser();
			String user = usuarioLogueado.getUsername();
			//String usuario = "joroblesext";
			List<InstalacionDiaInternetResultViewModel> instalacionesDiaInternet = instalacionFacade.spListarInstalacionDiaInternet(user);
			if(GenericUtil.isCollectionEmpty(instalacionesDiaInternet)) {
				return new ResponseEntity<List<InstalacionDiaInternetResultViewModel>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<InstalacionDiaInternetResultViewModel>>(instalacionesDiaInternet, HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<InstalacionDiaInternetResultViewModel>>(HttpStatus.BAD_REQUEST);
		}
	}
}
