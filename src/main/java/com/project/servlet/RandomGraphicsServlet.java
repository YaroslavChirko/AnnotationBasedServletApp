package com.project.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.randomgraphics.RandomCubeProvider;
import com.project.randomgraphics.RandomShapeProviderInterface;
import com.project.randomgraphics.elements.Graphic;


@WebServlet("/random")
public class RandomGraphicsServlet extends HttpServlet {
	private static final long serialVersionUID = 238731237398195710L;
	//get width and height from headers later
	private int screenWidth  = 500;
	private int screenHeight = 500;
	private int numberOfCubes = 3;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get shape generator
		//should make bean of generator and autowire it or smth
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
		 graphics = (Graphic[]) req.getAttribute("graphics");
		if(graphics == null) {
			//if arg is not present call the function
			RandomShapeProviderInterface provider = new RandomCubeProvider(screenWidth, screenHeight, numberOfCubes);
			graphics = provider.getGraphic();
		}
		
		//System.out.println(Arrays.deepToString(graphics));
		
		//add argument to the body
		req.setAttribute("graphics", graphics);
		//return jsp page
		RequestDispatcher dispatcher = req.getRequestDispatcher("random-graphics.jsp");
		//dispatcher.include(req,resp);
		dispatcher.forward(req, resp);
	}

}
