package com.project.randomgraphics.elements;

public class Position {
	private int x;
	private int y;
	private int width;
	private int height;
	
	
	public Position() {}
	
	public Position(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public synchronized int getX() {
		return x;
	}
	public synchronized void setX(int x) {
		this.x = x;
	}
	public synchronized int getY() {
		return y;
	}
	public synchronized void setY(int y) {
		this.y = y;
	}
	public synchronized int getWidth() {
		return width;
	}
	public synchronized void setWidth(int width) {
		this.width = width;
	}
	public synchronized int getHeight() {
		return height;
	}
	public synchronized void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
	}
	
	
	
}
