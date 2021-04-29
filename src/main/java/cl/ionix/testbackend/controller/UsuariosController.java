package cl.ionix.testbackend.controller;

import java.util.List;
import java.util.stream.Collectors;

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
import cl.ionix.testbackend.model.User;
import cl.ionix.testbackend.service.UserService;
import cl.ionix.testbackend.vo.UserVO;

@RestController
@RequestMapping(Endpoint.VERSION_1 + "/api")
public class UsuariosController {
	
	@Autowired
	private UserService userService;
	
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

}
