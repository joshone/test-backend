package cl.ionix.testbackend.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.ionix.testbackend.model.SandboxResponse;

@FeignClient(value = "sandbox", url = "${feign.config.api.url}")
public interface SandboxClient {
	
	@GetMapping(value = "${feign.config.api.path}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SandboxResponse> consultaApi(@RequestParam("rut") String rut);
}
