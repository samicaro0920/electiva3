
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    HashMap datos = new HashMap();
    datos = (HashMap)request.getAttribute("datos");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionlidades</title>
    </head>
    <body>
        <form action="index.jsp" method="get">
        <h1>funcionalidades!</h1>
        <table>
            <thead>
            <tr>
                <th></th>
                <th>Id</th>
                <th>Nombre</th>
                <th>Ruta</th>
                <th>Descripcion</th>
            </tr>
            </head>
            <tbody>
        <% 
            
                    
            int i;
            ArrayList<HashMap> temp;
            temp = (ArrayList) datos.get("funcionalidad");
            for (i = 0; i < temp.size(); i++) {
                out.print("<tr>");
                out.print("<td>");
                out.print("<input type='radio' name='fun_id' value='" + temp.get(i).get("fun_id")+"'>");
                out.print("</td>");
                out.print("<td>");
                out.print(temp.get(i).get("fun_id"));
                out.print("</td>");
                out.print("<td>");
                out.print(temp.get(i).get("fun_nombre"));
                out.print("</td>");
                out.print("<td>");
                out.print(temp.get(i).get("fun_ruta"));
                out.print("</td>");
                out.print("<td>");
                out.print(temp.get(i).get("fun_descripcion"));
                out.print("</td>");
                out.print("</tr>");
            }

        %>
        </tbody>
        </table>
        <input type="hidden" name="mod_id" id="mod_id"  size="50" maxlength="30" value="<%=datos.get("mod_id")%>"/>
        <input type="submit" value="Crear funcionalidad" name="btnaccion" />
        <input type="submit" value="Modificar funcionalidad" name="btnaccion" />
        <input type="submit" value="Eliminar funcionalidad" name="btnaccion" />
        </form>
        
    </body>
</html>
