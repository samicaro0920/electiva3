
<%@page import="java.util.ArrayList"%>
<%@page import="general.VistaGeneral"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HashMap datos = (HashMap) request.getAttribute("datos");
    ArrayList<HashMap> temp = (ArrayList<HashMap>) datos.get("datos");
    VistaGeneral vista = new VistaGeneral();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="index.jsp" method="post">    
            <%
                String html = vista.generarTablaRadio(temp, "per_id-defecto", "per_nombre-defecto", "usu_usuario-defecto", "per_id-radio-per_id").toString();
                out.print(html);
            %>

            <input name="btnaccion" type="submit" value="Registrar"  /> 

            <input name="btnaccion" type="submit" value="Eliminar"  />

            <input name="btnaccion" type="submit" value="Actualizar" />

            <input name="btnaccion" type="submit" value="Permisos" />

        </form>

    </body>
</html>