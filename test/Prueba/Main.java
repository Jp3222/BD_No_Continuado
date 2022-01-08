package Prueba;

import com.jsql.conexion.Tablas;
import com.jsql.database.DB;
import com.jsql.database.TB;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        DB tienda = new DB("jp", "12345", "jdbc:mysql://localhost/tienda");
        TB t1 = tienda.getTabla("");
        Tablas tb = new Tablas();
        tb.Tabla_String(tienda.select("x", "*"), t1.getColumnas());
    }

}
