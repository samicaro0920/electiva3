<%-- 
    Document   : index
    Created on : 19-feb-2019, 0:24:19
    Author     : Sandra Cañas
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Grupo JSP</h1>
        <a href="./login">Login</a>
        <br>
        <a href="./modulo_funcionalidad">Gestion de Modulos y Funcionalidades</a>
        <br>
        <a href="./rol">Gestion de Roles</a>
        <br>
        <a href="./usuario">Gestion de Usuarios</a>
        <p>
            <%
                String error = request.getParameter("error");
                if (error != null) {
                    if (error.equalsIgnoreCase("Usuario o clave incorrectos.!! Por favor,intente de nuevo.") || error.equalsIgnoreCase("acceso no permitido")) {
                        out.print("<font color='red'>" + request.getParameter("error") + "</font>");
                    } else {
                        out.print("<font color='green'>" + request.getParameter("error") + "</font>");
                    }
                }
            %>
    </center>
    </body>
</html>
