package cl.ionix.testbackend.vo;

import cl.ionix.testbackend.model.User;

public class UserVO {
	
	private String name;
	private String username;
	private String email;
	private String phone;
	public UserVO() {
	}
	public UserVO(String name, String username, String email, String phone) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "UserVO [name=" + name + ", username=" + username + ", email=" + email + ", phone=" + phone + "]";
	}
	
	public static UserVO mapFrom(User user) {
		UserVO userVo = new UserVO();
		userVo.setName(user.getName());
		userVo.setUsername(user.getUsername());
		userVo.setEmail(user.getEmail());
		userVo.setPhone(user.getPhone());
		return userVo;
	}

}
