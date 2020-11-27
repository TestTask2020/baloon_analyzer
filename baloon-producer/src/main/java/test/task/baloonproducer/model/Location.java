package test.task.baloonproducer.model;

public class Location {
	private Integer x;
	private Integer y;
	
	public Location() {
	}
	
	public Location(final Integer x, final Integer y) {
		this.x = x;
		this.y = y;
	}
	
	public Integer getX() {
		return this.x;
	}
	
	public void setX(final Integer x) {
		this.x = x;
	}
	
	public Integer getY() {
		return this.y;
	}
	
	public void setY(final Integer y) {
		this.y = y;
	}
}
