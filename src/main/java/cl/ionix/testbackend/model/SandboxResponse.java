package cl.ionix.testbackend.model;


public class SandboxResponse {
	
	private long responseCode;
	private String description;
	private long elapsedTime;
	private Result result;
	
	public SandboxResponse() {
	}
	public SandboxResponse(long responseCode, String description, long elapsedTime, Result result) {
		this.responseCode = responseCode;
		this.description = description;
		this.elapsedTime = elapsedTime;
		this.result = result;
	}
	public long getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(long responseCode) {
		this.responseCode = responseCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "SandboxResponse [responseCode=" + responseCode + ", description=" + description + ", elapsedTime="
				+ elapsedTime + ", result=" + result + "]";
	}
	

}
