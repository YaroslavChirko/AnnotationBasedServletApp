package com.project.randomgraphics;

import java.util.Random;

import com.project.randomgraphics.elements.Colour;
import com.project.randomgraphics.elements.Graphic;
import com.project.randomgraphics.elements.ShapeType;
import com.project.randomgraphics.elements.Square;

public class RandomCubeProvider extends RandomShapeProviderInterface{
	private Graphic[] graphics;
	
	private int screenWidth;
	private int screenHeight;
	
	public RandomCubeProvider(int screenWidth, int screenHeight, int numberOfCubes){
		if(numberOfCubes ==0) throw new IllegalArgumentException("Cannot instantiate zero cubes");
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		graphics = new Graphic[numberOfCubes];
		initialize();
	}
	
	private void initialize(){
		int numberOfCubes = 0;
		Random random = new Random();
		while(graphics.length>numberOfCubes) {
		int x = random.nextInt(screenWidth-10);
		int y = random.nextInt(screenHeight-10);
		
		int width = random.nextInt(20)+20;
		int height = random.nextInt(20)+20;
		
		
			if(Math.min(width,height)>0) {
				
				
				graphics[numberOfCubes] = new Graphic(new Square(x,y,Math.min(width,height),
						Math.min(width,height)),
						new Colour(random.nextInt(255),
								random.nextInt(255),random.nextInt(255),
								random.nextFloat()));
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

	
	
}
