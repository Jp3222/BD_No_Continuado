package Prueba;

import com.jsql.conexion.Conexion;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Conexion cn = Conexion.getNodo("root", "12345", Conexion.LOCAL_URL + "tienda");
        cn.conectar();
    }

}
