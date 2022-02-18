package com.jsql.conexion;

import com.jsql.sentencias.Func;
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

    private static final String LOCAL_URL = "jdbc:mysql://localhost/";

    public static String getLOCAL_URL(String db) {
        return LOCAL_URL + db;
    }

    public static String getLocal_Url(String port, String DB) {
        return "jdbc:mysql://localhost:" + port + "/" + DB;
    }

    private static Conexion Nodo;

    private static final Logger LOG = Logger.getLogger(Conexion.class.getName());

    /**
     * getNodo - Metodo encargado de instanciar la clase 
     *
     * @param user - usuario de la base de datoa.
     * @param pass - contraseña de la base de datos.
     * @param url - direccion de la base de datos.
     * @return Nodo retorna una instancia de tipo conexion.
     */
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
    private Pre_Querys pq;

    protected Conexion(String user, String pass, String url) {
        super(user, pass, url);
        sent = new SQL();

    }

    @Override
    public void conectar() {
        super.conectar();
        Pre_Querys();
    }

    private void Pre_Querys() {
        pq = new Pre_Querys(getCn());
    }

    public boolean add_Pre_Query(String Query) throws SQLException {
        return pq.add_Pre_Query(Query);
    }

    public void setString(int query, int p, String param) throws SQLException {
        pq.setString(query, p, param);
    }

    public ResultSet executeQuery(int query) throws SQLException {
        return pq.executeQuery(query);
    }

    public ResultSet Execute_Pre_Query(int query) {
        try {
            return pq.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        throw new NullPointerException("Query no listado");
    }

    public String getCampos_Columas(String[] campos, String[] datos) {
        return Func.getCampos_Datos(campos, datos);
    }

    public String getColumnas(String... columnas) {
        return Func.getColumas(columnas);
    }

    public String getDatos(String... Datos) {
        return Func.getDatos(Datos);
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

    public SQL getSentencias() {
        return sent;
    }

}
