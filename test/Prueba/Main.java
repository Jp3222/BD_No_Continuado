package Prueba;

import com.jsql.conexion.Conexion;
import com.jsql.conexion.Tablas;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

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
        Conexion cn = Conexion.getInstancia("root", "12345", Conexion.getLOCAL_URL("3306", "company"));
        cn.conectar();
    }
}
