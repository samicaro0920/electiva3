
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="modelo.ModeloRol"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HashMap datos = new HashMap();
    datos = (HashMap) request.getAttribute("datos");  
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Elija el modulo</h1>
        <%                
                    ArrayList<HashMap> listamodulos;
                    listamodulos = (ArrayList<HashMap>) datos.get("datos");
                    String rol_id = (String)datos.get("rol_id");
                    %>
        <form action="index.jsp" method="get">
            <select name="mod_id" id="mod_id">
                <%!
                    String mod_id;
                    String mod_nombre;
                    String mod_descripcion;
                %>
                <%
                  
                    for (int i = 0; i < listamodulos.size(); i++) {
                        mod_nombre = (String) listamodulos.get(i).get("mod_nombre");
                        mod_id = (String) listamodulos.get(i).get("mod_id");
                        mod_descripcion = (String) listamodulos.get(i).get("mod_descripcion");
                %>
                        <option value= "<%=mod_id%>"><%=mod_nombre%></option>
                <%
                    }
                                       
                %>
            </select>
            
            <input type="hidden" name="rol_id" value= '<%out.print(rol_id);%>' >  

            <input name="btnaccion" type="submit" value="Volver"  /> 

            <input type="submit" name="btnaccion" value="Permisosrol" /> 
            
        </form>
    </body>
</html>
