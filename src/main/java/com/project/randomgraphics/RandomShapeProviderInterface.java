package com.project.randomgraphics;


import com.project.randomgraphics.elements.Graphic;
import com.project.randomgraphics.elements.ShapeType;

public abstract class RandomShapeProviderInterface {
	public abstract Graphic[] getGraphic();
	protected abstract ShapeType getShape();
}
