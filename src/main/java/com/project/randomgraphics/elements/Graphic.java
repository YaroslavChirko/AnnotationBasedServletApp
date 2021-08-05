package com.project.randomgraphics.elements;

public class Graphic {
	Shape graphicShape;
	Colour graphicColour;
	
	public Graphic(Shape graphicShape, Colour graphicColour) {
		this.graphicShape = graphicShape;
		this.graphicColour = graphicColour;
	}

	public synchronized Shape getGraphicShape() {
		return graphicShape;
	}

	public synchronized void setGraphicShape(Shape graphicShape) {
		this.graphicShape = graphicShape;
	}

	public synchronized Colour getGraphicColour() {
		return graphicColour;
	}

	public synchronized void setGraphicColour(Colour graphicColour) {
		this.graphicColour = graphicColour;
	}
	
	
	
}
