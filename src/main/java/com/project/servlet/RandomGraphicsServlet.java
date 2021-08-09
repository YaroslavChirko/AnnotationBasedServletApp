package com.project.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.randomgraphics.RandomCircleProvider;
import com.project.randomgraphics.RandomCubeProvider;
import com.project.randomgraphics.RandomShapeProviderInterface;
import com.project.randomgraphics.elements.Graphic;
import com.project.randomgraphics.elements.ShapeType;


@WebServlet("/random")
public class RandomGraphicsServlet extends HttpServlet {
	private static final long serialVersionUID = 238731237398195710L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get shape generator
		//should make bean of generator and autowire it or smth
		int screenWidth = Integer.parseInt(req.getServletContext().getInitParameter("screen-width"));
		int screenHeight = Integer.parseInt(req.getServletContext().getInitParameter("screen-height"));
		int numberOfCubes = Integer.parseInt(req.getServletContext().getInitParameter("number-of-cubes"));
		
		
		RandomShapeProviderInterface provider = new RandomCubeProvider(screenWidth, screenHeight, numberOfCubes);
		//call function to generate the shapes
		Graphic [] graphics = provider.getGraphic();
		
		req.setAttribute("graphics", graphics);
		
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Graphic[] graphics;
		//check for the argument
		//add cast check later
		
		int screenWidth = Integer.parseInt(req.getServletContext().getInitParameter("screen-width"));
		int screenHeight = Integer.parseInt(req.getServletContext().getInitParameter("screen-height"));
		int numberOfCubes = Integer.parseInt(req.getServletContext().getInitParameter("number-of-cubes"));
		
		 graphics = (Graphic[]) req.getAttribute("graphics");
		if(graphics == null) {
			//if arg is not present call the function
			RandomShapeProviderInterface provider = new RandomCubeProvider(screenWidth, screenHeight, numberOfCubes);
			graphics = provider.getGraphic();
		}
		
		//add argument to the body (with added circles)
		req.setAttribute("graphics", addCircles(graphics, screenWidth, screenHeight));
		
		//return jsp page
		RequestDispatcher dispatcher = req.getRequestDispatcher("random-graphics.jsp");
		//dispatcher.include(req,resp);
		dispatcher.forward(req, resp);
	}
	
	// for now it's used to add circles since filter won`t work like this
	private Graphic[] addCircles(Graphic[] graphics, int screenWidth, int screenHeight) {
		if(graphics != null && graphics.length>1
				&&Arrays.stream(graphics).noneMatch(e->e.getGraphicShape().getType()==ShapeType.ELLIPSOID)) {
			RandomCircleProvider provider= new RandomCircleProvider(screenWidth,screenHeight,
					(new Random()).nextInt(graphics.length)+1);
			//concat using stream, can use some other method later
			graphics = Stream.concat(Arrays.stream(graphics), Arrays.stream(provider.getGraphic())).toArray(Graphic[]::new);
		}
		return graphics;
	}
}
