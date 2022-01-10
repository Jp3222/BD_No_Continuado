package Prueba;

import com.jsql.conexion.Conexion;
import com.jsql.conexion.Tablas;
import java.sql.SQLException;
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
        Conexion cn = Conexion.getNodo("root", "12345", Conexion.LOCAL_URL + "Tienda");
        cn.conectar();//se hace la conexion
        
        cn.add_Pre_Query(cn.sentencias().SELECT("productos", "*", "precio > ?"));
        cn.setString(0, 1, "20");
        Tablas t = new Tablas();
        //ArrayList<String[]> array = t.Tabla_String(cn.Execute_Pre_Query(0), Productos);
        String[][] array = t.Tabla(cn.Execute_Pre_Query(0), Productos);
        for (String[] strings : array) {
            System.out.println(Arrays.toString(strings));
        }
    }

}
