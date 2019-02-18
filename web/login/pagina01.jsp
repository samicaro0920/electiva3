<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <form method="POST" action="index.jsp" name="form1">
            <fieldset style="width: 20%">
                <legend>Acceso a la plataforma</legend>
                <p>
                    <label>Usuario</label>
                    <br>
                    <input type="text" name="usu_usuario" value="">
                <p>
                    <label>Clave</label>
                    <br>
                    <input type="password" name="usu_clave" value="">
                <p>
                    <input type="reset" name="limpiar" value="Limpiar">
                    <input type="submit" name="btnaccion" value="Acceder"><br>
                    <%
                        HashMap datos = new HashMap();
                        datos = (HashMap) request.getAttribute("datos");
                        if (datos != null) {
                            if (datos.get("Error").toString().equalsIgnoreCase("Usuario o clave incorrectos.!! Por favor,intente de nuevo.") || datos.get("Error").toString().equalsIgnoreCase("acceso no permitido")) {
                                out.print("<font color='red'>" + datos.get("Error") + "</font>");
                            } else {
                                out.print("<font color='green'>" + datos.get("Error") + "</font>");
                            }
                        }
                    %>
            </fieldset>
        </form>
    </center>
</body>
</html>