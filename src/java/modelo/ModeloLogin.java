package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import general.ModeloGeneral;

public class ModeloLogin extends general.ModeloGeneral {

    public ModeloLogin() {
        super();
    }

    /**
     * @param nombretabla
     * @param campos
     * @param datos
     * @return
     */
    /**
     * Este método se encarga de validar los usuarios cunado inician sesión, el
     * cual recibe tres parámetros, el primero hace referencia al nombre de la
     * tabla, la cual es la tabla donde esta los usuarios registrados del
     * sistema, el segundo paramento es de campos, el cual hace referencia al
     * usuario y clave de las personas, el tercer hace referencia a los datos
     * que ºtrae y envía los campos del request para ser validado, este método
     * retorna un boolean, si es true el usuario es valido y un false el usuario
     * no es valido
     */
    public boolean verificarUsuario(HashMap datos) {
        if (verificar("usuario", "usu_clave,usu_usuario", datos)) {
            return true;
        }
        return false;

    }

    public void buscarUsuario(HashMap datos) {
        buscar("listarRoles", "ro.rol_id,ro.rol_nombre",
                "usuario as usu, rol as ro, usuarioxrol as usr",
                "usu.per_id=usr.per_id and ro.rol_id=usr.rol_id",
                "usu_usuario", datos);
    }

    public void buscarFuncionalidades(HashMap datos) {
        buscar(
                "listarFuncionalidades",
                "fun.fun_id,fun.fun_nombre,mo.mod_nombre",
                "usuario as usu, rol as ro, usuarioxrol as usr, modulo as mo, "
                + "funcionalidad as fun, rolxfuncionalidad as rf",
                "usu.per_id=usr.per_id and ro.rol_id=usr.rol_id and "
                + "fun.mod_id=mo.mod_id and "
                + "rf.rol_id=ro.rol_id and rf.fun_id=fun.fun_id",
                "usu_usuario,ro.rol_id", datos);
    }

    public void buscarModulo(HashMap datos) {
        buscar(
                "buscarModulos",
                "mo.mod_nombre",
                "usuario as usu, rol as ro, usuarioxrol as usr, modulo as mo, "
                + "funcionalidad as fun, rolxfuncionalidad as rf",
                "usu.per_id=usr.per_id and ro.rol_id=usr.rol_id and "
                + "fun.mod_id=mo.mod_id and "
                + "rf.rol_id=ro.rol_id and rf.fun_id=fun.fun_id",
                "usu_usuario,ro.rol_id", datos);
    }
}
