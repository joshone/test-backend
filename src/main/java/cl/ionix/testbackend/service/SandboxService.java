package cl.ionix.testbackend.service;

import org.springframework.http.ResponseEntity;

import cl.ionix.testbackend.model.SandboxResponse;

public interface SandboxService {
	
	public ResponseEntity<SandboxResponse> consumeSandbox(String encryptedRut);

}
