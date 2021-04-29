package cl.ionix.testbackend.model;

public class Item {
	
	private String name;
	private Detail detail;
	
	public Item() {
	}
	public Item(String name, Detail detail) {
		this.name = name;
		this.detail = detail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Detail getDetail() {
		return detail;
	}
	public void setDetail(Detail detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "Item [name=" + name + ", detail=" + detail + "]";
	}
	

}
