package com.project.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.project.randomgraphics.RandomCircleProvider;
import com.project.randomgraphics.elements.Graphic;
import com.project.randomgraphics.elements.ShapeType;

/*
 * This filter isn`t used properly as of yet, can be used during redirects but this app has no forward to 
 * random, so the if statement will always be false in graphics != null
 */
@WebFilter("/random")
public class CircleFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			Graphic[] graphics = (Graphic[])request.getAttribute("graphics");
			//stream is used to check if we already added any circles
			if(graphics != null && graphics.length>1
					&&Arrays.stream(graphics).noneMatch(e->e.getGraphicShape().getType()==ShapeType.ELLIPSOID)) {
				int screenWidth = Integer.parseInt(request.getServletContext().getInitParameter("screen-width"));
				int screenHeight = Integer.parseInt(request.getServletContext().getInitParameter("screen-height"));
				
				RandomCircleProvider provider= new RandomCircleProvider(screenWidth, screenHeight,
						(new Random()).nextInt(graphics.length)+1);
				//concat using stream, can use some other method later
				request.setAttribute("graphics", 
				Stream.concat(Arrays.stream(graphics), Arrays.stream(provider.getGraphic())).toArray());
			System.out.println("filtered");
			}
			System.out.println("in filter");
		chain.doFilter(request, response);

	}

}
