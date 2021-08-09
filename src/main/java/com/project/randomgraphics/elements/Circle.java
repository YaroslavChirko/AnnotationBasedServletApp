package com.project.randomgraphics.elements;

public class Circle implements Shape {

	private Position position;
	
	public Circle(Position position) {
		this.position = position;
	}
	
	public Circle(int x, int y, int width, int height) {
		this.position = new Position(x,y,width,height);
	}
	
	public ShapeType getType() {
		return ShapeType.ELLIPSOID;
	}

	public Position getPosition() {
		return this.position;
	}

	@Override
	public String toString() {
		return "Circle [type ="+getType()+" position=" + position + "]";
	}

	
}
