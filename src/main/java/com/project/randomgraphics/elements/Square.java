package com.project.randomgraphics.elements;

//class is immutable
public class Square implements Shape{

	private ShapeType type = ShapeType.SQUARE;
	private Position position;
	
	public Square(Position position) {
		this.position = position;
	}
	
	public Square(int x, int y, int width, int height) {
		this.position = new Position(x, y, width, height);
	}
	
	public ShapeType getType() {
		return this.type;
	}

	public Position getPosition() {
		return this.position;
	}

	@Override
	public String toString() {
		return "Square [type=" + type + ", position=" + position + "]";
	}
	
	
}
