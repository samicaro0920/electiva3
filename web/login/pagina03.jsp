<%@page import="java.util.ArrayList"%>
<%@page import="modelo.ModeloLogin"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pagina03</title>
    </head>
     <style>
      ul {
  display: flex;
  flex-direction: column;
  align-items: center;
}
    </style>
    <body>
    <center>
        <h3>LISTA DE FUNCIONALIDADES</h3>
        <hr>
      
            <%
                try {
                    HashMap datos = new HashMap();
                    datos = (HashMap) request.getAttribute("datos");

                    ArrayList<HashMap> listarFuncionalidad = (ArrayList) datos.get("listarFuncionalidades");
                    ArrayList mod = new ArrayList();

                    for (int i = 0; i < listarFuncionalidad.size(); i++) {
                        mod.add(listarFuncionalidad.get(i).get("mod_nombre"));
                    }
                    int i = 0;

                    while (i < mod.size()) {
                        int ii = 1 + i;
                        while (ii < mod.size()) {
                            if (mod.get(i).equals(mod.get(ii))) {
                                mod.remove(i);
                                ii--;
                            }
                            ii++;

                        }
                        i++;
                    }
            %>

            <%
                HashMap fun;
                for (int l = 0; l < mod.size(); l++) {
                    if (listarFuncionalidad.size() != 0) {
            %>

            <%
                out.print("MODULO : " + mod.get(l).toString().toUpperCase());
                String m = null;

                for (int k = 0; k < listarFuncionalidad.size(); k++) {
                    fun = listarFuncionalidad.get(k);
                    if (mod.get(l).equals(fun.get("mod_nombre"))) {
                        out.print("<tr><td>");
            %>
            <ul class="ul">
                <a href="#">
                    <li >
                        <font size="4"><%  out.print(fun.get("fun_nombre")); %> </font>
                    </li>
                </a>
            </ul>
            <%

                    }
                }
            %>
        </table>
        <%
            int aux = Integer.parseInt(request.getParameter("aux").trim());
            if (aux != 1) {
        %>

        <%
            }
        %>

        <%
                } else {
                    out.print("=== Sin informacion ===<br>");
                }
            }
        %>
        <form name="form1" method="POST" action="index.jsp">
            <input type="hidden" name="usu_usuario" value="<%=datos.get("usu_usuario")%>"/>
            <br>
            <input type="submit" name="btnaccion" value="Cambiar rol"/> 
        </form>
        <%
        } catch (Exception e) {
//                out.print(e.getMessage());
        %>
        <form name="form2" action="index.jsp" method="POST">
            <input type="hidden" name="btnaccion" value=""/>
        </form>
        <script>
            document.form2.submit();
        </script>
        <%
            }
        %>
        <hr>
        <form name="form3" action="index.jsp" method="POST">
            <input type="submit" name="btnaccion" value="Cerrar sesion"/>
        </form>
    </center>
</body>
</html>
