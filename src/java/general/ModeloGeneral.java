package general;

import db.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ModeloModFun;

public class ModeloGeneral {

    protected Conexion conexion;

    public ModeloGeneral(){
        try {
            conexion = new Conexion();
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

    public boolean verificar(String nombretabla, String campos, HashMap datos) {
        try {
            String[] campo = campos.split(",");
            String strsql = "select * "
                    + "from " + nombretabla
                    + " where ";

            for (int i = 0; i < campo.length; i++) {
                strsql = strsql + campo[i] + " = '" + datos.get(datos.keySet().toArray()[i + 1]) + "'";
                if (i < campo.length - 1) {
                    strsql = strsql + " and ";
                }
            }
            ResultSet rs;
            rs = conexion.consultarSql(strsql);
            if (rs.isBeforeFirst()) {
                return true;
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Se genero un error al validar");
        }
        return false;
    }

    public void insertar(String tabla, String campos, HashMap datos) {
        try {
            String[] campos_separados = campos.split(",");
            StringBuilder sql = new StringBuilder();
            sql.append("insert into ").append(tabla).append("(").append(campos).append(") values (");
            for (int i = 0; i < campos_separados.length; i++) {
                sql.append("'").append(datos.get(campos_separados[i])).append("'");

                if (i != (campos_separados.length - 1)) {
                    sql.append(",");
                }
            }
            sql.append(")");
            System.out.println("consultaaaaaa " + sql);
            int rs;
            rs = this.conexion.ejecutarSql(sql.toString());
            if (rs > 0) {
                datos.put("mensaje", "Registrado");
            } else {
                datos.put("mensaje", "No registrado");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void listar(String nombreLista, String select, String from, String union, HashMap datos) {
        StringBuilder sql = new StringBuilder();
        try {

            String selec = select.replace(".", ",");
            String c[] = selec.split(",");
            if (union.equals("")) {
                sql.append("select ").append(select).append(" from ").append(from);
            } else {
                System.out.println("entreeeeeeeeeeeeeeeee------");
                sql.append("select ").append(select).append(" from ").append(from).append(" where ");
            }
            if (!union.isEmpty()) {
                sql.append(union);
            }
            System.out.println("-" + sql.toString());
            ResultSet rs;
            rs = this.conexion.consultarSql(sql.toString());
            System.out.println("++" + sql);
            ArrayList<HashMap> listaDatos = new ArrayList<HashMap>();
            HashMap r;
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    r = new HashMap();
                    for (int i = 0; i < c.length; i++) {
                        if (i % 2 != 0) {
                            r.put(c[i], rs.getString(c[i]));
                        }
                    }
                    listaDatos.add(r);
                }
                System.out.println("++" + listaDatos);
            }
            datos.put(nombreLista, listaDatos);
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

     public void listarActualizarForm(String nombreLista,String camposT,String camposDB,String select, String from, String union, HashMap datos) {
        StringBuilder sql = new StringBuilder();
        try {
         String selec = select.replace(".", ",");
         String[] campos_separados = selec.split(",");
          String[] nombre_separados = camposT.split(",");
          String[] nombre_separadosDB = camposDB.split(",");
         String c[] = union.split("=");
         if (union.equals("")) {
             
                sql.append("select *").append(" from ").append(from).append(" where ").append(nombre_separadosDB[0]).append(" = ").append("'").append(datos.get(campos_separados[1])).append("'");
         
         } else {
                sql.append("select *").append(" from ").append(from).append(" where ");
         }
            if (!union.isEmpty()) {
             
                sql.append(union).append(" and ").append(c[1]).append(" = ").append("'").append(datos.get(campos_separados[1])).append("'");
        
            }
        
        
            ResultSet rs;
            rs = this.conexion.consultarSql(sql.toString());
            HashMap r=new HashMap();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    r = new HashMap();
                   for (int i = 0; i <nombre_separados.length ; i++) {
                        r.put(nombre_separados[i], rs.getString(nombre_separadosDB[i]));
                      
                    }
                 
                }
            }
            System.out.println(",, "+ sql);
            datos.put(nombreLista, r);
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public void eliminar(String tabla, String campos, HashMap datos) {
        try {
            System.out.println("****" + datos.get("Id"));
            String[] campos_separados = campos.split(",");
            System.out.println("aaa  " + Arrays.toString(campos_separados));
            StringBuilder sql = new StringBuilder();
            sql.append("delete from ").append(tabla).append(" where ");
            System.out.println("--" + campos_separados.length);
            for (int i = 0; i < campos_separados.length; i++) {
                sql.append(campos_separados[i]).append("=");
                sql.append("'").append(datos.get(campos_separados[i])).append("'");
                if (i != (campos_separados.length - 1)) {
                    sql.append(" and ");
                }
            }
            sql.append("");
            System.out.println("este es el sql  " + sql.toString());
            int rs;
            rs = this.conexion.ejecutarSql(sql.toString());
            if (rs > 0) {
                datos.put("mensaje", "Eliminado");
            } else {
                datos.put("mensaje", "No Eliminado");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void actualizar(String tabla, String campos, HashMap datos) {
        //El PRIMER DATO EN EL PARAMETRO CAMPOS TIENE QUE SER EL ID
        try {
            String[] campos_separados = campos.split(",");
            System.out.println("aaa  " + Arrays.toString(campos_separados));
            StringBuilder sql = new StringBuilder();
            sql.append("update ").append(tabla).append(" set ");
            for (int i = 1; i < campos_separados.length; i++) {
                sql.append(campos_separados[i]).append("=");
                sql.append("'").append(datos.get(campos_separados[i])).append("'");
                if (i != (campos_separados.length - 1)) {
                    sql.append(",");
                }
            }
            sql.append(" where ").append(campos_separados[0]).append("=").append("'").append(datos.get(campos_separados[0])).append("'");
            System.out.println("sql " + sql.toString());
            int rs;
            rs = this.conexion.ejecutarSql(sql.toString());
            if (rs > 0) {
                datos.put("mensaje", "Actualizado");
            } else {
                datos.put("mensaje", "Noooooooooooooooooooooooooooooooo ");
            }
            System.out.println("aaa "+ sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void buscar(String nombreLista, String select, String from, String union, String campo, HashMap datos) {
        StringBuilder sql = new StringBuilder();

        try {

            String campos[] = campo.split(",");
            String selec = select.replace(".", ",");
            String c[] = selec.split(",");

            sql.append("select ").append(select).append(" from ").append(from).append(" where ");

            if (!union.isEmpty()) {
                sql.append(union).append(" and ");
            }

            for (int i = 0; i < campos.length; i++) {
                sql.append(campos[i]).append(" = '").append(datos.get(campos[i])).append("'");
                if (i < campos.length - 1) {
                    sql.append(" and ");
                }
            }
            System.out.println(sql.toString());

            ResultSet rs;
            rs = this.conexion.consultarSql(sql.toString());
            ArrayList<HashMap> listaDatos = new ArrayList<HashMap>();
            HashMap r;
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    r = new HashMap();
                    for (int i = 0; i < c.length; i++) {
                        if (i % 2 != 0) {
                            r.put(c[i], rs.getString(c[i]));
                        }
                    }
                    listaDatos.add(r);
                }
            }
            datos.put(nombreLista, listaDatos);
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
