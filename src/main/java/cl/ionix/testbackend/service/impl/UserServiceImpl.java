package cl.ionix.testbackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ionix.testbackend.errors.ConflictException;
import cl.ionix.testbackend.model.User;
import cl.ionix.testbackend.repository.UserRepository;
import cl.ionix.testbackend.service.UserService;
import cl.ionix.testbackend.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> all() {
		return userRepository.findAll();
	}

	@Override
	public User save(UserVO userVo) {
		
		User user = new User();
		user.setName(userVo.getUsername());
		user.setUsername(userVo.getUsername());
		user.setEmail(userVo.getEmail());
		user.setPhone(userVo.getPhone());
		
		List<User> list = all()
				.stream()
				.filter(f -> f.getUsername().equals(userVo.getUsername()) || f.getEmail().equals(userVo.getEmail()))
				.collect(Collectors.toList());
		
		user = list.isEmpty() ? userRepository.save(user) : null;
		if(user == null) {
			throw new ConflictException("usuario ya existe");
		}
		
		return user;
	}

	@Override
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

}
