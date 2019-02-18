package modelo;

import db.Conexion;
import general.ModeloGeneral;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloModFun extends general.ModeloGeneral {

    Conexion con;

    public ModeloModFun() {
        try {
            con = new Conexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModeloModFun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ModeloModFun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ModeloModFun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModeloModFun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarModulo(HashMap datos) {
        listar("datos", "mo.mod_id,mo.mod_nombre,mo.mod_descripcion", "public.modulo as mo", "", datos);
    }

    public void crearModulo(HashMap datos) {
        insertar("modulo", "mod_id,mod_nombre,mod_descripcion", datos);
    }

    public void consultarActualizarModulo(HashMap datos) {
        listarActualizarForm("modulos", "mod_id,mod_nombre,mod_descripcion", "mod_id,mod_nombre,mod_descripcion", "m.mod_id,m.mod_nombre,m.mod_descripcion", "modulo as m ", "", datos);
    }

    public void modificarModulo(HashMap datos) {
        actualizar("modulo", "mod_id,mod_nombre,mod_descripcion,mod_id", datos);

    }

    public void eliminarModulo(HashMap datos) {
        eliminar("modulo", "mod_id", datos);

    }

    public void insertarFuncionalidad(HashMap datos) {
        insertar("funcionalidad", "fun_id,fun_nombre,fun_ruta,fun_descripcion,mod_id", datos);

    }

    public void eliminarFuncionalidad(HashMap datos) {
        eliminar("funcionalidad", "fun_id", datos);
    } 

    public void consultarActualizarFuncionalidad(HashMap datos) {
        listarActualizarForm("funcionalidad","fun_id,fun_nombre,fun_ruta,fun_descripcion", 
                "fun_id,fun_nombre,fun_ruta,fun_descripcion", "f.fun_id,f.fun_nombre,f.fun_ruta,f.fun_descripcion",
                "funcionalidad as f", "", datos);
    }

    public void modificarFuncionalidad(HashMap datos) {
        
                actualizar("funcionalidad","fun_id,fun_nombre,fun_ruta,fun_descripcion,fun_id" , datos);
    
//        try {
//            String sql;
//            sql = "update funcionalidad set "
//                    + "fun_id='" + datos.get("fun_id") + "', "
//                    + "fun_nombre='" + datos.get("fun_nombre") + "', "
//                    + "fun_ruta='" + datos.get("fun_ruta") + "', "
//                    + "fun_descripcion='" + datos.get("fun_descripcion") + "' "
//                    + "where fun_id='" + datos.get("fun_id") + "' ";
//            int rs;
//            rs = this.conexion.ejecutarSql(sql);
//            if (rs > 0) {
//                datos.put("mensaje", "Actualizado");
//            } else {
//                datos.put("mensaje", "No actualizado");
//            }
////         
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
    }
    public void listarFuncionalidad(HashMap datos) {
        //listar("funcionalidad", "fun_id,fun_nombre,fun_ruta,fun_descripcion", "public.funcionalidad ", "mod_id ", datos);
        try {
            System.out.println("entro");
            String sql;
            ArrayList<HashMap> funcionalidades = new ArrayList<HashMap>();
            HashMap temp;

            sql = "select * "
                    + "from funcionalidad as fu "
                    + "where mod_id='" + datos.get("mod_id") + "' ";

            ResultSet rs;
            rs = this.conexion.consultarSql(sql);
            System.out.println("e" + rs);
            System.out.println("eeeeeeee" + sql);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    temp = new HashMap();

                    temp.put("fun_id", rs.getString("fun_id"));
                    temp.put("fun_nombre", rs.getString("fun_nombre"));
                    temp.put("fun_ruta", rs.getString("fun_ruta"));
                    temp.put("fun_descripcion", rs.getString("fun_descripcion"));

                    funcionalidades.add(temp);
                }
            }            
            datos.put("funcionalidad", funcionalidades);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
