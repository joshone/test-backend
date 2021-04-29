package cl.ionix.testbackend.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.ionix.testbackend.domain.Endpoint;
import cl.ionix.testbackend.model.ApiRequest;
import cl.ionix.testbackend.model.Result;
import cl.ionix.testbackend.model.SandboxResponse;
import cl.ionix.testbackend.model.User;
import cl.ionix.testbackend.service.SandboxService;
import cl.ionix.testbackend.service.UserService;
import cl.ionix.testbackend.vo.UserVO;

@RestController
@RequestMapping(Endpoint.VERSION_1 + "/api")
public class UsuariosController {
	
	private Logger logger = LoggerFactory.getLogger(UsuariosController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SandboxService sandboxService;
	
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody UserVO userVo){
				
		return new ResponseEntity<User>(userService.save(userVo), HttpStatus.OK);
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserVO>> all(){
		List<UserVO> users = userService.all()
				.stream()
				.map(UserVO::mapFrom)
				.peek(System.out::println)
				.collect(Collectors.toList());
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findUser(@RequestParam("email") String email){
		
		return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);
	}
	
	@PostMapping(value = "/api-sandbox", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SandboxResponse> apiSandBox(@RequestBody ApiRequest apiRequest) throws Exception{
		
		LocalDateTime start = LocalDateTime.now(); 
		
		DESKeySpec keySpec = new DESKeySpec("ionix123456".getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey sk = keyFactory.generateSecret(keySpec);
		
		byte[] cleartext = apiRequest.getRut().getBytes("UTF-8");
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, sk);
		
		byte [] encValue = cipher.doFinal(cleartext);
		String encryptedRut = Base64.getEncoder().encodeToString(encValue);
		logger.info("encryptedRut= {}", encryptedRut);
		ResponseEntity<SandboxResponse> responseEntity = sandboxService.consumeSandbox(encryptedRut);
		LocalDateTime finish = LocalDateTime.now(); 
		
		SandboxResponse sandboxResponse = responseEntity.getStatusCodeValue() == 200 ? responseEntity.getBody() : null;
		
		sandboxResponse.setElapsedTime(Duration.between(start, finish).toMillis());
		
		SandboxResponse apiResponse = sandboxResponse;
		apiResponse.setResult(new Result(null, sandboxResponse.getResult().getItems().size()));
		
		return new ResponseEntity<SandboxResponse>(apiResponse, HttpStatus.OK);
	}

}
