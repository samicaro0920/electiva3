
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.ModeloModFun"%>
<%@page import="general.ControladorGeneral"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HashMap datos = new HashMap();
    ControladorGeneral control = new ControladorGeneral(request, datos); 
    String btnaccion = control.capturarComando();
    ModeloModFun modelo = new ModeloModFun();
    String tabla;
    String campos;

    //if para listar los modulos
    if (btnaccion == null || btnaccion.equalsIgnoreCase("Volver") ||btnaccion.equalsIgnoreCase("listar")) {        
        modelo.listarModulo(datos);
        request.setAttribute("datos", datos);
        pageContext.forward("pagina01.jsp");

    } // Redirecciona a la pagina de insertar modulo
    else if (btnaccion.equalsIgnoreCase("Crear modulo")) {
        pageContext.forward("pagina02.jsp");

    }
    // If para insertar un modulo
    else if (btnaccion.equalsIgnoreCase("Enviar")) {
        control.capturarParametros();
        modelo.crearModulo(datos);
        modelo.listarModulo(datos);
        request.setAttribute("datos", datos);
        pageContext.forward("pagina01.jsp");
    } // If para listar el modulo a modificar
    else if (btnaccion.equalsIgnoreCase("Modificar modulo")) {
        control.capturarParametros();
        modelo.consultarActualizarModulo(datos);        
        HashMap x = (HashMap) datos.get("modulos");
        request.setAttribute("modulos", x);
        pageContext.forward("pagina03.jsp");

    } // If para guardar la modificacion del modulo
    else if (btnaccion.equalsIgnoreCase("Guardar")) {
        control.capturarParametros();
        modelo.modificarModulo(datos);
        modelo.listarModulo(datos);
        request.setAttribute("datos", datos);
        pageContext.forward("pagina01.jsp");
    } // If para eliminar un modulo
    else if (btnaccion.equalsIgnoreCase("Eliminar modulo")) {
        control.capturarParametros();
        modelo.eliminarModulo(datos);
        Iterator it = datos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();            
        }
        modelo.listarModulo(datos);
        request.setAttribute("datos", datos);
        pageContext.forward("pagina01.jsp");

    } // If para listar las funcionalidades de un modulo
    else if (btnaccion.equalsIgnoreCase("Funcionalidades")) {
        control.capturarParametros();
        modelo.listarFuncionalidad(datos);
        request.setAttribute("datos", datos);
        pageContext.forward("pagina04.jsp");
    } // Redirecciona a la pagina de crear funcionalidad
    else if (btnaccion.equalsIgnoreCase("Crear funcionalidad")) {
        control.capturarParametros();
        request.setAttribute("datos", datos);
        pageContext.forward("pagina05.jsp");

    } // If para insertar una nueva funcionalidad
    else if (btnaccion.equalsIgnoreCase("Agregar")) {
        control.capturarParametros();  
          modelo.insertarFuncionalidad(datos);
        request.setAttribute("datos", datos);
         modelo.listarFuncionalidad(datos);
        pageContext.forward("pagina04.jsp");
    } // If que redirecciona a la pagina de modificar
    else if (btnaccion.equalsIgnoreCase("Modificar funcionalidad")) {
        control.capturarParametros();
        modelo.consultarActualizarFuncionalidad(datos);
         HashMap x = (HashMap) datos.get("funcionalidad");
        request.setAttribute("funcionalidad", x);            
        pageContext.forward("pagina06.jsp");

    } // If para modificar la funcionalidad
    else if (btnaccion.equalsIgnoreCase("Modificar")) {
        control.capturarParametros();
        modelo.modificarFuncionalidad(datos);
        modelo.listarFuncionalidad(datos);
        request.setAttribute("datos", datos);
        pageContext.forward("pagina04.jsp");
    } // If para eliminar una funcionalidad
    else if (btnaccion.equalsIgnoreCase("Eliminar funcionalidad")) {
        control.capturarParametros();
        modelo.eliminarFuncionalidad(datos);
        modelo.listarFuncionalidad(datos);
        request.setAttribute("datos", datos);
        pageContext.forward("pagina04.jsp");

    }

%>
