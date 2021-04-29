package cl.ionix.testbackend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Result {
	
	private List<Item> items;
	private int registerCount;
	public Result() {
	}
	public Result(List<Item> items, int registerCount) {
		this.items = items;
		this.registerCount = registerCount;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public int getRegisterCount() {
		return registerCount;
	}
	public void setRegisterCount(int registerCount) {
		this.registerCount = registerCount;
	}
	@Override
	public String toString() {
		return "Result [items=" + items + ", registerCount=" + registerCount + "]";
	}

}
