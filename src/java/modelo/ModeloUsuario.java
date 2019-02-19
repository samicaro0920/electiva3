package modelo;

import db.Conexion;
import general.ModeloGeneral;
import general.VistaGeneral;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloUsuario extends ModeloGeneral{

    public ModeloUsuario() {

    }

    /**
     *
     * @param x HashMap que contendra cada uno de los campos de la tabla persona
     * y usuario que se desea imprimir
     */
    public void insertarPersona(HashMap x) {
        insertar("persona", "per_id,per_nombre,per_apellido,per_fecha_nacimiento,per_direccion,per_correo", x);
    }

    public void insertarUsuario(HashMap x) {
        insertar("usuario", "per_id,usu_clave,usu_usuario", x);
    }

    public void eliminarUsuario(HashMap x) {
        eliminar("usuario", "per_id", x);
    }

    public void actualizarPersona(HashMap x) throws ParseException {
        actualizar("persona", "per_id,per_nombre,per_apellido,per_fecha_nacimiento,per_direccion,per_correo", x);
    }

    public void actualizarUsuario(HashMap x) {
        actualizar("usuario", "per_id,usu_clave,usu_usuario", x);
    }

    public void eliminarPermiso(HashMap x) {
        eliminar("usuarioxrol", "per_id,rol_id", x);
    }

    public void insertarPermiso(HashMap x) {
        insertar("usuarioxrol", "per_id,rol_id", x);
    }

    public void listarUsuario(HashMap x) {
        listar("datos", "per.per_id,per.per_nombre,usu.usu_clave,usu.usu_usuario", "usuario as usu,persona as per", "usu.per_id=per.per_id", x);
        
    }
    
   

    public void listarActulizarForm(HashMap x) {
      
         listarActualizarForm("valores","id,nombre,apellido,fecha_nacimiento,direccion,correo,clave,usuario","per_id,per_nombre,per_apellido,per_fecha_nacimiento,per_direccion,per_correo,usu_clave,usu_usuario","per.per_id,per.per_nombre,per.per_apellido,per.per_per_fecha_nacimiento,per.per_direccion,per.per_correo,usu.usu_clave,usu.usu_usuario", "usuario as usu,persona as per", "usu.per_id=per.per_id", x);

    }

    public void listaPersonaPermisos(HashMap x) {
        
         listarActualizarForm("datos","id,nombre,usuario",
                 "per_id,per_nombre,usu_usuario",
                 "per.per_id,per.per_nombre,usu.usu_usuario",
                 "usuario as usu,persona as per", "usu.per_id=per.per_id", x);
    

    }

    

        
    public void desplegableUsuRol(HashMap x) {
//        listarActualizarForm("datos1","id,nombre","rol_id,rol_nombre",
//                 "ur.per_id,ro.rol_id,ur.rol_id",
//                 "usuarioxrol as ur, rol as ro", "ro.rol_id=ur.rol_id", x);
        HashMap temp;
        try {
            ResultSet rs;
            String sql = "select * from usuarioxrol as ur, rol as ro "
                    + "where ro.rol_id=ur.rol_id and ur.per_id='" + x.get("per_id") + "' ";
            rs = super.conexion.consultarSql(sql);
            ArrayList<HashMap> listaroles = new ArrayList<HashMap>();
            if (rs.isBeforeFirst())//pregunta que se pare antes del primero
            {
                while (rs.next()) {
                    temp = new HashMap();
                    temp.put("id", rs.getString("rol_id"));
                    temp.put("nombre", rs.getString("rol_nombre"));
                    listaroles.add(temp);
                }
            }
            x.put("datos1", listaroles);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void desplegableUsuRolExcept(HashMap x) {
//          listarActualizarForm("datos1","id,nombre","rol_id,rol_nombre",
//                 "ur.per_id,ro.rol_id,ro.rol_nombre",
//                 "usuarioxrol as ur, rol as ro", "ro.rol_id=ur.rol_id", x);
        
        HashMap temp;
        try {
            ResultSet rs;
            String sql = "select ro.rol_id,ro.rol_nombre from rol as ro "
                    + "except "
                    + "select ro.rol_id,ro.rol_nombre from usuarioxrol as ur, rol as ro "
                    + "where ro.rol_id=ur.rol_id and ur.per_id='" + x.get("per_id") + "' ";
            rs = super.conexion.consultarSql(sql);
            ArrayList<HashMap> listaroles = new ArrayList<HashMap>();
            if (rs.isBeforeFirst())//pregunta que se pare antes del primero
            {
                while (rs.next()) {
                    temp = new HashMap();
                    temp.put("id", rs.getString("rol_id"));
                    temp.put("nombre", rs.getString("rol_nombre"));
                    listaroles.add(temp);
                }
            }
            x.put("datos2", listaroles);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
