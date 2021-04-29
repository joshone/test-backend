package cl.ionix.testbackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.ionix.testbackend.model.SandboxResponse;
import cl.ionix.testbackend.service.SandboxClient;
import cl.ionix.testbackend.service.SandboxService;

@Service
public class SandboxServiceImpl implements SandboxService{
	
	@Autowired
	private SandboxClient sandboxClient;

	@Override
	public ResponseEntity<SandboxResponse> consumeSandbox(String encryptedRut) {
		
		return sandboxClient.consultaApi(encryptedRut);
	}

}
