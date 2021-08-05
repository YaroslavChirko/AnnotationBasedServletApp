<%@page import="com.project.randomgraphics.elements.Graphic" %>
<%@page import="com.project.randomgraphics.elements.Position" %>
<%@page import="com.project.randomgraphics.elements.Colour" %>
<%@page import="com.project.randomgraphics.elements.Shape" %>

<!DOCTYPE html>
<html>
<head>
<title>
Random Shape page
</title>
</head>
<body>

<%
Graphic [] graphics = (Graphic[])request.getParameterValues("graphics");
 for(int i = 0; i<graphics.length; i++){
	 Graphic current = graphics[i];
	 Colour current_colour = current.getGraphicColour();
	 Position current_position = current.getGraphicShape().getPosition();
	 out.print("<div class=shape_"+i+"></div>");
	 out.print("<style>"
	 +".shape_"+i+"{"
	 +"position: absolute;"
	 +"background-color: rgba("+current_colour.getR()+","
							 +current_colour.getG()+","
							 +current_colour.getB()+","
							 +current_colour.getA()+");"
	 +"margin-top:"+current_position.getY()+";"
	 +"margin-left:"+current_position.getX()+";"
	 +"height:"+current_position.getHeight()+";"
	 +"width:"+current_position.getWidth()+";"
	 +"}</style>");
 }

%>

</body>

</html>