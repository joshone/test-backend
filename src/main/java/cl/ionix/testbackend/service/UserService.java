package cl.ionix.testbackend.service;

import java.util.List;

import cl.ionix.testbackend.model.User;
import cl.ionix.testbackend.vo.UserVO;

public interface UserService {
	
	public List<User> all();
	public User save(UserVO userVo);
	public User findByEmail(String email);
	

}
