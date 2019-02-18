package general;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

public class ControladorGeneral {

    private HttpServletRequest request;
    private HashMap datos;
    
    public ControladorGeneral(HttpServletRequest request, HashMap datos) {
        this.datos=datos;
        this.request=request;
    }
    
    public void capturarParametros()
    {
       HashMap mapa = (HashMap) this.request.getParameterMap();
       for (Object nom_parametro: mapa.keySet())
       {
           System.out.println(mapa.keySet());
           String nombre = (String)nom_parametro;
           String[] valor = (String[])mapa.get(nombre);
           for (int i = 0; i < valor.length; i++) {
               System.out.println("parametro " + nombre + " : " + valor[i]);
               this.datos.put(nombre, valor[i]);
           } 
       }
        System.out.println(this.datos);
    }
    
    public String capturarComando()
    {
       String btnaccion = request.getParameter("btnaccion");
       if (btnaccion == null){
           btnaccion = "listar";
       }
       else{
           btnaccion.trim().toLowerCase();
       }
       return btnaccion;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HashMap getDatos() {
        return datos;
    }

    public void setDatos(HashMap datos) {
        this.datos = datos;
    }
    
    
    
}
