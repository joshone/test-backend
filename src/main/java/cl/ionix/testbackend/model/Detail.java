package cl.ionix.testbackend.model;

public class Detail {
	private String email;
	private String phone_number;
	public Detail() {
	}
	public Detail(String email, String phone_number) {
		this.email = email;
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	@Override
	public String toString() {
		return "Detail [email=" + email + ", phone_number=" + phone_number + "]";
	}
	
}
