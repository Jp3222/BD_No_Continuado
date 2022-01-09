package com.jsql.conexion;

import com.jsql.sentencias.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Conexion extends BD {

    public static String LOCAL_URL = "jdbc:mysql://localhost:3306/";

    private static Conexion Nodo;

    private static final Logger LOG = Logger.getLogger(Conexion.class.getName());

    public static Conexion getNodo(String user, String pass, String url) {
        if (Nodo == null) {
            Nodo = new Conexion(user, pass, url);
        }
        return Nodo;
    }

    public static Conexion getNodo() {
        return Nodo;
    }
    private Statement st;
    private final SQL sent;

    protected Conexion(String user, String pass, String url) {
        super(user, pass, url);
        sent = new SQL();
    }

    public String Valores(String[] campos, String[] datos) {
        return SQL.getCampos_Datos(campos, datos);
    }

    public String getColumnas(String... columnas) {
        return SQL.getColumas(columnas);
    }

    public String getDatos(String... Datos) {
        return SQL.getDatos(Datos);
    }

    public ResultSet select(String Tabla, String Campo, String Where) throws SQLException {
        st = getCn().createStatement();
        return st.executeQuery(sent.SELECT(Tabla, Campo, Where));
    }

    public ResultSet select(String Tabla, String Campo) throws SQLException {
        st = getCn().createStatement();
        return st.executeQuery(sent.SELECT(Tabla, Campo));
    }

    public void update(String Tabla, String data, String where) throws SQLException {
        st = getCn().createStatement();
        st.executeUpdate(sent.UPDATE(Tabla, data, where));
    }

    public void update(String Tabla, String campo, String dato, String where) throws SQLException {
        st = getCn().createStatement();
        st.executeUpdate(sent.UPDATE(Tabla, campo, dato, where));
    }

    public void DELETE(String Tabla, String where) throws SQLException {
        st = getCn().createStatement();
        st.executeUpdate(sent.DELETE(Tabla, where));
    }

    public void insert(String Tabla, String Campos, String Values) throws SQLException {
        st = getCn().createStatement();
        st.execute(sent.INSERT(Tabla, Campos, Values));
    }

    public void insert(String Tabla, String Values) throws SQLException {
        st = getCn().createStatement();
        st.execute(sent.INSERT(Tabla, Values, Values));
    }

}
