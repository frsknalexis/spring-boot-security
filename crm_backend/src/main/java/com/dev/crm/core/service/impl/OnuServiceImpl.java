package com.dev.crm.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.crm.core.dto.DatosOnuInstalacionRequest;
import com.dev.crm.core.repository.jdbc.DatosOnuInstalacionJdbcRepository;
import com.dev.crm.core.service.OnuService;
import com.dev.crm.core.util.GenericUtil;
import com.dev.crm.core.util.StringUtil;

@Service("onuService")
@Transactional("hibernateTransactionManager")
public class OnuServiceImpl implements OnuService {

	@Autowired
	@Qualifier("datosOnuInstalacionJdbcRepository")
	private DatosOnuInstalacionJdbcRepository datosOnuInstalacionJdbcRepository;
	
	@Override
	public String envioDatosOnu(DatosOnuInstalacionRequest request) {
		
		try {
			
			if(GenericUtil.isNotNull(request)) {
				String result = datosOnuInstalacionJdbcRepository.envioDatosOnu(request);
				if(StringUtil.hasText(result)) {
					return result;
				}
				else if(GenericUtil.isEmpty(result)) {
					return null;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
