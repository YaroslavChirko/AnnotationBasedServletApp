package com.project.randomgraphics;

import java.util.Random;

import com.project.randomgraphics.elements.Circle;
import com.project.randomgraphics.elements.Colour;
import com.project.randomgraphics.elements.Graphic;
import com.project.randomgraphics.elements.ShapeType;

public class RandomCircleProvider extends RandomShapeProviderInterface {
	Graphic[] graphics;
	
	private int screenWidth;
	private int screenHeight;
	
	public RandomCircleProvider(int screenWidth, int screenHeight, int numberOfCircles) {
		if(numberOfCircles ==0) throw new IllegalArgumentException("Cannot instantiate zero cubes");
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		graphics = new Graphic[numberOfCircles];
		initialize();
	}
	
	private void initialize() {
		int numberOfCircles = 0;
		Random random = new Random();
		while(numberOfCircles < this.graphics.length) {
			int x = random.nextInt(this.screenWidth-10);
			int y = random.nextInt(this.screenHeight-10);
			
			int width = random.nextInt(20)+20;
			int height = random.nextInt(20)+20;
			
			if(Math.min(width, height)>0) {
				
				this.graphics[numberOfCircles] = new Graphic(new Circle(x,y,
						Math.min(width,height),
						Math.min(width,height)), 
						new Colour(random.nextInt(255),
								random.nextInt(255),
								random.nextInt(255),
								random.nextFloat()));
				
				numberOfCircles++;
			}
			
		}
	}
	
	@Override
	public Graphic[] getGraphic() {
		return this.graphics;
	}

	@Override
	protected ShapeType getShape() {
		return ShapeType.ELLIPSOID;
	}


}
