<%@page import="general.ControladorGeneral"%>
<%@page import="modelo.ModeloLogin"%>
<%@page import="java.util.HashMap"%>
<%
    HashMap datos = new HashMap();
    String btnaccion = request.getParameter("btnaccion");
    ModeloLogin modelo = new ModeloLogin();
    ControladorGeneral control = new ControladorGeneral(request, datos);

    if (btnaccion == null || btnaccion.isEmpty()) {
        pageContext.forward("pagina01.jsp");
    } else {
        if (btnaccion.equalsIgnoreCase("Acceder")) {
            try {
                control.capturarParametros();
                if (modelo.verificarUsuario(datos) ) {
                    session = request.getSession(true);
                    session.getId();
                    String name = "si";
                    session.setAttribute("theName", name);
                    session.getAttribute("theName");
                    control.capturarParametros();
                
                    modelo.buscar("listarRoles","ro.rol_id,ro.rol_nombre", "usuario as usu, rol as ro, usuarioxrol as usr", "usu.per_id=usr.per_id and ro.rol_id=usr.rol_id", "usu_usuario", datos);
                    request.setAttribute("datos", datos);
                    pageContext.forward("pagina02.jsp");
                } else {
                    session.invalidate();
                    datos.put("Error", "Usuario o clave incorrectos.!! Por favor,intente de nuevo.");
                    request.setAttribute("datos", datos);
                    pageContext.forward("pagina01.jsp");
                }
            } catch (Exception ex) {
                out.print(ex.getMessage());
            }
        }
        if (btnaccion.equalsIgnoreCase("Cerrar sesion")) {
            session = request.getSession(false);
            if (session != null) {
                session.invalidate();
                datos.put("Error", "Gracias por su visita");
                request.setAttribute("datos", datos);
                pageContext.forward("pagina01.jsp");
            }
        }

        session = request.getSession(true);
        String myname = (String) session.getAttribute("theName");

        if (myname != "si") {
            session.invalidate();
            datos.put("Error", "Acceso no permitido");
            request.setAttribute("datos", datos);
            pageContext.forward("pagina01.jsp");
        } else {
            if (btnaccion.equalsIgnoreCase("Ingresar")) {
                try {
                    control.capturarParametros();
                    modelo.buscarFuncionalidades(datos);
                    request.setAttribute("datos", datos);
                    pageContext.forward("pagina03.jsp");
                } catch (Exception ex) {
                    out.print(ex.getMessage());
                }
            }
            if (btnaccion.equalsIgnoreCase("Cambiar rol")) {
                try {
                    control.capturarParametros();
                    modelo.buscarUsuario(datos);
                    request.setAttribute("datos", datos);
                    pageContext.forward("pagina02.jsp");
                } catch (Exception ex) {
                    out.print(ex.getMessage());
                }
            }
        }
    }
%>
