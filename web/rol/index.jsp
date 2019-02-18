<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="modelo.ModeloRol"%>
<%@page import="general.ControladorGeneral"%>
<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HashMap datos = new HashMap();
    ModeloRol modelo = new ModeloRol();
    ControladorGeneral control = new ControladorGeneral(request, datos);
    String btnaccion = control.capturarComando();

    if (btnaccion == null || btnaccion.equalsIgnoreCase("Volver") || btnaccion.equalsIgnoreCase("listar")) {
        modelo.listarRol(datos);
        request.setAttribute("datos", datos);
        pageContext.forward("pagina01.jsp");
    }

    if (btnaccion.equalsIgnoreCase("Crear")) {
        pageContext.forward("pagina02.jsp");
    }

    if (btnaccion.equalsIgnoreCase("Eliminar")) {
        control.capturarParametros();
        modelo.eliminarRol(datos);
        modelo.listarRol(datos);
        request.setAttribute("datos", datos);
        pageContext.forward("pagina01.jsp");
    }

    if (btnaccion.equalsIgnoreCase("Modificar")) {
         HashMap x;
        control.capturarParametros();
        modelo.listarActualizarRol(datos);
        x = (HashMap) datos.get("listarol");
        request.setAttribute("listarol", x);
        pageContext.forward("pagina03.jsp");
    }

    if (btnaccion.equalsIgnoreCase("Permisos")) {
        control.capturarParametros();
        modelo.listarModulo(datos);
        request.setAttribute("datos", datos);
        pageContext.forward("pagina04.jsp");
    }

    if (btnaccion.equalsIgnoreCase("Permisosrol")) {
        control.capturarParametros();
        modelo.listarActualizarRol(datos);
        modelo.listarModulo(datos);
        modelo.listarFuncionalidad(datos);
        modelo.listarActualizarFuncionalidad(datos);
        request.setAttribute("datos", datos);
        pageContext.forward("pagina05.jsp");
    }

    if (btnaccion.equalsIgnoreCase("Modificarrol")) {
        control.capturarParametros();
        modelo.modificarRol(datos);
        modelo.listarRol(datos);
        request.setAttribute("datos", datos);
        pageContext.forward("pagina01.jsp");
    }

    if (btnaccion.equalsIgnoreCase("Crearrol")) {
        control.capturarParametros();
        modelo.insertarRol(datos);
        modelo.listarRol(datos);
        request.setAttribute("datos", datos);
        pageContext.forward("pagina01.jsp");
    }

    if (btnaccion.equalsIgnoreCase("Eliminar-->")) {
        control.capturarParametros();
        modelo.eliminarRolFun(datos);
        modelo.listarRol(datos);
        modelo.listarModulo(datos);
        modelo.listarFuncionalidad(datos);
        modelo.listarActualizarFuncionalidad(datos);
        request.setAttribute("datos", datos);
        pageContext.forward("pagina05.jsp");
    }

    if (btnaccion.equalsIgnoreCase("Agregar<--")) {
        control.capturarParametros();
        modelo.insertarRolFun(datos);
        modelo.listarRol(datos);
        modelo.listarModulo(datos);
        modelo.listarFuncionalidad(datos);
        modelo.listarActualizarFuncionalidad(datos);
        request.setAttribute("datos", datos);
        pageContext.forward("pagina05.jsp");
    }
%>
