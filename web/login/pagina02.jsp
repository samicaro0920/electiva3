<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="modelo.ModeloLogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%    String rols = "";
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pagina02</title>
    </head>
    <body>
    <center>
        <hr>
        <h3>LISTA DE ROLES</h3>
        <hr>
        <form name="form1" action="index.jsp" method="POST" autocomplete="off">
            <%
                try {
                    HashMap datos = new HashMap();
                    datos = (HashMap) request.getAttribute("datos");

                    ArrayList<HashMap> listarRoles = (ArrayList) datos.get("listarRoles");
                    HashMap rol;

                    if (listarRoles.size() != 0) {
                        if (listarRoles.size() >= 2) {
                                %>
                                        <input type="hidden" name="usu_usuario" value="<%= datos.get("usu_usuario")%>"/>
                                        <input type="hidden" name="aux" value="2"/>
                                        <select name="ro.rol_id" required="Campo obligatorio">
                                            <option value="" selected="">--- Seleccione una opcion ---</option>
                                            <%
                                                for (int i = 0; i < listarRoles.size(); i++) {
                                                    rol = listarRoles.get(i);
                                            %>
                                            <option value="<%=rol.get("rol_id")%>"><%=rol.get("rol_nombre")%></option> 
                                            <%
                                                }
                                            %>
                                        </select>
                                        <p>
                                            <input type="submit" name="btnaccion" value="Ingresar"/>
                                <%
                        } else {
                            for (int i = 0; i < listarRoles.size(); i++) {
                                rol = listarRoles.get(i);
                                rols = (String) rol.get("rol_id");
                            }
                            %>
                            <input type="hidden" name="usu_usuario" value="<%= datos.put("usu_usuario", rols) %>"/>
                            <input type="hidden" name="ro.rol_id" value="<%= rols%>"/>
                            <input type="hidden" name="aux" value="<%= listarRoles.size()%>"/>
                            <input type="hidden" name="btnaccion" value="Ingresar"/>
                            <script>
                                document.form1.submit();
                            </script>
                            <%

                        }
                    } else {
                        out.print("Sin informacion");
                    }

                } catch (Exception ex) {

                    %>
                    <input type="hidden" name="btnaccion" value=""/>
                    <script>
                        document.form1.submit();
                    </script>
                    <%
                }
            %>
        </form>
        <hr>
        <form action="index.jsp" method="POST">
            <input type="submit" name="btnaccion" value="Cerrar sesion" />
        </form>
    </center>
</body>
</html>
