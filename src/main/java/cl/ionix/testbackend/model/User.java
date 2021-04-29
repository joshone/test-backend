package cl.ionix.testbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long id_usuario;
	@Column(name="name")
	private String name;
	@Column(name="username")
	private String username;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private String phone;
	
	public User() {
	}
	public User(Long id_usuario, String name, String username, String email, String phone) {
		this.id_usuario = id_usuario;
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
	}
	
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
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
		return "CreacionUsuarioRequest [id_usuario=" + id_usuario + ", name=" + name + ", username=" + username + ", email=" + email + ", phone="
				+ phone + "]";
	}
	

}
