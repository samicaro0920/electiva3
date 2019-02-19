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
        listarActualizarForm("funcionalidad", "fun_id,fun_nombre,fun_ruta,fun_descripcion",
                "fun_id,fun_nombre,fun_ruta,fun_descripcion", "f.fun_id,f.fun_nombre,f.fun_ruta,f.fun_descripcion",
                "funcionalidad as f", "", datos);
    }

    public void modificarFuncionalidad(HashMap datos) {
        actualizar("funcionalidad", "fun_id,fun_nombre,fun_ruta,fun_descripcion,fun_id", datos);
    }

    public void listarFuncionalidad(HashMap datos) {
        listarr("funcionalidad", "fu.mod_id,fu.fun_id,fu.fun_nombre,fu.fun_ruta,fu.fun_descripcion", "funcionalidad as fu,modulo as mo", "fu.mod_id=mo.mod_id", datos);

    }

}
