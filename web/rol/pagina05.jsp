
<%@page import="general.VistaGeneral"%>
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

    String rol_id = (String) datos.get("rol_id");
    String mod_id = (String) datos.get("mod_id");

    String eliminar = (String) datos.get("Eliminar");
    String seleccion = (String) datos.get("seleccion");

    String agregar = (String) datos.get("Agregar");
    String seleccion2 = (String) datos.get("seleccion2");
%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gestionar Funcionalidades</h1>
        <form action="index.jsp" method="get">
            <br>
            <%
                
                String rol_nombre;
                String rol_descripcion;
                String mod_nombre;
                String mod_descripcion;
                String fun_id;
                String fun_nombre;
            %>

            <%
                System.out.println("Agregar es :" + agregar);
                System.out.println("Eliminar es :" + eliminar);
            %>

            <%
                //-------------Mostar ROL----------------
                ArrayList<HashMap> listarol;
                listarol = (ArrayList<HashMap>) datos.get("listarol");

                rol_nombre = (String) listarol.get(0).get("rol_nombre");
                rol_id = (String) listarol.get(0).get("rol_id");
                rol_descripcion = (String) listarol.get(0).get("rol_descripcion");
                out.println("Rol: " + rol_nombre + "<br>");

                //-------------Mostar MODULO--------------
                ArrayList<HashMap> listamodulo;
                listamodulo = (ArrayList<HashMap>) datos.get("listamod");
                mod_nombre = (String) listamodulo.get(0).get("mod_nombre");
                mod_id = (String) listamodulo.get(0).get("mod_id");
                mod_descripcion = (String) listamodulo.get(0).get("mod_descripcion");
                out.println("Modulo: " + mod_nombre + "<br>");
                out.println("<br>");

                //---------Listar Funcionalidades----------
                ArrayList<HashMap> listafuns;
                listafuns = (ArrayList<HashMap>) datos.get("listafuns");

            %>

            <input type="hidden" name="rol_id" value= '<%out.print(rol_id);%>' >  
            <input type="hidden" name="mod_id" value= '<%out.print(mod_id);%>' >
            

            <br>

            <%
                //--------Listar Funcionalidades Faltantes-------

                ArrayList<HashMap> listanofuns;
                listanofuns = (ArrayList<HashMap>) datos.get("listanofuns");
                
            %>
            
            <table>
                <tr>
                    <th>
                            <%
                            VistaGeneral vista=new VistaGeneral();
                            String html=vista.generarComboBox(listafuns,"fun_id","fun_nombre","seleccion").toString();
                            out.print(html);
                            %>
                    </th>
                    <th>
                        <div>
                            <input name="btnaccion" type="submit" value="Eliminar-->"/>
            
                           
                        </div>
                        <br>
                        <div>
                            <input name="btnaccion" type="submit" value="Agregar<--"/>  
                            
                        </div>
                    </th>
                    <th>
                        <%
                            String html2=vista.generarComboBox(listanofuns,"fun_id","fun_nombre","fun_id").toString();
                            out.print(html2);
                        %>
                    </th>
                 </tr>
            </table>
            <br>
            <br>
            <input name="btnaccion" type="submit" value="Volver"  /> 
        </form>

</html>
