package general;

import java.util.ArrayList;
import java.util.HashMap;

public class VistaGeneral {

    public VistaGeneral() {
    }
   // metodo que genera un combobox recibiendo un arraly de hashmap con los datos, un string de recibe de el valor que quiere que lleve el value, muestra que es el valor que muestra dento del los option, y nombre_select que es el nomre del desplegable 
    /**
     * 
     * @param datos array de HashMap que contiene la informacion necesaria del request
     * @param recibe es el campo de la base de datos que va a tener por valor los option en cada atributo value
     * @param muestra es el campo de la base de datos que va a mostrar cada uno de los option
     * @param nombre_select es el nombre del select que queremos generar
     * @return devulve un String que contienen la instruccion completa html de un select con sus respectivos option
     * 
     */
    public StringBuilder generarComboBox(ArrayList<HashMap> datos,String recibe,String muestra,String nombre_select)
    {
        StringBuilder html=new StringBuilder("<select name=");
        html.append(nombre_select).append(" size=").append(datos.size()).append(">");
        for (int i = 0; i < datos.size(); i++) {
            html.append("<option value=").append(datos.get(i).get(recibe)).append(">").append(datos.get(i).get(muestra)).append("</option>");
        }
        html.append("</select>");
        System.out.println("la estructura del select es: \n"+html);
        return html;
    }
    
    /**
     * 
     * @param y array de HashMap que contiene la informacion necesaria del request 
     * @param cabecera_tipo vector con la informacion de los campos de la tabla y el tipo de campo defecto o radio
     * @return devulve un String que contienen la instruccion completa html de la tabla completa
     * 
     */
    public StringBuilder generarTablaRadio(ArrayList<HashMap> y,String... cabecera_tipo)
    {
        //cabecera_tipo.equals("Nombre");
        ArrayList<String> array_particionado = new ArrayList<>();
        StringBuilder html=new StringBuilder("<table><thead><tr>");
        for (int i = 0; i < cabecera_tipo.length; i++) {
            String[] aux=cabecera_tipo[i].split("-");
            for (int j = 0; j < aux.length; j++) {
                array_particionado.add(aux[j]);
                if(j==0)
                    html.append("<th>").append(aux[j]).append("</th>");               
            }
        }
        html.append("</tr></thead><tbody>");
        for (int i = 0; i < y.size(); i++) {
            html.append("<tr>");
            for (int j = 0; j < array_particionado.size(); j=j+2) {
               if(array_particionado.get(j+1).equalsIgnoreCase("defecto"))
                {
                    html.append("<td>").append(y.get(i).get(array_particionado.get(j))).append("</td>");
                    System.out.println(y.get(i).get(array_particionado.get(j)));
                }
                else if(array_particionado.get(j+1).equalsIgnoreCase("radio")) 
                {
                    html.append("<td>").append("<input type='radio' name=").
                        append(array_particionado.get(j)).append(" value=").
                        append(y.get(i).get(array_particionado.get(j+2))).append(" ></td>");
                    j=j+3;
                } 
            }
            html.append("</tr>");
        }
        html.append("</tbody></table>");
        return html;
    }
    
    
     public StringBuilder ListarActializarForm(ArrayList<HashMap> y,String... cabecera_tipo)
    {
        
        ArrayList<String> array_particionado = new ArrayList<>();
        StringBuilder html=new StringBuilder("<table><thead><tr>");
        for (int i = 0; i < cabecera_tipo.length; i++) {
            String[] aux=cabecera_tipo[i].split("-");
            for (int j = 0; j < aux.length; j++) {
                array_particionado.add(aux[j]);
                if(j==0)
                    html.append("<th>").append(aux[j]).append("</th>");               
            }
        }
        html.append("</tr></thead><tbody>");
        for (int i = 0; i < y.size(); i++) {
            html.append("<tr>");
            for (int j = 0; j < array_particionado.size(); j=j+2) {
               if(array_particionado.get(j+1).equalsIgnoreCase("defecto"))
                {
                    html.append("<td>").append(y.get(i).get(array_particionado.get(j))).append("</td>");
                    System.out.println(y.get(i).get(array_particionado.get(j)));
                }
                else if(array_particionado.get(j+1).equalsIgnoreCase("radio")) 
                {
                    html.append("<td>").append("<input type='radio' name=").
                        append(array_particionado.get(j)).append(" value=").
                        append(y.get(i).get(array_particionado.get(j+2))).append(" ></td>");
                    j=j+3;
                } 
            }
            html.append("</tr>");
        }
        html.append("</tbody></table>");
        return html;
    }
    
}
