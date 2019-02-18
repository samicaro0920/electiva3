<%@page import="general.ModeloGeneral"%>
<%@page import="general.ControladorGeneral"%>
<%@page import="java.sql.Date"%>
<%@page import="modelo.ModeloUsuario"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String seleccion = String.valueOf(request.getParameter("per_id"));
    ModeloUsuario modelo = new ModeloUsuario();
    HashMap datos = new HashMap();
    ControladorGeneral control = new ControladorGeneral(request, datos);
    String btnaccion = control.capturarComando();

    if (btnaccion.equals("Volver") || btnaccion.equals("listar")) {
        modelo.listarUsuario(datos);
        request.setAttribute("datos", datos);
        pageContext.forward("pagina01.jsp");
    } else if (btnaccion.equals("Eliminar")) {
        control.capturarParametros();
        out.print(datos.get("per_id"));
        modelo.eliminarUsuario(datos);
        response.sendRedirect("index.jsp");
    } else if (btnaccion.equals("Enviar")) {
        control.capturarParametros();
        modelo.insertarPersona(datos);
        modelo.insertarUsuario(datos);
        response.sendRedirect("index.jsp");
    } else if (btnaccion.equals("Registrar")) {
        pageContext.forward("pagina02.jsp");
    } else if (btnaccion.equals("Actualizar")) {
        HashMap x;
        control.capturarParametros();
        modelo.listarActulizarForm(datos);
        x = (HashMap) datos.get("valores");
        out.print("-" + datos);
        request.setAttribute("datos", x);
        out.print("+" + datos);
        pageContext.forward("pagina03.jsp");
    } else if (btnaccion.equals("Actualizar_usuario")) {
        control.capturarParametros();
        if (datos.get("usu_clave_old").equals(datos.get("usu_clave"))) {
            String clave = datos.get("usu_clave").toString();
            clave = datos.get("usu_clave_new").toString();
            datos.put("usu_clave", clave);
            modelo.actualizarPersona(datos);
            modelo.actualizarUsuario(datos);
            response.sendRedirect("index.jsp");
        } else {
            out.print("La clave digitada no cincide con la que posee en nuestra base de datos");
            Thread.sleep(1000);
            response.sendRedirect("index.jsp");
        }
    } else if (btnaccion.equals("Permisos")) {       
        control.capturarParametros();
        modelo.listaPersonaPermisos(datos);
        modelo.desplegableUsuRol(datos);
        modelo.desplegableUsuRolExcept(datos);
        request.setAttribute("datos", (HashMap) datos.get("datos"));
        request.setAttribute("seleccion", seleccion);
        request.setAttribute("datos1", datos.get("datos1"));
        request.setAttribute("datos2", datos.get("datos2"));
        pageContext.forward("pagina04.jsp");
    } else if (btnaccion.equals("Quitar")) {
        control.capturarParametros();
        modelo.eliminarPermiso(datos);
        modelo.listaPersonaPermisos(datos);
        modelo.desplegableUsuRol(datos);
        modelo.desplegableUsuRolExcept(datos);
        request.setAttribute("seleccion", seleccion);
        request.setAttribute("datos", ((HashMap) datos.get("datos")));
        request.setAttribute("datos1", datos.get("datos1"));
        request.setAttribute("datos2", datos.get("datos2"));
        pageContext.forward("pagina04.jsp");
    } else if (btnaccion.equals("Asignar")) {
        control.capturarParametros();
        modelo.insertarPermiso(datos);
        modelo.listaPersonaPermisos(datos);
        modelo.desplegableUsuRol(datos);
        modelo.desplegableUsuRolExcept(datos);
        request.setAttribute("seleccion", seleccion);
        request.setAttribute("datos", ((HashMap) datos.get("datos")));
        request.setAttribute("datos1", datos.get("datos1"));
        request.setAttribute("datos2", datos.get("datos2"));
        pageContext.forward("pagina04.jsp");
    }
%>




