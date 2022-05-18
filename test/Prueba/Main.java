package Prueba;

import com.jsql.conexion.Conexion;
import com.jsql.conexion.NewConexion;
import java.sql.SQLException;

public class Main {

    public static final String Productos[] = {
        "ID",
        "Clave",
        "Nombre",
        "Marca",
        "Contenido",
        "UDM",
        "Precio"
    };

    public static void main(String[] args) throws SQLException {
        NewConexion cn = new NewConexion("jp", "12345", Conexion.getLOCAL_URL_MYSQL(0,"3306", "jshop"));
        System.out.println(cn.isConexion());
    }
}
