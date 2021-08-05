package com.project.randomgraphics;

import java.util.Random;

import com.project.randomgraphics.elements.Colour;
import com.project.randomgraphics.elements.Graphic;
import com.project.randomgraphics.elements.ShapeType;
import com.project.randomgraphics.elements.Square;

public class RandomCubeProvider extends RandomShapeProviderInterface{
	private Colour colour;
	private Graphic[] graphics;
	
	private int screenWidth;
	private int screenHeight;
	
	public RandomCubeProvider(int screenWidth, int screenHeight, int numberOfCubes){
		if(numberOfCubes ==0) throw new IllegalArgumentException("Cannot instantiate zero cubes");
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		graphics = new Graphic[numberOfCubes];
	}
	
	{
		int numberOfCubes = 0;
		Random random = new Random();
		while(graphics.length-1>numberOfCubes) {
		int x = random.nextInt(screenWidth);
		int y = random.nextInt(screenHeight);
		
		int width = random.nextInt(screenWidth-x-10)+screenWidth;
		int height = random.nextInt(screenHeight-y-10)+screenHeight;
		
		
			if(Math.min(width,height)>0) {
				colour = new Colour(random.nextInt(255),random.nextInt(255),random.nextInt(255));
				
				graphics[numberOfCubes] = new Graphic(new Square(x,y,Math.min(width,height),
						Math.min(width,height)),
						colour);
				numberOfCubes++;
			}
		}
		
		
	}
	
	@Override
	public Graphic[] getGraphic() {
		return this.graphics;
	}

	@Override
	protected ShapeType getShape() {
		return ShapeType.SQUARE;
	}

	@Override
	protected Colour getColour() {
		return this.colour;
	}
	
}
