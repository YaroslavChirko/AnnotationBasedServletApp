<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.project.randomgraphics.elements.Graphic" %>
<%@page import="com.project.randomgraphics.elements.Position" %>
<%@page import="com.project.randomgraphics.elements.Colour" %>
<%@page import="com.project.randomgraphics.elements.Shape" %>
<%@page import="com.project.randomgraphics.elements.ShapeType" %>
<%@page import="java.util.Arrays" %>

<!DOCTYPE html>
<html>
<head>
<title>
Random Shape page
</title>
</head>
<body>

<%
Graphic[] graphics = (Graphic[])request.getAttribute("graphics");
if(graphics !=null && graphics.length !=0){
 for(int i = 0; i<graphics.length; i++){
	 Colour current_colour = graphics[i].getGraphicColour();
	 Position current_position = graphics[i].getGraphicShape().getPosition();
	 out.print("<div class=shape_"+i+"></div>");
	 out.print("<style>"
	 +".shape_"+i+"{"
	 +"position: absolute;"
	 +"background-color: rgba("+current_colour.getR()+","
							 +current_colour.getG()+","
							 +current_colour.getB()+","
							 +current_colour.getA()+");"
	 +"margin-top:"+current_position.getY()+"px;"
	 +"margin-left:"+current_position.getX()+"px;"
	 +"height:"+current_position.getHeight()+"px;"
	 +"width:"+current_position.getWidth()+"px;");
	 if(graphics[i].getGraphicShape().getType() == ShapeType.ELLIPSOID){
		 out.print("border-radius: 50%;");
	 }
	 out.print("}</style>");
 }
}else{
	out.print("Found No Graphics");
}


%>

</body>

</html>