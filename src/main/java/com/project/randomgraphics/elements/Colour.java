package com.project.randomgraphics.elements;

public class Colour {
	private int r;
	private int g;
	private int b;
	private float a;
	
	public Colour() {}
	
	public Colour(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public Colour(int r, int g, int b,float a) {
		this(r, g, b);
		this.a = a;
	}
	
	
	public synchronized int getR() {
		return r;
	}
	public synchronized void setR(int r) {
		this.r = r;
	}
	public synchronized int getG() {
		return g;
	}
	public synchronized void setG(int g) {
		this.g = g;
	}
	public synchronized int getB() {
		return b;
	}
	public synchronized void setB(int b) {
		this.b = b;
	}
	public synchronized float getA() {
		return a;
	}
	public synchronized void setA(float a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "Colour [r=" + r + ", g=" + g + ", b=" + b + ", a=" + a + "]";
	}
	
	
}
