
package general;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
/**
 * Esta clase se encarga de controlar todos los datos provenientes de los index,formularios y de los modelos
 * @author Sandra Cañas, John Acevedo, Edilberto Mejía 
 */
public class ControladorGeneral {

    public HttpServletRequest request;
    public HashMap datos;
    /**
     * 
     * @param request Recibe btnaccion
     * @param datos   Recibe un HashMap con los datos provenientes de los modelos,intex o paginas
     */
    public ControladorGeneral(HttpServletRequest request, HashMap datos) {
        this.datos=datos;
        this.request=request;
    }
    
    /**
     * Método que se encarga de capturar los parámetros y ponerlos en un HashMap 
     */
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
    }
    
    /**
     * Método que captura el botón btnaccion y si viene con valor "null" llama al método listar de
     * ModeloGeneral
     * @return  Devuelve el valor de btnaccion
     */
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
/**
 * Metodo que obtiene los datos de los formularios
 * @return Devuelve un objeto HttpServletRequest con los datos
 */
    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Metodo que obtiene los datos del HashMap
     * @return HashMap de Datos
     */
    public HashMap getDatos() {
        return datos;
    }

    /**
     * Metodo que asigna los datos en el HashMap
     * @param datos
     */
    public void setDatos(HashMap datos) {
        this.datos = datos;
    }          
}
