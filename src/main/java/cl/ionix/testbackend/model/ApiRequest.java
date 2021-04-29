package cl.ionix.testbackend.model;

public class ApiRequest {
	
	private String rut;

	public ApiRequest() {
	}

	public ApiRequest(String rut) {
		this.rut = rut;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	@Override
	public String toString() {
		return "ApiRequest [rut=" + rut + "]";
	}
	

}
