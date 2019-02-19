/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import db.Conexion;
import general.ModeloGeneral;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloRol extends ModeloGeneral {

    Conexion con;

    public ModeloRol() {
        try {

            con = new Conexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModeloRol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ModeloRol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ModeloRol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModeloRol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarRol(HashMap x) {
        listar("datos", "ro.rol_id,ro.rol_nombre,ro.rol_descripcion", "public.rol as ro", "", x);
    }

    public void eliminarRol(HashMap datos) {
        eliminar("rol", "rol_id", datos);
    }

    public void insertarRol(HashMap datos) {
        insertar("rol", "rol_id,rol_nombre,rol_descripcion", datos);
    }

    public void listarActualizarRol(HashMap datos) {
        listarActualizarForm("listarol", "id,nombre,descripcion",
                "rol_id,rol_nombre,rol_descripcion", "r.rol_id",
                "rol ", "", datos);
    }

    public void modificarRol(HashMap datos) {
        actualizar("public.rol", "rol_id,rol_nombre,rol_descripcion", datos);
    }

    public void listarModulo(HashMap datos) {
        listar("datos", "mo.mod_nombre,mo.mod_id,mo.mod_descripcion", "public.modulo as mo", "", datos);
    }

    public void insertarRolFun(HashMap datos) {
        insertar("public.rolxfuncionalidad", "rol_id,fun_id", datos);
    }

    public void listarActualizarModulo(HashMap datos) {
        try {
            String mod_id;
            String mod_nombre;
            String mod_descripcion;
            mod_id = (String) datos.get("mod_id");
            String strsql = "SELECT * FROM public.modulo where mod_id='" + mod_id + "';";
            ResultSet rsmod;
            rsmod = con.consultarSql(strsql);
            ArrayList<HashMap> listamod;
            listamod = new ArrayList<HashMap>();
            HashMap h;
            while (rsmod.next()) {
                h = new HashMap();
                h.put("mod_id", rsmod.getString("mod_id"));
                h.put("mod_nombre", rsmod.getString("mod_nombre"));
                h.put("mod_descripcion", rsmod.getString("mod_descripcion"));
                listamod.add(h);
            }
            datos.put("listamod", listamod);
        } catch (SQLException ex) {
            System.out.println("se genero un error al listar el rol");
        }
    }

    public void listarFuncionalidad(HashMap datos) {
        try {
            String rol_id;
            String mod_id;
            rol_id = (String) datos.get("rol_id");
            mod_id = (String) datos.get("mod_id");
            String strsql = "SELECT * "
                    + "FROM public.modulo, public.rol, public.funcionalidad, public.rolxfuncionalidad "
                    + "where rol.rol_id = rolxfuncionalidad.rol_id and modulo.mod_id = funcionalidad.mod_id and rolxfuncionalidad.fun_id = funcionalidad.fun_id and rol.rol_id = '" + rol_id + "' and modulo.mod_id = '" + mod_id + "'";

            ResultSet rsfuns;
            rsfuns = con.consultarSql(strsql);
            ArrayList<HashMap> listafuns;
            listafuns = new ArrayList<HashMap>();
            HashMap h;
            while (rsfuns.next()) {
                h = new HashMap();
                h.put("fun_id", rsfuns.getString("fun_id"));
                h.put("fun_nombre", rsfuns.getString("fun_nombre"));
                listafuns.add(h);
            }
            datos.put("listafuns", listafuns);
        } catch (SQLException ex) {
            System.out.println("se genero un error al listar la funcionalidad");
        }
    }

    public void listarActualizarFuncionalidad(HashMap datos) {
        try {
            String rol_id;
            String mod_id;
            rol_id = (String) datos.get("rol_id");
            mod_id = (String) datos.get("mod_id");
            String strsql = "Select * "
                    + "from public.funcionalidad "
                    + "where funcionalidad.mod_id = '" + mod_id + "' and funcionalidad.fun_id not in "
                    + "(SELECT funcionalidad.fun_id "
                    + "FROM public.modulo, public.rol, public.funcionalidad, public.rolxfuncionalidad "
                    + "where rol.rol_id = rolxfuncionalidad.rol_id and modulo.mod_id = funcionalidad.mod_id and rolxfuncionalidad.fun_id = funcionalidad.fun_id and rol.rol_id = '" + rol_id + "' and modulo.mod_id = '" + mod_id + "'"
                    + ")";
            ResultSet rsnofuns;
            rsnofuns = con.consultarSql(strsql);
            ArrayList<HashMap> listanofuns;
            listanofuns = new ArrayList<HashMap>();
            HashMap h;
            while (rsnofuns.next()) {
                h = new HashMap();
                h.put("fun_id", rsnofuns.getString("fun_id"));
                h.put("fun_nombre", rsnofuns.getString("fun_nombre"));
                listanofuns.add(h);
            }
            datos.put("listanofuns", listanofuns);
        } catch (SQLException ex) {
            System.out.println("se genero un error al listar la funcionalidad");
        }
    }

    public void eliminarRolFun(HashMap datos) {
        try {
            String fun_id;
            String rol_id;
            rol_id = (String) datos.get("rol_id");
            String seleccion = (String) datos.get("seleccion");
            String strsql;
            fun_id = seleccion;
            strsql = "delete from public.rolxfuncionalidad where rolxfuncionalidad.fun_id = '" + fun_id + "' and rolxfuncionalidad.rol_id = '" + rol_id + "'";
            con.ejecutarSql(strsql);
        } catch (SQLException ex) {
            System.out.println("se genero un error al eliminar");
        }
    }

}
