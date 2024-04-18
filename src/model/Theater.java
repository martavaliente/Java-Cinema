package model;

public class Theater implements ITheater{
	private int id;
	private int capacity;
	private static int nextId=0;
	
	
	public Theater (int capacity) {
		this.id=nextId++;
		this.capacity=capacity;
		
	}
	@Override
	public void setId(int id) {
		this.id=id;
		
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setCapacity(int capacity) {
		this.capacity=capacity;
		
	}

	@Override
	public int getCapacity() {
		return capacity;
	}
	@Override
	public String toString() {
		return "Theater ("+"id =" + id+ ",capacity"+ capacity+ ")";
	}
}