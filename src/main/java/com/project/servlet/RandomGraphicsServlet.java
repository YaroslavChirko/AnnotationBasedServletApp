package com.project.servlet;

import java.io.IOException;

import com.project.randomgraphics.RandomCubeProvider;
import com.project.randomgraphics.RandomShapeProviderInterface;
import com.project.randomgraphics.elements.Graphic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/random")
public class RandomGraphicsServlet extends HttpServlet {
	private static final long serialVersionUID = 238731237398195710L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get shape generator
		RandomShapeProviderInterface provider = new RandomCubeProvider(200,200,10);
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
			RandomShapeProviderInterface provider = new RandomCubeProvider(200,200,10);
			graphics = provider.getGraphic();
		}
		
		//add argument to the body
		req.setAttribute("graphics", graphics);
		//return jsp page
		req.getRequestDispatcher("random-graphics.jsp").include(req,resp);
	}

}
